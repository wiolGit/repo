package com.example.apzumi2.config;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.apzumi2.service.ScheduleServiceInter;



@Configuration
@EnableScheduling
public class ScheduleClass {

	
	@Autowired
	ScheduleServiceInter scheduleServiceInter;
	
	@Scheduled(cron = "1 10 4 * * ?")
	//@Scheduled(cron = "0 39 20 * * ?")
	public void scheduleTaskUsingCronExpression() {
	  
	
	    SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
	    String current_time_str = time_formatter.format(System.currentTimeMillis());
	    System.out.println(
	      "schedule tasks run post update - " + current_time_str);
	    
	    scheduleServiceInter.startGetContentService();
	    
	}
}
