package com.example.demo;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	    @Scheduled(cron = "0/5 * * * * *") 
	    public void runTask() {
	        System.out.println("Current time is :"+new Date().toString());
	    
	}

}
