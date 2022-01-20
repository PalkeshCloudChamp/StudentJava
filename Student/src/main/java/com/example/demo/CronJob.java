package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronJob {
	
/*
 * 
 * 
 * The below express written is the way to access the variable value from the
 * application.properties file which is available in resource folder!
 * This is the standard way to access/get the secret values.
 * Secret values should not be stored inside the Code!
 * It is always be refrenced as per the security norms.
 * 
 * 
 */
	@Value("${uname}")
	private String username;
	@Value("${password}")
	private String pass;
	
	
	
//	@Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
//	@Scheduled(cron = "0 0 12 * * ?")     => fires at 12PM
//	@Scheduled(cron = "0 15 10 * * ? 2005") 		=> Fires at 10:15 AM every day in the year 2005:
//	@Scheduled(cron = "0/4 * * * * ?")	/ @Scheduled(fixedDelay = 20000) 	=> Fires every 20 seconds:
	@Scheduled(cron = "0/4 * * * * ?")
//	@Scheduled(cron =  " 0 36 14 * * ?")
	public void someCronJob() {
		System.out.println("Cron Job....");
		System.out.println(username);
		System.out.println(pass);
	}
}
