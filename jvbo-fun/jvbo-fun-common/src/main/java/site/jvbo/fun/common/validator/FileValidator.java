package site.jvbo.fun.common.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.util.Arrays;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date 2016年2月26日
 */
public class FileValidator extends ValidatorHandler<File> implements Validator<File> {

	@Override
	public boolean validate(ValidatorContext context, File file) {
		String[] fileTypeBetweenArr = new String[]{".jpg", ".jpeg", ".png"};
		long fileMax = 10 * 1024 * 1024L; // 字节
		String fileName = file.getName();
		if(!ArrayUtils.contains(fileTypeBetweenArr, fileName.substring(fileName.lastIndexOf(".") + 1))){
			context.addError(ValidationError.create(String.format("%s类型必须为%s！", "文件", Arrays.toString(fileTypeBetweenArr))));
			return false;
		}
		if(fileMax <= file.length()){
			context.addError(ValidationError.create(String.format("%s大小必须小于%s！", "文件", fileMax)));
			return false;
		}
		return true;
	}
}
