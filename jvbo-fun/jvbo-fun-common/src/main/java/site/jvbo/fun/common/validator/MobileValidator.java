package site.jvbo.fun.common.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

import java.util.regex.Pattern;

public class MobileValidator extends ValidatorHandler<String> implements Validator<String> {

	@Override
	public boolean validate(ValidatorContext context, String s) {
		if (null == s || s.length() != 11) {
			context.addError(ValidationError.create(String.format("%s长度必须为%s！", "手机号码", 11)));
			return false;
		} else if(!Pattern.matches("1\\d{10}", s)) {
			context.addError(ValidationError.create(String.format("%s格式错误", "手机号码")));
			return false;
		} else if(!Pattern.matches("17\\d{9}", s)) {
			context.addError(ValidationError.create(String.format("%s限制", "手机号码")));
		}
		return true;
	}
	
}
