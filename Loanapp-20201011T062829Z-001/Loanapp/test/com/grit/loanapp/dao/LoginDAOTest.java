package com.grit.loanapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class LoginDAOTest {
	
	private DriverManagerDataSource dataSource;
	private LoginDAO dao;
	@Test
	void test() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bank");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		dao = new LoginDAOImpl(dataSource);
		String id="role2";
		String password="password";
		String result = dao.check(id, password);
		System.out.println(result);
		assertTrue(password.equals(result));
		fail("Not yet implemented");
	}

}
