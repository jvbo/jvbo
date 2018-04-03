package com.jvbo.springboot.template.admin.core.mapper;

import com.jvbo.springboot.template.admin.core.model.AuthUserOperate;
import com.jvbo.springboot.template.admin.core.model.AuthUserOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserOperateMapper {
    long countByExample(AuthUserOperateExample example);

    int deleteByExample(AuthUserOperateExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthUserOperate record);

    int insertSelective(AuthUserOperate record);

    List<AuthUserOperate> selectByExample(AuthUserOperateExample example);

    AuthUserOperate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthUserOperate record, @Param("example") AuthUserOperateExample example);

    int updateByExample(@Param("record") AuthUserOperate record, @Param("example") AuthUserOperateExample example);

    int updateByPrimaryKeySelective(AuthUserOperate record);

    int updateByPrimaryKey(AuthUserOperate record);
}