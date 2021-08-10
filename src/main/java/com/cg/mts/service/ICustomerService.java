package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Customer;

public interface ICustomerService {

	//Add Customer
	Customer addCustomer(Customer customer); //testcase done
	
	//Update Customer
	Customer updateCustomer(Customer customer); //testcase done
	
	//Delete Customer
	void deleteCustomer(int customerId); //testcase done
	
	//To view Customer by Id
	Customer viewCustomerById(int customerID); //testcase done
	
	//Update customer mobile number
	Customer updateCustomerMobNo(int customerId, String mobilenumber);
	
	//View all Customers
	List<Customer> viewAllCustomers(); //testcase done
	
	

	
	
	
	
	
}
