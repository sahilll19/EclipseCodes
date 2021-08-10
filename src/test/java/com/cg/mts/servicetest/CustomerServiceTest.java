package com.cg.mts.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService customerServ;
	
	//View All Customers
	@Test
	void testViewAllCustomers() {
		List<Customer> customer = customerServ.viewAllCustomers();
		assertEquals(4, customer.size());
	}
	
	//View Customer by Id
	@Test
	void testViewCustomerById() {
		Customer customer = customerServ.viewCustomerById(2);
		assertEquals("Raj Singh", customer.getCustomerName());
		assertEquals("raj@121", customer.getEmail());
		
	}
	
	//Update Customer
	@Test
	void testUpdateCustomer() {
		Customer customer =  new Customer(1, "Rohan Singh", "Nagpur", "9999990000", "rohan@121", "11111");
		Customer customer2 = customerServ.updateCustomer(customer);
		assertEquals("Rohan Singh", customer2.getCustomerName());
		assertEquals("rohan@121", customer2.getEmail());
		
	}
	
	//Add Customer
	@Test
	void testAddCustomer() {
		Customer customer =  new Customer(6, "Rakul Singh", "Pune", "8888880000", "rakul@121", "00000");
		Customer addCustomer = customerServ.addCustomer(customer);
		assertEquals("Rakul Singh", addCustomer.getCustomerName());
		assertEquals("rakul@121", addCustomer.getEmail());
		
	}
	
	//Update Customer mobile number
	@Test
	void testUpdateMobNoById() {
		Customer customer = new Customer(6, "8888880000" );
		Customer updateMob= customerServ.updateCustomerMobNo(6,"9999900000");
		assertEquals("9999900000", updateMob.getMobileNumber());
	}
	
	//Delete Customer
	@Test
	void testDeleteCustomer() {
		Customer customer = new Customer(5, "Ratan Manoj");
		customerServ.deleteCustomer(5);
	}
	
	
	
	
	

}
