package com.grit.loanapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.grit.loanapp.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	private JdbcTemplate jdbcTemplate;
	public CustomerDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO CUSTOMER(enquiry_id,customer_name,job_type,amount,interest_rate) values(?,?,?,?,?)";
	return	jdbcTemplate.update(sql,c.getEnquiryId(),c.getCustomer_name(),c.getJobType(),c.getAmount(),c.getInterest_rate());	
	
	}

	@Override
	public List<Customer> get() {
		    String sql = "SELECT * FROM Customer";     
		    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public List<Customer> getForRole2() {
		 String sql = "SELECT * FROM Customer where interest_rate between 13 and 14";     
		    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public List<Customer> getForRole3() {
		String sql = "SELECT * FROM Customer where interest_rate between 12 and 13 and status='N' ";     
	    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public List<Customer> getForRole4() {
		String sql = "SELECT * FROM Customer where interest_rate <12 and status='N' ";     
	    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public void delete(int enquiryId) {
		  String sql = "DELETE FROM Customer WHERE enquiry_id=?";
		    jdbcTemplate.update(sql, enquiryId);
		
	}

	@Override
	public void saction(int enquiry_id) {
		 String sql = "Update  Customer set status='Y' WHERE enquiry_id=?";
		    jdbcTemplate.update(sql, enquiry_id);
		
	}

}
