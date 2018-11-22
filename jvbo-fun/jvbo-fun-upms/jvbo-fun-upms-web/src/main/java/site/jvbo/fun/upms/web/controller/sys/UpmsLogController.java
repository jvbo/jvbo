package site.jvbo.fun.upms.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.jvbo.fun.common.base.BaseController;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.upms.common.response.UpmsResponse;
import site.jvbo.fun.upms.dao.model.UpmsLog;
import site.jvbo.fun.upms.dao.model.UpmsLogExample;
import site.jvbo.fun.upms.service.IUpmsLogService;

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
@Api(tags = "日志管理", description = "日志管理")
@RequestMapping("/manage/log")
public class UpmsLogController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UpmsLogController.class);

    @Autowired
    private IUpmsLogService upmsLogService;

    @ApiOperation(value = "日志首页")
	@RequiresPermissions("upms:log:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "log/index";
    }

    @ApiOperation(value = "日志列表")
	@RequiresPermissions("upms:log:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") Integer offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") Integer limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsLogExample upmsLogExample = new UpmsLogExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsLogExample.setOrderByClause(sort.concat(" ").concat(order));
        }
        if (StringUtils.isNotBlank(search)) {
            upmsLogExample.or()
                    .andMethodDescLike("%" + search + "%");
        }
        List<UpmsLog> rows = upmsLogService.selectByExampleForOffsetPage(upmsLogExample, offset, limit);
        long total = upmsLogService.countByExample(upmsLogExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "删除日志")
	@RequiresPermissions("upms:log:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsLogService.deleteByPrimaryKeys(ids);
        return new UpmsResponse(ResponseCodeEnum.OK.getCodeInt(), ResponseCodeEnum.OK.getName(), count);
    }

}