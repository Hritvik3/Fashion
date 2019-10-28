package com.ecomm.test;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");//Initialization of Bean
	}
	@Test
	public void addUserTest()
	{
	UserDetail user=new UserDetail();
	user.setUsername("AlokTiwari,9");
	user.setPassword("12345");
	user.setEmailId("alok@gmail.com");
	user.setCustomerName("atul");
	user.setEnabled(true);
	user.setRole("ROLE_USER");
	user.setAddress("rm-no2,rameshnagar,lucknow");
    assertTrue("Problem in Adding user",userDAO.registerUser(user));
	}
}

