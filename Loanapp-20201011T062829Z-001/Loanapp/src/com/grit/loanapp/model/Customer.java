package com.grit.loanapp.model;

public class Customer {
	private int enquiry_id;
	private String customer_name;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String job_type;
	private int amount;
	private int interest_rate;
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}

	private String status;
	public Customer() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Customer(int enquiry_id, String customer_name, String job_type, int amount, int interest_rate,String status) {
		super();
		this.enquiry_id = enquiry_id;
		this.customer_name = customer_name;
		this.job_type = job_type;
		this.amount = amount;
		this.interest_rate = interest_rate;
		this.status=status;
	}

	public int getEnquiryId() {
		return enquiry_id;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiry_id = enquiryId;
	}

	

	public String getJobType() {
		return job_type;
	}

	public void setJobType(String jobType) {
		this.job_type = jobType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

}
