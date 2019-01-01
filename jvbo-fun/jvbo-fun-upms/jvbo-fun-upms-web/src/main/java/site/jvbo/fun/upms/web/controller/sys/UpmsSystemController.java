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
import site.jvbo.fun.upms.dao.model.UpmsSystem;
import site.jvbo.fun.upms.dao.model.UpmsSystemExample;
import site.jvbo.fun.upms.service.IUpmsSystemService;

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
@Api(tags = "系统管理", description = "系统管理")
@RequestMapping("/manage/system")
public class UpmsSystemController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UpmsSystemController.class);

	@Autowired
	private IUpmsSystemService upmsSystemService;

	@ApiOperation(value = "系统首页")
	@RequiresPermissions("upms:system:read")
	@GetMapping("/index")
	public String index() {
		return "system/index";
	}

	@ApiOperation(value = "系统列表")
	@RequiresPermissions("upms:system:read")
	@GetMapping("/list")
	@ResponseBody
	public Object list(
			@RequestParam(required = false, defaultValue = "0", value = "offset") Integer offset,
			@RequestParam(required = false, defaultValue = "10", value = "limit") Integer limit,
			@RequestParam(required = false, defaultValue = "", value = "search") String search,
			@RequestParam(required = false, value = "sort") String sort,
			@RequestParam(required = false, value = "order") String order) {
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
			upmsSystemExample.setOrderByClause(sort + " " + order);
		}
		if (StringUtils.isNotBlank(search)) {
			upmsSystemExample.or()
					.andTitleLike("%" + search + "%");
		}
		List<UpmsSystem> rows = upmsSystemService.selectByExampleForOffsetPage(upmsSystemExample, offset, limit);
		long total = upmsSystemService.countByExample(upmsSystemExample);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", rows);
		result.put("total", total);
		return result;
	}

	@ApiOperation(value = "新增系统")
	@RequiresPermissions("upms:system:create")
	@GetMapping("/create")
	public String create() {
		return "system/create";
	}

	@ApiOperation(value = "新增系统")
	@RequiresPermissions("upms:system:create")
	@PostMapping("/create")
	@ResponseBody
	public Object create(UpmsSystem upmsSystem) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsSystem.getTitle(), new LengthValidator(1, 20, "标题"))
				.on(upmsSystem.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
		}
		int count = upmsSystemService.insertSelective(upmsSystem);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
	}

	@ApiOperation(value = "修改系统")
	@RequiresPermissions("upms:system:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id, ModelMap modelMap) {
		UpmsSystem system = upmsSystemService.selectByPrimaryKey(id);
		modelMap.put("system", system);
		return "system/update";
	}

	@ApiOperation(value = "修改系统")
	@RequiresPermissions("upms:system:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable("id") Long id, UpmsSystem upmsSystem) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsSystem.getTitle(), new LengthValidator(1, 20, "标题"))
				.on(upmsSystem.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResponse(ResponseCodeEnum.BAD_REQUEST.getCodeInt(),
					ResponseCodeEnum.BAD_REQUEST.getName(),
					result.getErrors());
		}
		upmsSystem.setSystemId(id);
		int count = upmsSystemService.updateByPrimaryKeySelective(upmsSystem);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
	}

	@ApiOperation(value = "删除系统")
	@RequiresPermissions("upms:system:delete")
	@RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		int count = upmsSystemService.deleteByPrimaryKeys(ids);
		return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
	}

}