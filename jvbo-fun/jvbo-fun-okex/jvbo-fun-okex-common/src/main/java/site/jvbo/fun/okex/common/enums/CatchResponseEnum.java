package site.jvbo.fun.okex.common.enums;

import site.jvbo.fun.common.enums.IEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
public enum CatchResponseEnum implements IEnum {
	RESULT("result", "返回"),
	SPOT("ok_sub_spot", "现货"),
	FUTURE("ok_sub_futureusd", "合约"),
	TICKER("ticker", "行情"),
	KLINE("kline", "k线"),
	DEPTH("depth", "深度"),
	TRADE("trade", "交易"),
	AGG_TRADE("aggTrade", "聚合"),
	INDEX("index", "指数");

	CatchResponseEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	private String code;

	private String name;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}

}
