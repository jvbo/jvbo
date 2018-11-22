package site.jvbo.fun.upms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import site.jvbo.fun.common.base.BaseController;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.upms.dao.model.*;
import site.jvbo.fun.upms.service.IUpmsPermissionService;
import site.jvbo.fun.upms.service.IUpmsSystemService;
import site.jvbo.fun.upms.service.IUpmsUserService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/10
 */
@Controller
@ApiIgnore
@Api(tags = "后台主入口", description = "后台主入口")
public class MainController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private IUpmsSystemService upmsSystemService;
	@Autowired
	private IUpmsUserService upmsUserService;
	@Autowired
	private IUpmsPermissionService upmsPermissionService;

	@ApiIgnore
	@ApiOperation(value = "后台首页")
	@GetMapping("/")
	public String index() throws Exception {
		return "redirect:/index";
	}

	@ApiIgnore
	@ApiOperation(value = "后台首页页面")
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
		upmsUserExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsLockedEqualTo(PublicEnum.FALSE.getCodeInt()).andUsernameEqualTo(username);
		UpmsUser upmsUser = upmsUserService.selectFirstByExample(upmsUserExample);
		modelMap.put("upmsUser", upmsUser);

		Long userId = upmsUser.getUserId();
		UpmsRole upmsRole = upmsPermissionService.selectUpmsRoleByUpmsUserId(userId).get(0);
		modelMap.put("upmsRole", upmsRole);

		List<UpmsPermission> upmsPermissions = upmsPermissionService.selectUpmsPermissionByUpmsUserId(userId);
		modelMap.put("upmsPermissions", upmsPermissions);
		return "index";
	}

	@ApiIgnore
	@ApiOperation(value = "后台首页默认内嵌页面")
	@GetMapping("/indexInner")
	public String indexInner(ModelMap modelMap) {
		return "index_inner";
	}
}