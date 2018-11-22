package site.jvbo.fun.okex.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.okex.dao.dao.OkexSpotTickerDao;
import site.jvbo.fun.okex.dao.model.OkexSpotTicker;
import site.jvbo.fun.okex.dao.model.OkexSpotTickerExample;
import site.jvbo.fun.okex.service.IOkexSpotTickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OkexSpotTickerServiceImpl实现
 * @date 2018/10/18
 */
@Service
@BaseService
public class OkexSpotTickerServiceImpl extends BaseServiceImpl<OkexSpotTickerDao, OkexSpotTicker, OkexSpotTickerExample> implements IOkexSpotTickerService {
    private static final Logger logger = LoggerFactory.getLogger(OkexSpotTickerServiceImpl.class);

    @Autowired
    OkexSpotTickerDao okexSpotTickerDao;

}