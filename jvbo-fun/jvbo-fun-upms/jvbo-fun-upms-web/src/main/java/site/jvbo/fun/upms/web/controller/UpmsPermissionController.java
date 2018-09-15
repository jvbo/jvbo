package site.jvbo.fun.upms.web.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import site.jvbo.fun.common.base.BaseController;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.validator.LengthValidator;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.UpmsPermission;
import site.jvbo.fun.upms.dao.model.UpmsPermissionExample;
import site.jvbo.fun.upms.dao.model.UpmsSystem;
import site.jvbo.fun.upms.dao.model.UpmsSystemExample;
import site.jvbo.fun.upms.service.IUpmsPermissionService;
import site.jvbo.fun.upms.service.IUpmsSystemService;

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
@Api(value = "权限管理", description = "权限管理")
@RequestMapping("/manage/permission")
public class UpmsPermissionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsPermissionController.class);

    @Autowired
    private IUpmsPermissionService upmsPermissionService;

    @Autowired
    private IUpmsSystemService upmsSystemService;

    @ApiOperation(value = "权限首页")
	@RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "permission/index";
    }

    @ApiOperation(value = "权限列表")
	@RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") Integer offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") Integer limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "0", value = "type") Integer type,
            @RequestParam(required = false, defaultValue = "0", value = "systemId") Long systemId,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
        UpmsPermissionExample.Criteria criteria = upmsPermissionExample.createCriteria();
        if (0 != type) {
            criteria.andTypeEqualTo(type);
        }
        if (0 != systemId) {
            criteria.andSystemIdEqualTo(systemId);
        }
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsPermissionExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsPermissionExample.or()
                    .andNameLike("%" + search + "%");
        }
        List<UpmsPermission> rows = upmsPermissionService.selectByExampleForOffsetPage(upmsPermissionExample, offset, limit);
        long total = upmsPermissionService.countByExample(upmsPermissionExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "角色权限列表")
	@RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") Long id) {
        return upmsPermissionService.findTreeByRoleId(id);
    }

    @ApiOperation(value = "用户权限列表")
	@RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object user(@PathVariable("id") Long id, HttpServletRequest request) {
        return upmsPermissionService.getTreeByUserId(id, Integer.valueOf(request.getParameter("type").toString()));
    }

    @ApiOperation(value = "新增权限")
	@RequiresPermissions("upms:permission:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
        upmsSystemExample.createCriteria()
                .andStateEqualTo(1);
        List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
        modelMap.put("upmsSystems", upmsSystems);
        return "/manage/permission/create";
    }

    @ApiOperation(value = "新增权限")
	@RequiresPermissions("upms:permission:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsPermission upmsPermission) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsPermission.getName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
        }
        int count = upmsPermissionService.insertSelective(upmsPermission);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

    @ApiOperation(value = "删除权限")
	@RequiresPermissions("upms:permission:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsPermissionService.deleteByPrimaryKeys(ids);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

    @ApiOperation(value = "修改权限")
	@RequiresPermissions("upms:permission:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, ModelMap modelMap) {
        UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
        upmsSystemExample.createCriteria()
                .andStateEqualTo(1);
        List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
        UpmsPermission permission = upmsPermissionService.selectByPrimaryKey(id);
        modelMap.put("permission", permission);
        modelMap.put("upmsSystems", upmsSystems);
        return "permission/update";
    }

    @ApiOperation(value = "修改权限")
	@RequiresPermissions("upms:permission:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") Long id, UpmsPermission upmsPermission) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsPermission.getName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
        }
        upmsPermission.setPermissionId(id);
        int count = upmsPermissionService.updateByPrimaryKeySelective(upmsPermission);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

}
