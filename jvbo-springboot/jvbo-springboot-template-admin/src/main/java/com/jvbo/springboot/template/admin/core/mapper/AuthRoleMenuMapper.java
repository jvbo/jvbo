package com.jvbo.springboot.template.admin.core.mapper;

import com.jvbo.springboot.template.admin.core.model.AuthRoleMenu;
import com.jvbo.springboot.template.admin.core.model.AuthRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleMenuMapper {
    long countByExample(AuthRoleMenuExample example);

    int deleteByExample(AuthRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthRoleMenu record);

    int insertSelective(AuthRoleMenu record);

    List<AuthRoleMenu> selectByExample(AuthRoleMenuExample example);

    AuthRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthRoleMenu record, @Param("example") AuthRoleMenuExample example);

    int updateByExample(@Param("record") AuthRoleMenu record, @Param("example") AuthRoleMenuExample example);

    int updateByPrimaryKeySelective(AuthRoleMenu record);

    int updateByPrimaryKey(AuthRoleMenu record);
}