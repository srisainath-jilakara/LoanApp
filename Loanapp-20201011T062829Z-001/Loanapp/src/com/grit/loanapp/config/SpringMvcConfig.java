package com.grit.loanapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.grit.loanapp.dao.CustomerDAO;
import com.grit.loanapp.dao.CustomerDAOImpl;
import com.grit.loanapp.dao.LoginDAO;
import com.grit.loanapp.dao.LoginDAOImpl;
import com.grit.loanapp.dao.SaveDAO;
import com.grit.loanapp.dao.SaveDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.grit.loanapp")
public class SpringMvcConfig implements WebMvcConfigurer{

	@Bean
	public DataSource getDataSource()
	{
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/bank");
	dataSource.setUsername("root");
	dataSource.setPassword("password");
	return dataSource;
	}
	
	@Bean
	
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	
	public CustomerDAO getCustomerDAO()
	{
		return new CustomerDAOImpl(getDataSource());
		
	}
@Bean
	
	public LoginDAO getLoginDAO()
	{
		return new LoginDAOImpl(getDataSource());		
	}

@Bean
public SaveDAO getSaveDAO()
{
	return new SaveDAOImpl(getDataSource());		
}

}
