package com.grit.loanapp.dao;

import java.util.List;

import com.grit.loanapp.model.Customer;

public interface CustomerDAO {
public int save(Customer customer);
public List<Customer> get();
public List<Customer> getForRole2();
public List<Customer> getForRole3();
public List<Customer> getForRole4();
public void delete(int contactId);
public void saction(int enquiry_id);
}

