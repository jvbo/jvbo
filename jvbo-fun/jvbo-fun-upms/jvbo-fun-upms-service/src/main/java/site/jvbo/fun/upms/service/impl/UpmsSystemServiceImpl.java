package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsSystemDao;
import site.jvbo.fun.upms.dao.model.UpmsSystem;
import site.jvbo.fun.upms.dao.model.UpmsSystemExample;
import site.jvbo.fun.upms.service.IUpmsSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsSystemServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsSystemServiceImpl extends BaseServiceImpl<UpmsSystemDao, UpmsSystem, UpmsSystemExample> implements IUpmsSystemService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsSystemServiceImpl.class);

    @Autowired
    UpmsSystemDao upmsSystemDao;

}