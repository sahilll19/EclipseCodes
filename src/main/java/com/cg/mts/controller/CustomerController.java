package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerServ; 

	//View all customers
	@GetMapping("/customer/all")
	public List<Customer> getAllCustomers()	{
		return customerServ.viewAllCustomers();
	}
	
	//Add customer
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerServ.addCustomer(customer);
	}
	
	//Update customer
	@PutMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServ.updateCustomer(customer);
	}
	
	//View customer by Id
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("customerId")int customerId) {
		return new ResponseEntity<>(customerServ.viewCustomerById(customerId), HttpStatus.OK);
	}
	
	//Delete customer by Id
	@DeleteMapping("/delete/{customerId}")
	public void deleteCustById(@PathVariable("customerId")int customerId) {
		customerServ.deleteCustomer(customerId);
	}
	
	//Update Customer mobile number
	@PatchMapping("/customer/{customerId}")
	public ResponseEntity<Customer> updateCustMobNo(@PathVariable("customerId")int customerId, @RequestBody String mobilenumber) {
		return new ResponseEntity<>(customerServ.updateCustomerMobNo(customerId, mobilenumber), HttpStatus.OK);
	}
}
