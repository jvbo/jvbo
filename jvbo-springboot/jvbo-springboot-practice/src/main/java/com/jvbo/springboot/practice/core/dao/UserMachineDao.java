package com.jvbo.springboot.practice.core.dao;

import com.jvbo.springboot.practice.core.model.UserMachine;
import com.jvbo.springboot.practice.core.model.UserMachineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMachineDao {
    long countByExample(UserMachineExample example);

    int deleteByExample(UserMachineExample example);

    int deleteByPrimaryKey(Long user_machine_id);

    int insert(UserMachine record);

    int insertSelective(UserMachine record);

    List<UserMachine> selectByExample(UserMachineExample example);

    UserMachine selectByPrimaryKey(Long user_machine_id);

    int updateByExampleSelective(@Param("record") UserMachine record, @Param("example") UserMachineExample example);

    int updateByExample(@Param("record") UserMachine record, @Param("example") UserMachineExample example);

    int updateByPrimaryKeySelective(UserMachine record);

    int updateByPrimaryKey(UserMachine record);
}