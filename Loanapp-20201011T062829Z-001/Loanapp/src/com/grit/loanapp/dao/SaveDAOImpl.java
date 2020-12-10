package com.grit.loanapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.grit.loanapp.model.Customer;

public class SaveDAOImpl implements SaveDAO {
	
	private JdbcTemplate jdbcTemplate;
	public SaveDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

	@Override
	public String check(int id) {
		String sql = "select enquiry_id from customer where enquiry_id=" + id;
		 return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
		        @Override
		        public String extractData(ResultSet rs) throws SQLException,
		                                                       DataAccessException {
		        	if(rs.next()){
		        		   return rs.getString(1);
		        		}
		            	return null;	
		        }
		    });
	
	}

	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO CUSTOMER(enquiry_id,customer_name,job_type,amount,interest_rate) values(?,?,?,?,?)";
		return	jdbcTemplate.update(sql,c.getEnquiryId(),c.getCustomer_name(),c.getJobType(),c.getAmount(),c.getInterest_rate());	
		
	}

}
