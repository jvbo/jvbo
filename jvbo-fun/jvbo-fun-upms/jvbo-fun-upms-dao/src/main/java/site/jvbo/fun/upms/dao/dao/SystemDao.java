package site.jvbo.fun.upms.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.upms.dao.model.System;
import site.jvbo.fun.upms.dao.model.SystemExample;

public interface SystemDao {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Long systemId);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Long systemId);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
}