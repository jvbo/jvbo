package site.jvbo.fun.upms.dao.mapper;

import site.jvbo.fun.upms.dao.model.UpmsPermission;
import site.jvbo.fun.upms.dao.model.UpmsRole;

import java.util.List;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/24
 */
public interface UpmsPermissionMapper {

	// 根据用户id获取所拥有的权限
	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Long upmsUserId);

	// 根据用户id获取所属的角色
	List<UpmsRole> selectUpmsRoleByUpmsUserId(Long upmsUserId);
}
