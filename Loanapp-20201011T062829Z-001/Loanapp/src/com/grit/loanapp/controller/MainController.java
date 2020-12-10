package com.grit.loanapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.grit.loanapp.dao.CustomerDAO;
import com.grit.loanapp.dao.LoginDAO;
import com.grit.loanapp.dao.SaveDAO;
import com.grit.loanapp.model.Customer;

@Controller
public class MainController {
	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private SaveDAO saveDAO;
	
	//login check
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request,ModelAndView model)
	{
		String id= request.getParameter("userId");
		String password= request.getParameter("userPassword");
		String result = loginDAO.check(id, password);
		if(result==null)
		{
			return new ModelAndView("failLogin");
		}
		if(!(result.equals(password)))
		{
			return new ModelAndView("failLogin");
		}
		if(result.equals(password) && id.equals("role1"))
		{
			return new ModelAndView("loan");
		}
		if(result.equals(password) && id.equals("role2"))
		{
			return role2(model);
		}
		if(result.equals(password) && id.equals("role3"))
		{
			return role3(model);
		}
		if(result.equals(password) && id.equals("role4"))
		{
			return role4(model);
		}
	
		return new ModelAndView("failLogin");
	
	}
	//reject a loan
	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int enquiry_id = Integer.parseInt(request.getParameter("id"));
	    customerDAO.delete(enquiry_id);
	    return new ModelAndView("delete");
	}
	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(HttpServletRequest request) {
	    int enquiry_id = Integer.parseInt(request.getParameter("id"));
	    customerDAO.saction(enquiry_id);
	    return new ModelAndView("sactioned");
	}
	public ModelAndView role2(ModelAndView model)
	{
		List<Customer> c= customerDAO.get();
		model.addObject("listCustomer", c);
	    model.setViewName("role2");
		return model;
	
	}
	
	public ModelAndView role3(ModelAndView model)
	{
		List<Customer> c= customerDAO.getForRole3();
		model.addObject("listCustomer", c);
	    model.setViewName("role3");
		return model;
	
	}
	public ModelAndView role4(ModelAndView model)
	{
		List<Customer> c= customerDAO.getForRole4();
		model.addObject("listCustomer", c);
	    model.setViewName("role4");
		return model;
	
	}
	
	
	
	//login fail
	@RequestMapping(value="/revert")
	public String goToLogin()
	{
			return "index";
	}
	
	@RequestMapping(value="/")
	public String home()
	{
		return "index";
	}
	
	//
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("enquiryId"));
		String check = saveDAO.check(id);
		if(check==null)
		{
		String name= request.getParameter("userName");
		String type = request.getParameter("JobType");
		int  amount = Integer.parseInt(request.getParameter("amount"));
		int rate  = Integer.parseInt(request.getParameter("rate"));
		Customer c = new Customer(id,name,type,amount,rate,"N");
		saveDAO.save(c);
		if(rate<14)
		return "message";
		}
		
		else if(check.equals(request.getParameter("enquiryId")))
			return "loan";
		
	return "sactioned";
	}
			

}
