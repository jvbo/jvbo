package com.jvbo.blog.dao.admin;

import com.jvbo.blog.model.Blog;
import com.jvbo.blog.model.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(String id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}