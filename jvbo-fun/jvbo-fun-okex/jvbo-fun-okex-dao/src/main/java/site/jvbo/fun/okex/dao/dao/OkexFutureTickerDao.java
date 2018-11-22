package site.jvbo.fun.okex.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.okex.dao.model.OkexFutureTicker;
import site.jvbo.fun.okex.dao.model.OkexFutureTickerExample;

public interface OkexFutureTickerDao {
    long countByExample(OkexFutureTickerExample example);

    int deleteByExample(OkexFutureTickerExample example);

    int deleteByPrimaryKey(Long futureTickerId);

    int insert(OkexFutureTicker record);

    int insertSelective(OkexFutureTicker record);

    List<OkexFutureTicker> selectByExample(OkexFutureTickerExample example);

    OkexFutureTicker selectByPrimaryKey(Long futureTickerId);

    int updateByExampleSelective(@Param("record") OkexFutureTicker record, @Param("example") OkexFutureTickerExample example);

    int updateByExample(@Param("record") OkexFutureTicker record, @Param("example") OkexFutureTickerExample example);

    int updateByPrimaryKeySelective(OkexFutureTicker record);

    int updateByPrimaryKey(OkexFutureTicker record);
}