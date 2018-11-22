package site.jvbo.fun.okex.crawler.manager.future;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.okex.common.util.OkexCodeUtil;
import site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro;
import site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro;
import site.jvbo.fun.okex.dao.model.OkexChannel;
import site.jvbo.fun.okex.dao.model.OkexChannelExample;
import site.jvbo.fun.okex.dao.model.OkexFutureTicker;
import site.jvbo.fun.okex.dao.model.OkexFutureTickerExample;
import site.jvbo.fun.okex.service.IOkexChannelService;
import site.jvbo.fun.okex.service.IOkexFutureTickerService;

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
public class FutureTickerManager {
	private static final Logger logger = LoggerFactory.getLogger(FutureTickerManager.class);

	private @Value("${futureticker.origin.file.path.prefix}") String futureTickerOriginFilePathPrefix;
	private @Value("${futureticker.origin.file.path.suffix}") String futureTickerOriginFilePathSuffix;
	@Value("${market.name}")private String market;
	@Autowired
	private IOkexChannelService okexChannelService;
	@Autowired
	private IOkexFutureTickerService okexFutureTickerService;

	public boolean futureTickerBs(Long timestamp, String channel, String data) {
		// 入库
		JSONObject dataJo = JSON.parseObject(data);
		BigDecimal high =  dataJo.getBigDecimal("high");
		BigDecimal limitLow = dataJo.getBigDecimal("limitLow");
		BigDecimal vol = dataJo.getBigDecimal("vol");
		BigDecimal last = dataJo.getBigDecimal("last");
		BigDecimal low = dataJo.getBigDecimal("low");
		BigDecimal buy = dataJo.getBigDecimal("buy");
		BigDecimal holdAmount = dataJo.getBigDecimal("hold_amount");
		BigDecimal sell = dataJo.getBigDecimal("sell");
		Long contractId = dataJo.getLong("contractId");
		BigDecimal unitAmount = dataJo.getBigDecimal("unitAmount");
		BigDecimal limitHigh = dataJo.getBigDecimal("limitHigh");

		OkexChannelExample okexChannelExample = new OkexChannelExample();
		okexChannelExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsOnlinedEqualTo(PublicEnum.TRUE.getCodeInt())
				.andChannelEqualTo(channel);
		OkexChannel okexChannel = okexChannelService.selectFirstByExample(okexChannelExample);
		Long channelId = okexChannel.getChannelId();

		OkexFutureTicker record = new OkexFutureTicker();
		record.setChannelId(channelId);
		record.setHigh(high);
		record.setLimitLow(limitLow);
		record.setVol(vol);
		record.setLast(last);
		record.setLow(low);
		record.setBuy(buy);
		record.setHoldAmount(holdAmount);
		record.setSell(sell);
		record.setContractId(contractId);
		record.setUnitAmount(unitAmount);
		record.setLimitHigh(limitHigh);
		record.setTimestamp(timestamp);

		OkexFutureTickerExample okexFutureTickerExample = new OkexFutureTickerExample();
		okexFutureTickerExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andChannelIdEqualTo(channelId);
		OkexFutureTicker okexFutureTicker = okexFutureTickerService.selectFirstByExample(okexFutureTickerExample);
		boolean flag = false;
		if(okexFutureTicker != null){
			record.setFutureTickerId(okexFutureTicker.getFutureTickerId());
			record.setGmtModified(Instant.now().toEpochMilli());
			record.setModifiedBy(Long.valueOf(PublicEnum.ZERO.getCode()));
			flag = okexFutureTickerService.updateByPrimaryKeySelective(record) > 0;
		}else{
			record.setChannelId(channelId);
			record.setGmtCreate(Instant.now().toEpochMilli());
			flag = okexFutureTickerService.insertSelective(record) > 0;
		}
		return flag;
	}

	public boolean futureTickerOrigin(Long timestamp, String channel, String data) {
		// 存文件
		long startTimestamp = Instant.now().toEpochMilli();

		String[] symbolFutureType = OkexCodeUtil.dealFutureChannel2Symbol(channel);
		String symbol = symbolFutureType[0];
		String futureType = symbolFutureType[1];
		String fileName = DateFormatUtils.format(timestamp, "yyyyMMdd");
		JSONObject dataJo = JSON.parseObject(data);
		String filePath = OkexCodeUtil.genFutureFilePath(futureTickerOriginFilePathPrefix, futureTickerOriginFilePathSuffix, futureType, market, symbol, fileName);

		// avro
		OkexFutureTickerDataAvro okexFutureTickerDataAvro = new OkexFutureTickerDataAvro();
		okexFutureTickerDataAvro.setHigh(dataJo.getString("high"));
		okexFutureTickerDataAvro.setLimitLow(dataJo.getString("limitLow"));
		okexFutureTickerDataAvro.setVol(dataJo.getString("vol"));
		okexFutureTickerDataAvro.setLast(dataJo.getString("last"));
		okexFutureTickerDataAvro.setLow(dataJo.getString("low"));
		okexFutureTickerDataAvro.setBuy(dataJo.getString("buy"));
		okexFutureTickerDataAvro.setHoldAmount(dataJo.getString("hold_amount"));
		okexFutureTickerDataAvro.setSell(dataJo.getString("sell"));
		okexFutureTickerDataAvro.setContractId(dataJo.getString("contractId"));
		okexFutureTickerDataAvro.setUnitAmount(dataJo.getString("unitAmount"));
		okexFutureTickerDataAvro.setLimitHigh(dataJo.getString("limitHigh"));

		OkexFutureTickerAvro okexFutureTickerAvro = new OkexFutureTickerAvro();
		okexFutureTickerAvro.setTimestamp(timestamp);
		okexFutureTickerAvro.setMarket(market);
		okexFutureTickerAvro.setSymbol(symbol);
		okexFutureTickerAvro.setData(okexFutureTickerDataAvro);
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

			DatumWriter<OkexFutureTickerAvro> datumWriter = new SpecificDatumWriter<>(OkexFutureTickerAvro.class);
			DataFileWriter<OkexFutureTickerAvro> dataFileWriter = new DataFileWriter<>(datumWriter);
			dataFileWriter.setCodec(CodecFactory.snappyCodec());
			if(fileLength == 0){
				dataFileWriter.create(okexFutureTickerAvro.getSchema(), file);
			}else{
				dataFileWriter.appendTo(file);
			}
			dataFileWriter.append(okexFutureTickerAvro);
			dataFileWriter.close();

			// 反序列化
			/*DatumReader<OkexFutureTickerAvro> datumReader = new SpecificDatumReader<>(OkexFutureTickerAvro.class);
			DataFileReader<OkexFutureTickerAvro> dataFileReader = new DataFileReader<>(file, datumReader);
			OkexFutureTickerAvro okexFutureTickerAvroReader = null;
			while (dataFileReader.hasNext()){
				okexFutureTickerAvroReader = dataFileReader.next(okexFutureTickerAvroReader);
				logger.info("deserialize: {}", okexFutureTickerAvroReader);
			}
			dataFileReader.close();*/
		} catch (Exception e) {
			logger.error("error, 异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
		}
		logger.info("耗时(millSecond):{}", Instant.now().toEpochMilli() - startTimestamp);
		return true;
	}
}
