/*
 * UserService.java 2017年6月8日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.quartz.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.quartz.entity.User;
import com.jvbo.springboot.quartz.example.SampleJob;
import com.jvbo.springboot.quartz.repository.UserRepository;
import com.jvbo.springboot.quartz.service.IUserService;

@Service
public class UserService implements IUserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private Scheduler scheduler;

	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public User save(User record) {
		User user = userRepository.save(record);
		return user;
	}

    @Override
    public void sampleTaskTwo() {
        // TODO Auto-generated method stub
        try {
            sampleTaskTwo(1L);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void sampleTaskOne(Long userId) throws SchedulerException{
        String taskName = UUID.randomUUID().toString();
        String groupName = SampleJob.class.getName();
        
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("1-59 * * * * ?");
        
        JobDetail jobDetail = JobBuilder
                .newJob(SampleJob.class)
                .withIdentity(taskName, groupName)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName, groupName).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
        
    }
	
	private void sampleTaskTwo(Long userId) throws SchedulerException{
	    String taskName = UUID.randomUUID().toString();
	    String groupName = SampleJob.class.getName();
	    
	    long startTime = System.currentTimeMillis() + 1000;
	    
        JobDetail jobDetail = JobBuilder
                .newJob(SampleJob.class)
                .withIdentity(taskName, groupName)
                .build();
        jobDetail.getJobDataMap().put("userId", userId);
        
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName, groupName)
                .withSchedule(scheduleBuilder)
                .startAt(new Date(startTime)).endAt(DateUtils.addSeconds(new Date(startTime), 30)).build();
        
        scheduler.scheduleJob(jobDetail, trigger);
	}
	
}
