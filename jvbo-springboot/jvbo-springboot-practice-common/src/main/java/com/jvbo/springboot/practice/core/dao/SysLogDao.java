package com.jvbo.springboot.practice.core.dao;

import com.jvbo.springboot.practice.core.model.SysLog;
import com.jvbo.springboot.practice.core.model.SysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogDao {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}