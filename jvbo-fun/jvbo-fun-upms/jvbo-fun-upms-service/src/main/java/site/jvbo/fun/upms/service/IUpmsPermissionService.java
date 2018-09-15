package site.jvbo.fun.upms.service;

import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsPermission;
import site.jvbo.fun.upms.dao.model.UpmsPermissionExample;

import java.util.List;

/**
 * IUpmsPermissionService接口
 * @date 2018/9/10
 */
public interface IUpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

	Object findTreeByRoleId(Long roleId);

	Object getTreeByUserId(Long userId, Integer type);

	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Long userId);
}