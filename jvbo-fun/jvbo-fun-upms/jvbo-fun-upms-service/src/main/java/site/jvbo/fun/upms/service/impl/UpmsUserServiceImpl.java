package site.jvbo.fun.upms.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsUserDao;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.dao.model.UpmsUserExample;
import site.jvbo.fun.upms.service.IUpmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsUserServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserDao, UpmsUser, UpmsUserExample> implements IUpmsUserService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserDao upmsUserDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public UpmsUser createUser(UpmsUser upmsUser) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria()
				.andUsernameEqualTo(upmsUser.getUsername());
		long count = upmsUserDao.countByExample(upmsUserExample);
		if (count > 0) {
			return null;
		}
		upmsUserDao.insert(upmsUser);
		return upmsUser;
	}
}