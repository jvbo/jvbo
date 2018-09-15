package site.jvbo.fun.upms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsRolePermissionDao;
import site.jvbo.fun.upms.dao.model.UpmsRolePermission;
import site.jvbo.fun.upms.dao.model.UpmsRolePermissionExample;
import site.jvbo.fun.upms.service.IUpmsRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UpmsRolePermissionServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionDao, UpmsRolePermission, UpmsRolePermissionExample> implements IUpmsRolePermissionService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsRolePermissionServiceImpl.class);

    @Autowired
    UpmsRolePermissionDao upmsRolePermissionDao;

	@Override
	public Integer rolePermission(JSONArray datas, Long id) {
		List<Long> deleteIds = new ArrayList<>();
		for (int i = 0; i < datas.size(); i ++) {
			JSONObject json = datas.getJSONObject(i);
			if (!json.getBoolean("checked")) {
				deleteIds.add(json.getLongValue("id"));
			} else {
				// 新增权限
				UpmsRolePermission upmsRolePermission = new UpmsRolePermission();
				upmsRolePermission.setRoleId(id);
				upmsRolePermission.setPermissionId(json.getLongValue("id"));
				upmsRolePermissionDao.insertSelective(upmsRolePermission);
			}
		}
		// 删除权限
		if (deleteIds.size() > 0) {
			UpmsRolePermissionExample upmsRolePermissionExample = new UpmsRolePermissionExample();
			upmsRolePermissionExample.createCriteria()
					.andPermissionIdIn(deleteIds)
					.andRoleIdEqualTo(id);
			upmsRolePermissionDao.deleteByExample(upmsRolePermissionExample);
		}
		return datas.size();
	}
}