package site.jvbo.fun.upms.service;

import com.alibaba.fastjson.JSONArray;
import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsUserPermission;
import site.jvbo.fun.upms.dao.model.UpmsUserPermissionExample;

/**
 * IUpmsUserPermissionService接口
 * @date 2018/9/10
 */
public interface IUpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {

	Integer permission(JSONArray datas, Long id);
}