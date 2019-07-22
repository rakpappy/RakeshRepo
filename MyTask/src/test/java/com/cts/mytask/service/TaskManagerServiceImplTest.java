package com.cts.mytask.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.mytask.entity.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@SpringBootConfiguration
//@ComponentScan("com.cts.*")
public class TaskManagerServiceImplTest {

	@Autowired
	TaskManagerService taskManagerService;
	
	
	@Test
	public void testaddUser() {
		
		User user =new User();
		user.setFirstName("Raj");
		user.setLastName("Kumar");
		user.setEmployeeId(101);
		
		String  msg =taskManagerService.addUser(user);
		
		
		
		assertEquals("",msg,"SUCCESS");
		
		
	}
	
}

