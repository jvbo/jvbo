package com.jvbo.springboot.template.admin.core.mapper;

import com.jvbo.springboot.template.admin.core.model.AuthMenu;
import com.jvbo.springboot.template.admin.core.model.AuthMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthMenuMapper {
    long countByExample(AuthMenuExample example);

    int deleteByExample(AuthMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthMenu record);

    int insertSelective(AuthMenu record);

    List<AuthMenu> selectByExample(AuthMenuExample example);

    AuthMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthMenu record, @Param("example") AuthMenuExample example);

    int updateByExample(@Param("record") AuthMenu record, @Param("example") AuthMenuExample example);

    int updateByPrimaryKeySelective(AuthMenu record);

    int updateByPrimaryKey(AuthMenu record);
}