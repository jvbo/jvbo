package site.jvbo.fun.upms.web.controller.sys;

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
import site.jvbo.fun.common.validator.LengthValidator;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.UpmsOrganization;
import site.jvbo.fun.upms.dao.model.UpmsOrganizationExample;
import site.jvbo.fun.upms.service.IUpmsOrganizationService;

import java.time.Instant;
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
@Api(tags = "组织管理", description = "组织管理")
@RequestMapping("/manage/organization")
public class UpmsOrganizationController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UpmsOrganizationController.class);

    @Autowired
    private IUpmsOrganizationService upmsOrganizationService;

    @ApiOperation(value = "组织首页")
	@RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "organization/index";
    }

    @ApiOperation(value = "组织列表")
	@RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") Integer offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") Integer limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsOrganizationExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsOrganizationExample.or()
                    .andNameLike("%" + search + "%");
        }
        List<UpmsOrganization> rows = upmsOrganizationService.selectByExampleForOffsetPage(upmsOrganizationExample, offset, limit);
        long total = upmsOrganizationService.countByExample(upmsOrganizationExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增组织")
	@RequiresPermissions("upms:organization:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "organization/create";
    }

    @ApiOperation(value = "新增组织")
	@RequiresPermissions("upms:organization:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
    public Object create(UpmsOrganization upmsOrganization) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
        }
        upmsOrganization.setGmtCreate(Instant.now().toEpochMilli());
        int count = upmsOrganizationService.insertSelective(upmsOrganization);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

    @ApiOperation(value = "删除组织")
	@RequiresPermissions("upms:organization:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsOrganizationService.deleteByPrimaryKeys(ids);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

    @ApiOperation(value = "修改组织")
	@RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, ModelMap modelMap) {
        UpmsOrganization organization = upmsOrganizationService.selectByPrimaryKey(id);
        modelMap.put("organization", organization);
        return "organization/update";
    }

    @ApiOperation(value = "修改组织")
	@RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") Long id, UpmsOrganization upmsOrganization) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
		}
        upmsOrganization.setOrganizationId(id);
        int count = upmsOrganizationService.updateByPrimaryKeySelective(upmsOrganization);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

}
