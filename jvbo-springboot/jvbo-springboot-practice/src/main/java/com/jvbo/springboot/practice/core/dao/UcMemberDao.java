package com.jvbo.springboot.practice.core.dao;

import com.jvbo.springboot.practice.core.model.UcMember;
import com.jvbo.springboot.practice.core.model.UcMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcMemberDao {
    long countByExample(UcMemberExample example);

    int deleteByExample(UcMemberExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(UcMember record);

    int insertSelective(UcMember record);

    List<UcMember> selectByExample(UcMemberExample example);

    UcMember selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") UcMember record, @Param("example") UcMemberExample example);

    int updateByExample(@Param("record") UcMember record, @Param("example") UcMemberExample example);

    int updateByPrimaryKeySelective(UcMember record);

    int updateByPrimaryKey(UcMember record);
}