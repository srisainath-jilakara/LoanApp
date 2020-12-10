package com.grit.loanapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.grit.loanapp.model.Customer;

class CustomerDAOTest {
	
	private DriverManagerDataSource dataSource;
	private CustomerDAO dao;
	@Test
	void test() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bank");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		dao = new CustomerDAOImpl(dataSource);
		Customer customer = new Customer(2,"Sainat","Salaried",100000,15,"N");
		int result = dao.save(customer);
		assertTrue(result>0);
		fail("Not yet implemented");
	}

}
