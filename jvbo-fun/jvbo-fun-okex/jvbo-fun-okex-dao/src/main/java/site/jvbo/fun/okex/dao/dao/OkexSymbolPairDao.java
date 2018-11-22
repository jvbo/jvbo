package site.jvbo.fun.okex.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.okex.dao.model.OkexSymbolPair;
import site.jvbo.fun.okex.dao.model.OkexSymbolPairExample;

public interface OkexSymbolPairDao {
    long countByExample(OkexSymbolPairExample example);

    int deleteByExample(OkexSymbolPairExample example);

    int deleteByPrimaryKey(Long symbolPairId);

    int insert(OkexSymbolPair record);

    int insertSelective(OkexSymbolPair record);

    List<OkexSymbolPair> selectByExample(OkexSymbolPairExample example);

    OkexSymbolPair selectByPrimaryKey(Long symbolPairId);

    int updateByExampleSelective(@Param("record") OkexSymbolPair record, @Param("example") OkexSymbolPairExample example);

    int updateByExample(@Param("record") OkexSymbolPair record, @Param("example") OkexSymbolPairExample example);

    int updateByPrimaryKeySelective(OkexSymbolPair record);

    int updateByPrimaryKey(OkexSymbolPair record);
}