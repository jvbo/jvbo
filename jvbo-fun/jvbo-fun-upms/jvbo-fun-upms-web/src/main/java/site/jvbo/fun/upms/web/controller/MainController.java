package site.jvbo.fun.upms.web.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import site.jvbo.fun.common.base.BaseController;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.validator.LengthValidator;
import site.jvbo.fun.common.validator.NotNullValidator;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.*;
import site.jvbo.fun.upms.service.IUpmsPermissionService;
import site.jvbo.fun.upms.service.IUpmsSystemService;
import site.jvbo.fun.upms.service.IUpmsUserService;

import java.util.List;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/10
 */
@Controller
@Api(value = "后台管理", description = "后台管理")
public class MainController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private IUpmsSystemService upmsSystemService;
	@Autowired
	private IUpmsPermissionService upmsPermissionService;
	@Autowired
	private IUpmsUserService upmsUserService;

	@ApiOperation(value = "后台登录")
	@GetMapping("/login")
	public String loginPage(ModelMap modelMap) {
		return "login";
	}

	@ApiOperation(value = "后台登录请求")
	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestParam String username, @RequestParam String password) {
		ComplexResult result = FluentValidator.checkAll()
				.on(username, new NotNullValidator("用户名"))
				.on(password, new NotNullValidator("密码"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors().get(0));
		}

		if(!(username.equalsIgnoreCase("admin") &&
				password.equalsIgnoreCase("admin"))){
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(), ResponseCodeEnum.BAD_REQUEST.getName(), "false");
		}

		Subject subject = SecurityUtils.getSubject();
		/*Session session = subject.getSession();
		String sessionId = session.getId().toString();*/
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		//usernamePasswordToken.setRememberMe(true);
		subject.login(usernamePasswordToken);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), "true");
	}

	@GetMapping("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		// TODO 登出
	}

	@ApiOperation(value = "后台首页")
	@GetMapping("/index")
	public String index(ModelMap modelMap) {
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria()
				.andStateEqualTo(1);
		List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
		modelMap.put("upmsSystems", upmsSystems);

		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();

		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria()
				.andUsernameEqualTo(username);
		UpmsUser upmsUser = upmsUserService.selectFirstByExample(upmsUserExample);
		List<UpmsPermission> upmsPermissions = upmsPermissionService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
		modelMap.put("upmsPermissions", upmsPermissions);
		return "index";
	}

}