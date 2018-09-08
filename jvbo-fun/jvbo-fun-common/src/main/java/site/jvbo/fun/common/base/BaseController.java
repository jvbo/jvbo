/*
 * BaseController.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.base;

import com.alibaba.fastjson.JSONObject;
import com.baidu.unbiz.fluentvalidator.ValidationError;

public class BaseController {
    
    /**
     * 返回校验错误信息
     * @param code
     * @param error
     * @return
     */
    public String renderValidateFail(String code, ValidationError error) {
        return render(code, error.getErrorMsg(), null);
    }

    /**
     * 返回精简数据
     * @param code
     * @param msg
     * @return
     */
    public String render(String code, String msg) {
        return render(code, msg, null);
    }

    /**
     * 返回结果
     * @param code 返回码
     * @param msg 返回信息
     * @param data 返回数据
     * @return
     */
    public String render(String code, String msg, Object data) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result.toJSONString();
    }
}
