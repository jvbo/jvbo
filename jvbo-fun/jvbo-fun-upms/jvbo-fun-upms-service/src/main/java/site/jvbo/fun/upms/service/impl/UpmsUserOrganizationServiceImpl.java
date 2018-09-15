package site.jvbo.fun.upms.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsUserOrganizationDao;
import site.jvbo.fun.upms.dao.model.UpmsUserOrganization;
import site.jvbo.fun.upms.dao.model.UpmsUserOrganizationExample;
import site.jvbo.fun.upms.service.IUpmsUserOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsUserOrganizationServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsUserOrganizationServiceImpl extends BaseServiceImpl<UpmsUserOrganizationDao, UpmsUserOrganization, UpmsUserOrganizationExample> implements IUpmsUserOrganizationService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsUserOrganizationServiceImpl.class);

    @Autowired
    UpmsUserOrganizationDao upmsUserOrganizationDao;

	@Override
	public Integer organization(String[] organizationIds, Long id) {
		int result = 0;
		// 删除旧记录
		UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
		upmsUserOrganizationExample.createCriteria()
				.andUserIdEqualTo(id);
		upmsUserOrganizationDao.deleteByExample(upmsUserOrganizationExample);
		// 增加新记录
		if (null != organizationIds) {
			for (String organizationId : organizationIds) {
				if (StringUtils.isBlank(organizationId)) {
					continue;
				}
				UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
				upmsUserOrganization.setUserId(id);
				upmsUserOrganization.setOrganizationId(NumberUtils.toLong(organizationId));
				result = upmsUserOrganizationDao.insertSelective(upmsUserOrganization);
			}
		}
		return result;
	}
}