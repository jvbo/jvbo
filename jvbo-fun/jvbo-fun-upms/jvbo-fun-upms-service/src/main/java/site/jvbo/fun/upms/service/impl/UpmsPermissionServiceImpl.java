package site.jvbo.fun.upms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsPermissionDao;
import site.jvbo.fun.upms.dao.dao.UpmsRolePermissionDao;
import site.jvbo.fun.upms.dao.dao.UpmsSystemDao;
import site.jvbo.fun.upms.dao.dao.UpmsUserPermissionDao;
import site.jvbo.fun.upms.dao.model.*;
import site.jvbo.fun.upms.service.IUpmsPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UpmsPermissionServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsPermissionServiceImpl extends BaseServiceImpl<UpmsPermissionDao, UpmsPermission, UpmsPermissionExample> implements IUpmsPermissionService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsPermissionServiceImpl.class);

    @Autowired
    UpmsPermissionDao upmsPermissionDao;
	@Autowired
	UpmsSystemDao upmsSystemDao;
	@Autowired
	UpmsRolePermissionDao upmsRolePermissionDao;
	@Autowired
	UpmsUserPermissionDao upmsUserPermissionDao;

	@Override
	public Object findTreeByRoleId(Long roleId) {
		// 角色已有权限
		UpmsRolePermissionExample upmsRolePermissionExample = new UpmsRolePermissionExample();
		upmsRolePermissionExample.createCriteria()
				.andRoleIdEqualTo(roleId);
		List<UpmsRolePermission> rolePermissions = upmsRolePermissionDao.selectByExample(upmsRolePermissionExample);


		JSONArray systems = new JSONArray();
		// 系统
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria()
				.andStateEqualTo(1);
		upmsSystemExample.setOrderByClause("orders asc");
		List<UpmsSystem> upmsSystems = upmsSystemDao.selectByExample(upmsSystemExample);
		for (UpmsSystem upmsSystem : upmsSystems) {
			JSONObject node = new JSONObject();
			node.put("id", upmsSystem.getSystemId());
			node.put("name", upmsSystem.getTitle());
			node.put("nocheck", true);
			node.put("open", true);
			systems.add(node);
		}

		if (systems.size() > 0) {
			for (Object system: systems) {
				UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
				upmsPermissionExample.createCriteria()
						.andStateEqualTo( 1)
						.andSystemIdEqualTo(((JSONObject) system).getLongValue("id"));
				upmsPermissionExample.setOrderByClause("orders asc");
				List<UpmsPermission> upmsPermissions = upmsPermissionDao.selectByExample(upmsPermissionExample);
				if (upmsPermissions.size() == 0) {
					continue;
				}
				// 目录
				JSONArray folders = new JSONArray();
				for (UpmsPermission upmsPermission: upmsPermissions) {
					if (upmsPermission.getPid().intValue() != 0 || upmsPermission.getType() != 1) {
						continue;
					}
					JSONObject node = new JSONObject();
					node.put("id", upmsPermission.getPermissionId());
					node.put("name", upmsPermission.getName());
					node.put("open", true);
					for (UpmsRolePermission rolePermission : rolePermissions) {
						if (rolePermission.getPermissionId().intValue() == upmsPermission.getPermissionId().intValue()) {
							node.put("checked", true);
						}
					}
					folders.add(node);
					// 菜单
					JSONArray menus = new JSONArray();
					for (Object folder : folders) {
						for (UpmsPermission upmsPermission2: upmsPermissions) {
							if (upmsPermission2.getPid().intValue() != ((JSONObject) folder).getIntValue("id") || upmsPermission2.getType() != 2) {
								continue;
							}
							JSONObject node2 = new JSONObject();
							node2.put("id", upmsPermission2.getPermissionId());
							node2.put("name", upmsPermission2.getName());
							node2.put("open", true);
							for (UpmsRolePermission rolePermission : rolePermissions) {
								if (rolePermission.getPermissionId().intValue() == upmsPermission2.getPermissionId().intValue()) {
									node2.put("checked", true);
								}
							}
							menus.add(node2);
							// 按钮
							JSONArray buttons = new JSONArray();
							for (Object menu : menus) {
								for (UpmsPermission upmsPermission3: upmsPermissions) {
									if (upmsPermission3.getPid().intValue() != ((JSONObject) menu).getIntValue("id") || upmsPermission3.getType() != 3) {
										continue;
									}
									JSONObject node3 = new JSONObject();
									node3.put("id", upmsPermission3.getPermissionId());
									node3.put("name", upmsPermission3.getName());
									node3.put("open", true);
									for (UpmsRolePermission rolePermission : rolePermissions) {
										if (rolePermission.getPermissionId().intValue() == upmsPermission3.getPermissionId().intValue()) {
											node3.put("checked", true);
										}
									}
									buttons.add(node3);
								}
								if (buttons.size() > 0) {
									((JSONObject) menu).put("children", buttons);
									buttons = new JSONArray();
								}
							}
						}
						if (menus.size() > 0) {
							((JSONObject) folder).put("children", menus);
							menus = new JSONArray();
						}
					}
				}
				if (folders.size() > 0) {
					((JSONObject) system).put("children", folders);
				}
			}
		}
		return systems;
	}

	@Override
	public Object getTreeByUserId(Long usereId, Integer type) {
		// 角色权限
		UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
		upmsUserPermissionExample.createCriteria()
				.andUserIdEqualTo(usereId)
				.andTypeEqualTo(type);
		List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionDao.selectByExample(upmsUserPermissionExample);

		JSONArray systems = new JSONArray();
		// 系统
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria()
				.andStateEqualTo(1);
		upmsSystemExample.setOrderByClause("orders asc");
		List<UpmsSystem> upmsSystems = upmsSystemDao.selectByExample(upmsSystemExample);
		for (UpmsSystem upmsSystem : upmsSystems) {
			JSONObject node = new JSONObject();
			node.put("id", upmsSystem.getSystemId());
			node.put("name", upmsSystem.getTitle());
			node.put("nocheck", true);
			node.put("open", true);
			systems.add(node);
		}

		if (systems.size() > 0) {
			for (Object system: systems) {
				UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
				upmsPermissionExample.createCriteria()
						.andStateEqualTo(1)
						.andSystemIdEqualTo(((JSONObject) system).getLongValue("id"));
				upmsPermissionExample.setOrderByClause("orders asc");
				List<UpmsPermission> upmsPermissions = upmsPermissionDao.selectByExample(upmsPermissionExample);
				if (upmsPermissions.size() == 0) {
					continue;
				}
				// 目录
				JSONArray folders = new JSONArray();
				for (UpmsPermission upmsPermission: upmsPermissions) {
					if (upmsPermission.getPid().intValue() != 0 || upmsPermission.getType() != 1) {
						continue;
					}
					JSONObject node = new JSONObject();
					node.put("id", upmsPermission.getPermissionId());
					node.put("name", upmsPermission.getName());
					node.put("open", true);
					for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
						if (upmsUserPermission.getPermissionId().intValue() == upmsPermission.getPermissionId().intValue()) {
							node.put("checked", true);
						}
					}
					folders.add(node);
					// 菜单
					JSONArray menus = new JSONArray();
					for (Object folder : folders) {
						for (UpmsPermission upmsPermission2: upmsPermissions) {
							if (upmsPermission2.getPid().intValue() != ((JSONObject) folder).getIntValue("id") || upmsPermission2.getType() != 2) {
								continue;
							}
							JSONObject node2 = new JSONObject();
							node2.put("id", upmsPermission2.getPermissionId());
							node2.put("name", upmsPermission2.getName());
							node2.put("open", true);
							for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
								if (upmsUserPermission.getPermissionId().intValue() == upmsPermission2.getPermissionId().intValue()) {
									node2.put("checked", true);
								}
							}
							menus.add(node2);
							// 按钮
							JSONArray buttons = new JSONArray();
							for (Object menu : menus) {
								for (UpmsPermission upmsPermission3: upmsPermissions) {
									if (upmsPermission3.getPid().intValue() != ((JSONObject) menu).getIntValue("id") || upmsPermission3.getType() != 3) {
										continue;
									}
									JSONObject node3 = new JSONObject();
									node3.put("id", upmsPermission3.getPermissionId());
									node3.put("name", upmsPermission3.getName());
									node3.put("open", true);
									for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
										if (upmsUserPermission.getPermissionId().intValue() == upmsPermission3.getPermissionId().intValue()) {
											node3.put("checked", true);
										}
									}
									buttons.add(node3);
								}
								if (buttons.size() > 0) {
									((JSONObject) menu).put("children", buttons);
									buttons = new JSONArray();
								}
							}
						}
						if (menus.size() > 0) {
							((JSONObject) folder).put("children", menus);
							menus = new JSONArray();
						}
					}
				}
				if (folders.size() > 0) {
					((JSONObject) system).put("children", folders);
				}
			}
		}
		return systems;
	}

	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Long userId) {
		return null;
	}
}