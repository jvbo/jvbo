package site.jvbo.fun.okex.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.okex.dao.dao.OkexSymbolPairDao;
import site.jvbo.fun.okex.dao.model.OkexSymbolPair;
import site.jvbo.fun.okex.dao.model.OkexSymbolPairExample;
import site.jvbo.fun.okex.service.IOkexSymbolPairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OkexSymbolPairServiceImpl实现
 * @date 2018/10/16
 */
@Service
@BaseService
public class OkexSymbolPairServiceImpl extends BaseServiceImpl<OkexSymbolPairDao, OkexSymbolPair, OkexSymbolPairExample> implements IOkexSymbolPairService {
    private static final Logger logger = LoggerFactory.getLogger(OkexSymbolPairServiceImpl.class);

    @Autowired
    OkexSymbolPairDao okexSymbolPairDao;

}