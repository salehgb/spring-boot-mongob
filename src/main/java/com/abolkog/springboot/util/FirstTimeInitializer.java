package com.abolkog.springboot.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.abolkog.springboot.security.AppUser;
import com.abolkog.springboot.security.UserService;
@Component
public class FirstTimeInitializer implements CommandLineRunner{
	private static final Log logger = LogFactory.getLog(FirstTimeInitializer.class);
	
    @Autowired
	private UserService userService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//check we have users
		if(userService.findAll().isEmpty()) {
			logger.info("No Users Counts found. Create Some Users");
			AppUser user =new AppUser("gbsal55@gmail.com","password","salah");
			userService.save(user);
		}
		
		//if not create som users
	}

}
