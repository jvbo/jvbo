package site.jvbo.fun.upms.web.shiro.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.upms.dao.model.*;
import site.jvbo.fun.upms.service.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
@Repository
public class ShiroApiManager {

	@Autowired
	private IUpmsUserService upmsUserService;
	@Autowired
	private IUpmsUserRoleService upmsUserRoleService;
	@Autowired
	private IUpmsRoleService upmsRoleService;
	@Autowired
	private IUpmsPermissionService upmsPermissionService;
	@Autowired
	private IUpmsUserPermissionService upmsUserPermissionService;

	public UpmsUser getUserByUsername(String username) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria()
				.andUsernameEqualTo(username);
		UpmsUser upmsUser = upmsUserService.selectFirstByExample(upmsUserExample);
		return upmsUser;
	}

	public Set<String> getRolesByUserId(Long userId) {
		Set<String> roleSet = new HashSet<>();

		UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
		upmsUserRoleExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andUserIdEqualTo(userId);
		List<UpmsUserRole> upmsUserRoleList = upmsUserRoleService.selectByExample(upmsUserRoleExample);

		if(CollectionUtils.isNotEmpty(upmsUserRoleList))
			upmsUserRoleList.forEach(userRole -> {
				Long roleId = userRole.getRoleId();
				UpmsRoleExample upmsRoleExample = new UpmsRoleExample();
				upmsRoleExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
						.andRoleIdEqualTo(roleId);
				List<UpmsRole> upmsRoleList = upmsRoleService.selectByExample(upmsRoleExample);
				if(CollectionUtils.isNotEmpty(upmsRoleList))
					upmsRoleList.forEach(role -> {
						String roleName = role.getName();
						if(StringUtils.isNotBlank(roleName)) roleSet.add(roleName);
					});
			});
		return roleSet;
	}

	public Set<String> getPermissionsByUserId(Long userId) {
		// TODO
		Set<String> permissionSet = new HashSet<>();

		UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
		upmsUserPermissionExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt()).andUserIdEqualTo(userId);

		List<UpmsUserPermission> upmsUserPermissionList = upmsUserPermissionService.selectByExample(upmsUserPermissionExample);
		if(CollectionUtils.isNotEmpty(upmsUserPermissionList))
			upmsUserPermissionList.forEach(userPermission -> {
				Long permissionId = userPermission.getPermissionId();
				UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
				upmsPermissionExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
						.andPermissionIdEqualTo(permissionId);
				List<UpmsPermission> upmsPermissionList = upmsPermissionService.selectByExample(upmsPermissionExample);
				if(CollectionUtils.isNotEmpty(upmsPermissionList))
					upmsPermissionList.forEach(permission -> {
						String permissionValue = permission.getPermissionValue();
						if(StringUtils.isNotBlank(permissionValue)) permissionSet.add(permission.getPermissionValue());
					});
			});
		return permissionSet;
	}
}
