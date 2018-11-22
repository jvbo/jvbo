package site.jvbo.fun.upms.web.controller.sso;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.validator.NotNullValidator;
import site.jvbo.fun.upms.common.enums.RedisCacheEnum;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.UpmsSystem;
import site.jvbo.fun.upms.dao.model.UpmsSystemExample;
import site.jvbo.fun.upms.service.IUpmsSystemService;
import site.jvbo.fun.upms.service.IUpmsUserService;
import site.jvbo.fun.upms.web.shiro.session.UpmsSession;
import site.jvbo.fun.upms.web.shiro.session.UpmsSessionDao;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/10
 */
@Controller
@RequestMapping("/sso")
@Api(tags = "单点登录管理", description = "单点登录管理")
public class SSOController {
	private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

	@Autowired
	IUpmsSystemService upmsSystemService;
	@Autowired
	IUpmsUserService upmsUserService;
	@Autowired
	UpmsSessionDao upmsSessionDao;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@ApiIgnore
	@ApiOperation(value = "认证中心首页")
	@GetMapping("/index")
	public String index(@RequestParam String appid,
						@RequestParam String backurl) throws Exception {
		if (StringUtils.isBlank(appid)) {
			throw new RuntimeException("无效访问！");
		}
		// 判断请求认证系统是否注册
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andNameEqualTo(appid);
		long count = upmsSystemService.countByExample(upmsSystemExample);
		if (0 == count) {
			throw new RuntimeException(String.format("未注册的系统:%s", appid));
		}
		return "redirect:/sso/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
	}

	@ApiIgnore
	@ApiOperation(value = "登录")
	@GetMapping(value = "/login")
	public String login(@RequestParam(required = false)String backurl) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String serverSessionId = session.getId().toString();
		// 判断是否已登录，如果已登录，则回跳
		String code = redisTemplate.opsForValue().get(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_ID.getCode(), serverSessionId));
		// code校验值
		if (StringUtils.isNotBlank(code)) {
			// 回跳
			logger.info("subject.getPrincipal(): {}", subject.getPrincipal());
			String username = (String) subject.getPrincipal();
			if (StringUtils.isBlank(backurl)) {
				backurl = "/";
			} else {
				if (backurl.contains("?")) {
					backurl += "&upms_code=" + code + "&upms_username=" + username;
				} else {
					backurl += "?upms_code=" + code + "&upms_username=" + username;
				}
			}
			logger.info("认证中心帐号通过，带code回跳：{}", backurl);
			return "redirect:" + backurl;
		}
		return "sso/login";
	}

	@ApiOperation(value = "登录")
	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestParam String username,
						@RequestParam String password,
						@RequestParam String appName,
						@RequestParam(required = false) String backurl,
						@RequestParam(required = false) String rememberMe) {
		ComplexResult result = FluentValidator.checkAll()
				.on(username, new NotNullValidator("用户名"))
				.on(password, new NotNullValidator("密码"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					result.getErrors().get(0).getErrorMsg(),
					result.getErrors().get(0));
		}

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String sessionId = session.getId().toString();
		// 判断是否已登录，如果已登录，则回跳，防止重复登录
		String hasCode = redisTemplate.opsForValue().get(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_ID.getCode(), sessionId));
		// code校验值
		if (StringUtils.isBlank(hasCode)) {
			// 使用shiro认证
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
			try {
				if (StringUtils.isNotBlank(rememberMe)
						&& BooleanUtils.toBoolean(rememberMe)) {
					usernamePasswordToken.setRememberMe(true);
				} else {
					usernamePasswordToken.setRememberMe(false);
				}
				subject.login(usernamePasswordToken);
			}catch (IncorrectCredentialsException e) {
				// 登录密码错误
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.UNAUTHORIZED.getName(), "true");
			} catch (ExcessiveAttemptsException e) {
				// 登录失败次数过多
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.FORBIDDEN.getName(), "true");
			} catch (LockedAccountException e) {
				// 帐号已被锁定
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.UNAUTHORIZED.getName(), "true");
			} catch (DisabledAccountException e) {
				// 帐号已被禁用
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.FORBIDDEN.getName(), "true");
			} catch (ExpiredCredentialsException e) {
				// 帐号已过期
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.FORBIDDEN.getName(), "true");
			} catch (UnknownAccountException e) {
				// 帐号不存在
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.FORBIDDEN.getName(), "true");
			} catch (UnauthorizedException e) {
				// 没有得到相应的授权
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.UNAUTHORIZED.getName(), "true");
			} catch (AuthenticationException e) {
				// 认证过程失败
				return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.FORBIDDEN.getName(), "true");
			}
			// 更新session状态
			upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.ON_LINE);
			// 全局会话sessionId列表，供会话管理
			redisTemplate.opsForList().leftPush(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_IDS.getCode(), ""), sessionId.toString());
			// 默认验证帐号密码正确，创建code
			String code = UUID.randomUUID().toString();
			// 全局会话的code
			redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_ID.getCode(), sessionId), code,
					subject.getSession().getTimeout(), TimeUnit.MILLISECONDS);
			// code校验值
			redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_SERVER_CODE.getCode(), code), code,
					subject.getSession().getTimeout(), TimeUnit.MILLISECONDS);
		}
		// 回跳登录前地址
		if (StringUtils.isBlank(backurl)) {
			UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
			upmsSystemExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
					.andStateEqualTo(PublicEnum.TRUE.getCodeInt())
					.andNameEqualTo(appName);
			UpmsSystem upmsSystem = upmsSystemService.selectFirstByExample(upmsSystemExample);
			backurl = null == upmsSystem ? "/" : upmsSystem.getBasePath();
		}
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), backurl);
	}

	@ApiOperation(value = "退出登录")
	@GetMapping(value = "/logout")
	@ResponseBody
	public Object logout(HttpServletRequest request) {
		// shiro退出登录
		SecurityUtils.getSubject().logout();
		// 跳回原地址
		String redirectUrl = request.getHeader("Referer");
		if (null == redirectUrl) {
			redirectUrl = "/";
		}
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), redirectUrl);
	}

}
