package com.jvbo.blog.dao.admin;

import com.jvbo.blog.model.Link;
import com.jvbo.blog.model.LinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    long countByExample(LinkExample example);

    int deleteByExample(LinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkExample example);

    Link selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByExample(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}