package site.jvbo.fun.upms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsUserPermissionDao;
import site.jvbo.fun.upms.dao.model.UpmsUserPermission;
import site.jvbo.fun.upms.dao.model.UpmsUserPermissionExample;
import site.jvbo.fun.upms.service.IUpmsUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsUserPermissionServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionDao, UpmsUserPermission, UpmsUserPermissionExample> implements IUpmsUserPermissionService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsUserPermissionServiceImpl.class);

    @Autowired
    UpmsUserPermissionDao upmsUserPermissionDao;

	@Override
	public Integer permission(JSONArray datas, Long id) {
		for (int i = 0; i < datas.size(); i ++) {
			JSONObject json = datas.getJSONObject(i);
			if (json.getBoolean("checked")) {
				// 新增权限
				UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
				upmsUserPermission.setUserId(id);
				upmsUserPermission.setPermissionId(json.getLongValue("id"));
				upmsUserPermission.setType(json.getIntValue("type"));
				upmsUserPermissionDao.insertSelective(upmsUserPermission);
			} else {
				// 删除权限
				UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
				upmsUserPermissionExample.createCriteria()
						.andPermissionIdEqualTo(json.getLongValue("id"))
						.andTypeEqualTo(json.getIntValue("type"));
				upmsUserPermissionDao.deleteByExample(upmsUserPermissionExample);
			}
		}
		return datas.size();
	}
}