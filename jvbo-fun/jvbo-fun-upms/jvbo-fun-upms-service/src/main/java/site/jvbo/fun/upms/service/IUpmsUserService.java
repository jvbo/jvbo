package site.jvbo.fun.upms.service;

import site.jvbo.fun.common.base.BaseService;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.dao.model.UpmsUserExample;

/**
 * IUpmsUserService接口
 * @date 2018/9/10
 */
public interface IUpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

	UpmsUser createUser(UpmsUser upmsUser);
}