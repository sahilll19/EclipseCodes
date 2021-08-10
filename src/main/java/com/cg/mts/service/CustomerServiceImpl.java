package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.InvalidIdException;
import com.cg.mts.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerDao;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		//Find Customer
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			
			//update customer details
			Customer cust = opt.get();
			cust.setCustomerName(customer.getCustomerName());
			cust.setAddress(customer.getAddress());
			cust.setMobileNumber(customer.getMobileNumber());
			cust.setEmail(customer.getEmail());
			cust.setPassword(customer.getPassword());
			
			//Save customer
			customerDao.save(cust);
		}
		//throw exception
		else {
			throw new InvalidIdException("Enter valid customerId");
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		//Find customer
		Optional<Customer> opt = customerDao.findById(customerId);
		if(opt.isPresent()) {
			customerDao.deleteById(customerId);
		}
		//throw exception
		else {
			throw new InvalidIdException("Enter valid customerId");
		}
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		Optional<Customer> opt = customerDao.findById(customerId);
		
		//throw exception if given given is not present
		if(!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given Id: "+customerId);
		}
		return opt.get();
			
	}
	

	@Override
	public Customer updateCustomerMobNo(int customerId, String mobilenumber) {
		//Find Customer
		Optional<Customer> opt = customerDao.findById(customerId);
		//Update mobile number
		Customer customer1 = opt.get();
		
		//throw exception
		if(!opt.isPresent()) {
			throw new InvalidIdException("Enter valid customer Id");
		}
		else {
			customer1.setMobileNumber(mobilenumber);
			//save
			customerDao.save(customer1);
		}
		
		return customer1 ;
	}

	
	
}
