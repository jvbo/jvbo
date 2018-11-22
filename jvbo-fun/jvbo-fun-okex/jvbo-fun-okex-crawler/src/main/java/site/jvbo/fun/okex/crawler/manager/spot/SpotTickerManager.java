package site.jvbo.fun.okex.crawler.manager.spot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.common.util.CodeUtil;
import site.jvbo.fun.okex.common.util.OkexCodeUtil;
import site.jvbo.fun.okex.crawler.avro.OkexSpotTickerAvro;
import site.jvbo.fun.okex.crawler.avro.OkexSpotTickerDataAvro;
import site.jvbo.fun.okex.dao.model.OkexChannel;
import site.jvbo.fun.okex.dao.model.OkexChannelExample;
import site.jvbo.fun.okex.dao.model.OkexSpotTicker;
import site.jvbo.fun.okex.dao.model.OkexSpotTickerExample;
import site.jvbo.fun.okex.service.IOkexChannelService;
import site.jvbo.fun.okex.service.IOkexSpotTickerService;

import java.io.File;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
@Component
public class SpotTickerManager {
	private static final Logger logger = LoggerFactory.getLogger(SpotTickerManager.class);

	private @Value("${spotticker.origin.file.path.prefix}") String spotTickerOriginFilePathPrefix;
	private @Value("${spotticker.origin.file.path.suffix}") String spotTickerOriginFilePathSuffix;
	@Value("${market.name}")private String market;

	@Autowired
	private IOkexChannelService okexChannelService;
	@Autowired
	private IOkexSpotTickerService okexSpotTickerService;

	public boolean spotTickerBs(Long timestamp, String channel, String data){
		// 入库
		JSONObject dataJo = JSON.parseObject(data);
		BigDecimal high = dataJo.getBigDecimal("high");
		BigDecimal vol = dataJo.getBigDecimal("vol");
		BigDecimal last = dataJo.getBigDecimal("last");
		BigDecimal low = dataJo.getBigDecimal("low");
		BigDecimal buy = dataJo.getBigDecimal("buy");
		BigDecimal change = dataJo.getBigDecimal("change");
		BigDecimal sell = dataJo.getBigDecimal("sell");
		BigDecimal dayLow = dataJo.getBigDecimal("dayLow");
		BigDecimal close = dataJo.getBigDecimal("close");
		BigDecimal dayHigh = dataJo.getBigDecimal("dayHigh");
		BigDecimal open = dataJo.getBigDecimal("open");

		OkexChannelExample okexChannelExample = new OkexChannelExample();
		okexChannelExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsOnlinedEqualTo(PublicEnum.TRUE.getCodeInt())
				.andChannelEqualTo(channel);
		OkexChannel okexChannel = okexChannelService.selectFirstByExample(okexChannelExample);
		Long channelId = okexChannel.getChannelId();

		OkexSpotTicker record = new OkexSpotTicker();
		record.setChannelId(channelId);
		record.setHigh(high);
		record.setVol(vol);
		record.setLast(last);
		record.setLow(low);
		record.setBuy(buy);
		record.setChange(change);
		record.setSell(sell);
		record.setDayLow(dayLow);
		record.setClose(close);
		record.setDayHigh(dayHigh);
		record.setOpen(open);
		record.setTimestamp(timestamp);

		OkexSpotTickerExample okexSpotTickerExample = new OkexSpotTickerExample();
		okexSpotTickerExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andChannelIdEqualTo(channelId);
		OkexSpotTicker okexSpotTicker = okexSpotTickerService.selectFirstByExample(okexSpotTickerExample);
		boolean flag = false;
		if(okexSpotTicker != null){
			record.setSpotTickerId(okexSpotTicker.getSpotTickerId());
			record.setGmtModified(Instant.now().toEpochMilli());
			record.setModifiedBy(Long.valueOf(PublicEnum.ZERO.getCode()));
			flag = okexSpotTickerService.updateByPrimaryKeySelective(record) > 0;
		}else{
			record.setChannelId(channelId);
			record.setGmtCreate(Instant.now().toEpochMilli());
			flag = okexSpotTickerService.insertSelective(record) > 0;
		}
		return flag;
	}

	public boolean spotTickerOrigin(Long timestamp, String channel, String data){
		// 存文件
		long startTimestamp = Instant.now().toEpochMilli();

		String symbol = OkexCodeUtil.dealSpotChannel2Symbol(channel);
		String fileName = DateFormatUtils.format(timestamp, "yyyyMMdd");
		JSONObject dataJo = JSON.parseObject(data);
		String filePath = CodeUtil.genFilePath(spotTickerOriginFilePathPrefix, spotTickerOriginFilePathSuffix, market, symbol, fileName);

		// avro
		OkexSpotTickerDataAvro okexSpotTickerDataAvro = new OkexSpotTickerDataAvro();
		okexSpotTickerDataAvro.setHigh(dataJo.getString("high"));
		okexSpotTickerDataAvro.setVol(dataJo.getString("vol"));
		okexSpotTickerDataAvro.setLast(dataJo.getString("last"));
		okexSpotTickerDataAvro.setLow(dataJo.getString("low"));
		okexSpotTickerDataAvro.setBuy(dataJo.getString("buy"));
		okexSpotTickerDataAvro.setChange(dataJo.getString("change"));
		okexSpotTickerDataAvro.setSell(dataJo.getString("sell"));
		okexSpotTickerDataAvro.setDayLow(dataJo.getString("dayLow"));
		okexSpotTickerDataAvro.setClose(dataJo.getString("close"));
		okexSpotTickerDataAvro.setDayHigh(dataJo.getString("dayHigh"));
		okexSpotTickerDataAvro.setOpen(dataJo.getString("open"));
		okexSpotTickerDataAvro.setTimestamp(dataJo.getLong("timestamp"));
		OkexSpotTickerAvro okexSpotTickerAvro = new OkexSpotTickerAvro();
		okexSpotTickerAvro.setTimestamp(timestamp);
		okexSpotTickerAvro.setMarket(market);
		okexSpotTickerAvro.setSymbol(symbol);
		okexSpotTickerAvro.setData(okexSpotTickerDataAvro);
		try {
			// 序列化
			File file = new File(filePath);
			if(!file.exists()){
				if(!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}
			long fileLength = file.length();

			DatumWriter<OkexSpotTickerAvro> datumWriter = new SpecificDatumWriter<>(OkexSpotTickerAvro.class);
			DataFileWriter<OkexSpotTickerAvro> dataFileWriter = new DataFileWriter<>(datumWriter);
			dataFileWriter.setCodec(CodecFactory.snappyCodec());
			if(fileLength == 0){
				dataFileWriter.create(okexSpotTickerAvro.getSchema(), file);
			}else{
				dataFileWriter.appendTo(file);
			}
			dataFileWriter.append(okexSpotTickerAvro);
			dataFileWriter.close();

			// 反序列化
			/*DatumReader<OkexSpotTickerAvro> datumReader = new SpecificDatumReader<>(OkexSpotTickerAvro.class);
			DataFileReader<OkexSpotTickerAvro> dataFileReader = new DataFileReader<>(file, datumReader);
			OkexSpotTickerAvro okexSpotTickerAvroReader = null;
			while (dataFileReader.hasNext()){
				okexSpotTickerAvroReader = dataFileReader.next(okexSpotTickerAvroReader);
				logger.info("deserialize: {}", okexSpotTickerAvroReader);
			}
			dataFileReader.close();*/
		} catch (Exception e) {
			logger.error("error, 异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
		}
		logger.info("耗时(millSecond):{}", Instant.now().toEpochMilli() - startTimestamp);
		return true;
	}
}
