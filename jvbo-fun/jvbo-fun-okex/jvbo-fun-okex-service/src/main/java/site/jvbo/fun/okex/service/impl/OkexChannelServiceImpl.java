package site.jvbo.fun.okex.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.okex.dao.dao.OkexChannelDao;
import site.jvbo.fun.okex.dao.model.OkexChannel;
import site.jvbo.fun.okex.dao.model.OkexChannelExample;
import site.jvbo.fun.okex.service.IOkexChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OkexChannelServiceImpl实现
 * @date 2018/10/18
 */
@Service
@BaseService
public class OkexChannelServiceImpl extends BaseServiceImpl<OkexChannelDao, OkexChannel, OkexChannelExample> implements IOkexChannelService {
    private static final Logger logger = LoggerFactory.getLogger(OkexChannelServiceImpl.class);

    @Autowired
    OkexChannelDao okexChannelDao;

}