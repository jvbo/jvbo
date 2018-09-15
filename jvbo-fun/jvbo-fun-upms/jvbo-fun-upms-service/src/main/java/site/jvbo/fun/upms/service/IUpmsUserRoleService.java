package site.jvbo.fun.upms.service;

import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsUserRole;
import site.jvbo.fun.upms.dao.model.UpmsUserRoleExample;

/**
 * IUpmsUserRoleService接口
 * @date 2018/9/10
 */
public interface IUpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {

	Integer role(String[] roleIds, Long id);
}