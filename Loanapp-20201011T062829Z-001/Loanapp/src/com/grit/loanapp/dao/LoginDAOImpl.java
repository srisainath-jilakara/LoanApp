package com.grit.loanapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LoginDAOImpl implements LoginDAO {
	private JdbcTemplate jdbcTemplate;
	public LoginDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	@Override
	public String check(String id, String password) {
	String sql = "select UserPassword from credentials where UserId="+  "\"" +id + "\"";
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

}
