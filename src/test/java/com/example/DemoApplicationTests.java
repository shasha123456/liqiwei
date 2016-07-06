package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.UseDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql("/data-test.sql")
public class DemoApplicationTests {

	@Autowired
	UseDao user ; 
	
	@Test
	public void contextLoads() {
		
		user.findUserById(1);
		System.out.println(user.findUserById(1).getLoginName());
	}

}
