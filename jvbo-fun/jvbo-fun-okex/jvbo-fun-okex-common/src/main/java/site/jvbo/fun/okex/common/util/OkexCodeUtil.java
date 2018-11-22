package site.jvbo.fun.okex.common.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
public class OkexCodeUtil {

	public static String dealSpotChannel2Symbol(String channel){
		String[] channelArr = StringUtils.split(channel, "_");
		String symbol = channelArr[3].concat("_").concat(channelArr[4]);
		return symbol.toUpperCase();
	}

	public static String[] dealFutureChannel2Symbol(String channel){
		String[] channelArr = StringUtils.split(channel, "_");
		String symbol = channelArr[3].toUpperCase();
		String futureType = channelArr[5].concat("_").concat(channelArr[6]);

		String[] result = new String[2];
		result[0] = symbol;
		result[1] = futureType;
		return result;
	}

	/**
	 * 生成文件全路径
	 * @param futureTickerOriginFilePathPrefix 前缀
	 * @param futureTickerOriginFilePathSuffix 后缀
	 * @param futureType 合约类型(this_week/next_week/quarter)
	 * @param market 市场
	 * @param symbol 单币缩写 (大写)
	 * @param fileName 文件名 eg: 20180929开头(日期年月日开头)
	 * @return
	 */
	public static String genFutureFilePath(String futureTickerOriginFilePathPrefix, String futureTickerOriginFilePathSuffix, String futureType, String market, String symbol, String fileName) {
		String dateFileName = StringUtils.substring(fileName, 0, 6);
		StringBuilder sb = new StringBuilder();
		sb.append(futureTickerOriginFilePathPrefix)
				.append(market).append(IOUtils.DIR_SEPARATOR_UNIX)
				.append(symbol).append(IOUtils.DIR_SEPARATOR_UNIX)
				.append(futureType).append(IOUtils.DIR_SEPARATOR_UNIX)
				.append(dateFileName).append(IOUtils.DIR_SEPARATOR_UNIX)
				.append(fileName).append(futureTickerOriginFilePathSuffix);
		return sb.toString();
	}
}
