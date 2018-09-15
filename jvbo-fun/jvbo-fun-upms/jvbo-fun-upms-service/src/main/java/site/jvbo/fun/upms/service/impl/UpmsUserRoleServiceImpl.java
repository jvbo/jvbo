package site.jvbo.fun.upms.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsUserRoleDao;
import site.jvbo.fun.upms.dao.model.UpmsUserRole;
import site.jvbo.fun.upms.dao.model.UpmsUserRoleExample;
import site.jvbo.fun.upms.service.IUpmsUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsUserRoleServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsUserRoleServiceImpl extends BaseServiceImpl<UpmsUserRoleDao, UpmsUserRole, UpmsUserRoleExample> implements IUpmsUserRoleService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsUserRoleServiceImpl.class);

    @Autowired
    UpmsUserRoleDao upmsUserRoleDao;

	@Override
	public Integer role(String[] roleIds, Long id) {
		int result = 0;
		// 删除旧记录
		UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
		upmsUserRoleExample.createCriteria()
				.andUserIdEqualTo(id);
		upmsUserRoleDao.deleteByExample(upmsUserRoleExample);
		// 增加新记录
		if (null != roleIds) {
			for (String roleId : roleIds) {
				if (StringUtils.isBlank(roleId)) {
					continue;
				}
				UpmsUserRole upmsUserRole = new UpmsUserRole();
				upmsUserRole.setUserId(id);
				upmsUserRole.setRoleId(NumberUtils.toLong(roleId));
				result = upmsUserRoleDao.insertSelective(upmsUserRole);
			}
		}
		return result;
	}
}