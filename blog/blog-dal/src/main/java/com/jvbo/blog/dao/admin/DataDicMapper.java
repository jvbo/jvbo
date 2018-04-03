package com.jvbo.blog.dao.admin;

import com.jvbo.blog.model.DataDic;
import com.jvbo.blog.model.DataDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataDicMapper {
    long countByExample(DataDicExample example);

    int deleteByExample(DataDicExample example);

    int deleteByPrimaryKey(String id);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    List<DataDic> selectByExampleWithBLOBs(DataDicExample example);

    List<DataDic> selectByExample(DataDicExample example);

    DataDic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DataDic record, @Param("example") DataDicExample example);

    int updateByExampleWithBLOBs(@Param("record") DataDic record, @Param("example") DataDicExample example);

    int updateByExample(@Param("record") DataDic record, @Param("example") DataDicExample example);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKeyWithBLOBs(DataDic record);

    int updateByPrimaryKey(DataDic record);
}