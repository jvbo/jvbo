package site.jvbo.fun.common.enums;

/**
 * 编码枚举
 */
public enum EnCodingEnum implements IEnum {

    UTF8("UTF-8", "UTF-8"),
    GBK("GBK", "GBK");

    EnCodingEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

	public static final String TYPE_CODE = "enCodingEnum";

	/**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
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
