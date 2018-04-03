package com.jvbo.blog.dao.admin;

import com.jvbo.blog.model.Blogger;
import com.jvbo.blog.model.BloggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BloggerMapper {
    long countByExample(BloggerExample example);

    int deleteByExample(BloggerExample example);

    int deleteByPrimaryKey(String id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    List<Blogger> selectByExample(BloggerExample example);

    Blogger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByExample(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);
}