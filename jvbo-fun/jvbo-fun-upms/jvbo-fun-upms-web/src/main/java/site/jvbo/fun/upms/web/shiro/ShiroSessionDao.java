package site.jvbo.fun.upms.web.shiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.dao.model.UpmsUserExample;
import site.jvbo.fun.upms.dao.model.UpmsUserRole;
import site.jvbo.fun.upms.dao.model.UpmsUserRoleExample;
import site.jvbo.fun.upms.service.IUpmsRoleService;
import site.jvbo.fun.upms.service.IUpmsUserRoleService;
import site.jvbo.fun.upms.service.IUpmsUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/12
 */
@Service
public class ShiroSessionDao {

	@Autowired
	private IUpmsUserService upmsUserService;
	@Autowired
	private IUpmsUserRoleService upmsUserRoleService;
	@Autowired
	private IUpmsRoleService upmsRoleService;

	public String getPasswordByUsername(String username) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria()
				.andUsernameEqualTo(username);
		UpmsUser upmsUser = upmsUserService.selectFirstByExample(upmsUserExample);
		return upmsUser != null ? upmsUser.getPassword() : null;
	}

	public Set<String> getRolesByUsername(String username) {
		// TODO
		Set<String> roleSet = new HashSet<>();
		roleSet.add("super");
		roleSet.add("admin");
		return roleSet;
	}

	public Set<String> getPermissionsByRole(String role) {
		// TODO
		Set<String> permissionSet = new HashSet<>();
		permissionSet.add("upms:system:read");
		permissionSet.add("upms:organization:read");
		permissionSet.add("upms:role:read");
		permissionSet.add("upms:user:read");
		return permissionSet;
	}
}
