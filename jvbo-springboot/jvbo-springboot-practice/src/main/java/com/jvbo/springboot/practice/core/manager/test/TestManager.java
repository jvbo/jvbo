/*
 * TestManager.java 2018年5月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.manager.test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.jvbo.springboot.practice.core.dao.UserMachineDao;
import com.jvbo.springboot.practice.core.model.UserMachine;
import com.jvbo.springboot.practice.core.model.UserMachineExample;

@Service
public class TestManager implements ITestManager {

    @Autowired
    private UserMachineDao userMachineDao;

    @Override
    public boolean batchInsert() {
        for (int i = 1; i < 20000; i++) {
            UserMachine record = new UserMachine();
            String s = String.valueOf(i);
            Long l = Long.valueOf(i);
            BigDecimal bd = BigDecimal.valueOf(i);
            record.setUser_machine_id(l);
            record.setUser_id(l);
            record.setCreated_by(s);
            record.setCycle_of_operation(i);
            record.setExpire_time(l);
            record.setGenerate_of_amount(bd);
            record.setGenerate_of_time(i);
            record.setGmt_created(l);
            record.setIs_deleted(1);
            record.setLimit_count(i);
            record.setMachine_from(s);
            record.setMachine_id(l);
            record.setMachine_name(s);
            record.setMachine_type(s);
            record.setPer_amount(bd);
            record.setSort(i);
            record.setState(s);
            record.setTotal_amount(bd);
            userMachineDao.insertSelective(record);
        }
        return true;
    }

    @Override
    public BigDecimal execTime() {
        long startTime = Instant.now().toEpochMilli();  
        UserMachineExample example = new UserMachineExample();
        example.createCriteria().andIs_deletedEqualTo(1);
        List<UserMachine> list = userMachineDao.selectByExample(example);
        
        List<Long> userIdList = list.stream().filter(l -> l.getUser_id() != null)
                .map(UserMachine::getUser_id).collect(Collectors.toList());

        UserMachineExample ume = new UserMachineExample();
        ume.createCriteria().andIs_deletedEqualTo(1)
                .andUser_idIn(userIdList);
        List<UserMachine> userMachineList = userMachineDao.selectByExample(ume);

        BigDecimal userTeamAmout = userMachineList.stream().map(UserMachine::getPer_amount)
                .reduce(BigDecimal.ZERO.setScale(5), BigDecimal::add).setScale(5);
        System.out.println("userTeamAmout:" + userTeamAmout);
        list = null;
        userIdList = null;
        ume = null;
        userMachineList = null;
        long endTime = Instant.now().toEpochMilli();
        return BigDecimal.valueOf((endTime - startTime)).divide(BigDecimal.valueOf(1000));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String transaction() {
        /*int i = 30001;
        UserMachine record = new UserMachine();
        String s = String.valueOf(i);
        Long l = Long.valueOf(i);
        BigDecimal bd = BigDecimal.valueOf(i);
        record.setUser_machine_id(l);
        record.setUser_id(l);
        record.setCreated_by(s);
        record.setCycle_of_operation(i);
        record.setExpire_time(l);
        record.setGenerate_of_amount(bd);
        record.setGenerate_of_time(i);
        record.setGmt_created(l);
        record.setIs_deleted(1);
        record.setLimit_count(i);
        record.setMachine_from(s);
        record.setMachine_id(l);
        record.setMachine_name(s);
        record.setMachine_type(s);
        record.setPer_amount(bd);
        record.setSort(i);
        record.setState(s);
        record.setTotal_amount(bd);
        userMachineDao.insertSelective(record);
        
        UserMachineExample example = new UserMachineExample();
        example.createCriteria().andIs_deletedEqualTo(1).andUser_machine_idEqualTo(l);
        List<UserMachine> list = userMachineDao.selectByExample(example);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return JSON.toJSONString(list);*/
        
        int i = 19999;
        UserMachine recordOne = new UserMachine();
        recordOne.setUser_machine_id(Long.valueOf(i));
        recordOne.setUser_id(Long.valueOf(11));
        userMachineDao.updateByPrimaryKeySelective(recordOne);
        
        UserMachine recordTwo = new UserMachine();
        recordTwo.setUser_machine_id(Long.valueOf(i));
        recordTwo.setMachine_id(Long.valueOf(11));
        userMachineDao.updateByPrimaryKeySelective(recordTwo);
        
        UserMachineExample example = new UserMachineExample();
        example.createCriteria().andIs_deletedEqualTo(1).andUser_machine_idEqualTo(Long.valueOf(i));
        List<UserMachine> list = userMachineDao.selectByExample(example);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return JSON.toJSONString(list);
    }
}
