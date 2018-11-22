package site.jvbo.fun.okex.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.okex.dao.dao.OkexFutureTickerDao;
import site.jvbo.fun.okex.dao.model.OkexFutureTicker;
import site.jvbo.fun.okex.dao.model.OkexFutureTickerExample;
import site.jvbo.fun.okex.service.IOkexFutureTickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OkexFutureTickerServiceImpl实现
 * @date 2018/10/18
 */
@Service
@BaseService
public class OkexFutureTickerServiceImpl extends BaseServiceImpl<OkexFutureTickerDao, OkexFutureTicker, OkexFutureTickerExample> implements IOkexFutureTickerService {
    private static final Logger logger = LoggerFactory.getLogger(OkexFutureTickerServiceImpl.class);

    @Autowired
    OkexFutureTickerDao okexFutureTickerDao;

}