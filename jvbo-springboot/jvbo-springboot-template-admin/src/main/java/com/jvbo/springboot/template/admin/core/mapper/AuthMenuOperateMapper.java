package com.jvbo.springboot.template.admin.core.mapper;

import com.jvbo.springboot.template.admin.core.model.AuthMenuOperate;
import com.jvbo.springboot.template.admin.core.model.AuthMenuOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthMenuOperateMapper {
    long countByExample(AuthMenuOperateExample example);

    int deleteByExample(AuthMenuOperateExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthMenuOperate record);

    int insertSelective(AuthMenuOperate record);

    List<AuthMenuOperate> selectByExample(AuthMenuOperateExample example);

    AuthMenuOperate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthMenuOperate record, @Param("example") AuthMenuOperateExample example);

    int updateByExample(@Param("record") AuthMenuOperate record, @Param("example") AuthMenuOperateExample example);

    int updateByPrimaryKeySelective(AuthMenuOperate record);

    int updateByPrimaryKey(AuthMenuOperate record);
}