package site.jvbo.fun.upms.service;

import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsUserOrganization;
import site.jvbo.fun.upms.dao.model.UpmsUserOrganizationExample;

/**
 * IUpmsUserOrganizationService接口
 * @date 2018/9/10
 */
public interface IUpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {

	Integer organization(String[] organizationIds, Long id);
}