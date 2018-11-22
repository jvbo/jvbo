package site.jvbo.fun.okex.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.okex.dao.model.OkexSpotTicker;
import site.jvbo.fun.okex.dao.model.OkexSpotTickerExample;

public interface OkexSpotTickerDao {
    long countByExample(OkexSpotTickerExample example);

    int deleteByExample(OkexSpotTickerExample example);

    int deleteByPrimaryKey(Long spotTickerId);

    int insert(OkexSpotTicker record);

    int insertSelective(OkexSpotTicker record);

    List<OkexSpotTicker> selectByExample(OkexSpotTickerExample example);

    OkexSpotTicker selectByPrimaryKey(Long spotTickerId);

    int updateByExampleSelective(@Param("record") OkexSpotTicker record, @Param("example") OkexSpotTickerExample example);

    int updateByExample(@Param("record") OkexSpotTicker record, @Param("example") OkexSpotTickerExample example);

    int updateByPrimaryKeySelective(OkexSpotTicker record);

    int updateByPrimaryKey(OkexSpotTicker record);
}