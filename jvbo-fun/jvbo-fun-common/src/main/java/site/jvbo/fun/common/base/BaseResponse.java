package site.jvbo.fun.common.base;

public class BaseResponse {

    /**
     * 状态码
     */
    public int code;

    /**
     * 提示信息
     */
    public String msg;

    /**
     * 数据结果集
     */
    public Object data;

	public BaseResponse(){}

    public BaseResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

	public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
