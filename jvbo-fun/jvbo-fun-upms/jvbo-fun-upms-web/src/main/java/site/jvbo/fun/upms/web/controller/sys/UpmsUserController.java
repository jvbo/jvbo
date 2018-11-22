package site.jvbo.fun.upms.web.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import site.jvbo.fun.common.base.BaseController;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.util.CodeUtil;
import site.jvbo.fun.common.util.MD5Util;
import site.jvbo.fun.common.validator.LengthValidator;
import site.jvbo.fun.common.validator.NotNullValidator;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.*;
import site.jvbo.fun.upms.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/10
 */
@Controller
@Api(tags = "用户管理", description = "用户管理")
@RequestMapping("/manage/user")
public class UpmsUserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UpmsUserController.class);

    @Autowired
    private IUpmsUserService upmsUserService;

    @Autowired
    private IUpmsRoleService upmsRoleService;

    @Autowired
    private IUpmsOrganizationService upmsOrganizationService;

    @Autowired
    private IUpmsUserOrganizationService upmsUserOrganizationService;

    @Autowired
    private IUpmsUserRoleService upmsUserRoleService;

    @Autowired
    private IUpmsUserPermissionService upmsUserPermissionService;

    @ApiOperation(value = "用户首页")
	@RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @ApiOperation(value = "用户组织")
	@RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public String organization(@PathVariable("id") Long id, ModelMap modelMap) {
        // 所有组织
        List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(new UpmsOrganizationExample());
        // 用户拥有组织
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
        modelMap.put("upmsOrganizations", upmsOrganizations);
        modelMap.put("upmsUserOrganizations", upmsUserOrganizations);
        return "user/organization";
    }

    @ApiOperation(value = "用户组织")
	@RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object organization(@PathVariable("id") Long id, HttpServletRequest request) {
        String[] organizationIds = request.getParameterValues("organizationId");
        upmsUserOrganizationService.organization(organizationIds, id);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), "");
    }

    @ApiOperation(value = "用户角色")
	@RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") Long id, ModelMap modelMap) {
        // 所有角色
        List<UpmsRole> upmsRoles = upmsRoleService.selectByExample(new UpmsRoleExample());
        // 用户拥有角色
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectByExample(upmsUserRoleExample);
        modelMap.put("upmsRoles", upmsRoles);
        modelMap.put("upmsUserRoles", upmsUserRoles);
        return "user/role";
    }

    @ApiOperation(value = "用户角色")
	@RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") Long id, HttpServletRequest request) {
        String[] roleIds = request.getParameterValues("roleId");
        upmsUserRoleService.role(roleIds, id);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), "");
    }

    @ApiOperation(value = "用户权限")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public String permission(@PathVariable("id") Long id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "user/permission";
    }

    @ApiOperation(value = "用户权限")
	@RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id") Long id, HttpServletRequest request) {
        JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
        upmsUserPermissionService.permission(datas, id);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), datas.size());
    }

    @ApiOperation(value = "用户列表")
	@RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") Integer offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") Integer limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsUserExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsUserExample.or()
                    .andRealnameLike("%" + search + "%");
            upmsUserExample.or()
                    .andUsernameLike("%" + search + "%");
        }
        List<UpmsUser> rows = upmsUserService.selectByExampleForOffsetPage(upmsUserExample, offset, limit);
        long total = upmsUserService.countByExample(upmsUserExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增用户")
	@RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "user/create";
    }

    @ApiOperation(value = "新增用户")
	@RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public Object create(UpmsUser upmsUser) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getPassword(), new LengthValidator(5, 32, "密码"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
        }
        upmsUser.setSalt(CodeUtil.genUUID32());
        upmsUser.setPassword(MD5Util.md5(upmsUser.getPassword() + upmsUser.getSalt()));
        upmsUser = upmsUserService.createUser(upmsUser);
        if (null == upmsUser) {
			return new UpmsResponse(ResponseCodeEnum.CONFLICT.getCodeInt(), "帐号名已存在!", "");
		}
        logger.debug("新增用户，主键：userId={}", upmsUser.getUserId());
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), 1);
    }

    @ApiOperation(value = "删除用户")
	@RequiresPermissions("upms:user:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsUserService.deleteByPrimaryKeys(ids);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

    @ApiOperation(value = "修改用户")
	@RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "user/update";
    }

    @ApiOperation(value = "修改用户")
	@RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") Long id, UpmsUser upmsUser) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
        }
        // 不允许直接改密码
        upmsUser.setPassword(null);
        upmsUser.setUserId(id);
        int count = upmsUserService.updateByPrimaryKeySelective(upmsUser);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(),
				ResponseCodeEnum.OK.getName(), count);
    }

}
