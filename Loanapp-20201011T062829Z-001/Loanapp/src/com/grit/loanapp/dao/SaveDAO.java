package com.grit.loanapp.dao;

import com.grit.loanapp.model.Customer;

public interface SaveDAO {
	public String check (int id);
	public int save(Customer customer);

}
