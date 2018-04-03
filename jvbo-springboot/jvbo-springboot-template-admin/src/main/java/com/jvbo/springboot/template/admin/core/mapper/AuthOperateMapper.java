package com.jvbo.springboot.template.admin.core.mapper;

import com.jvbo.springboot.template.admin.core.model.AuthOperate;
import com.jvbo.springboot.template.admin.core.model.AuthOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthOperateMapper {
    long countByExample(AuthOperateExample example);

    int deleteByExample(AuthOperateExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthOperate record);

    int insertSelective(AuthOperate record);

    List<AuthOperate> selectByExample(AuthOperateExample example);

    AuthOperate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthOperate record, @Param("example") AuthOperateExample example);

    int updateByExample(@Param("record") AuthOperate record, @Param("example") AuthOperateExample example);

    int updateByPrimaryKeySelective(AuthOperate record);

    int updateByPrimaryKey(AuthOperate record);
}