package site.jvbo.fun.upms.service;

import com.alibaba.fastjson.JSONArray;
import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsRolePermission;
import site.jvbo.fun.upms.dao.model.UpmsRolePermissionExample;

/**
 * IUpmsRolePermissionService接口
 * @date 2018/9/10
 */
public interface IUpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {

	Integer rolePermission(JSONArray datas, Long id);
}