package com.cg.mts.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.mts.entities.Customer;
import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.service.CustomerServiceImpl;

@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {
	
	@InjectMocks
	CustomerServiceImpl customerServ;

	//Mocking Dao
	@MockBean
	ICustomerRepository customerDao;  
	
	
	//Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAllCustomers() {
		Customer customer1 = new Customer(1, "Rohan Singh");
		Customer customer2 = new Customer(2, "Raj Singh");
		Customer customer3 = new Customer(3, "Raman Singh");
		
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		
		Mockito.when(customerDao.findAll()).thenReturn(customerList);
		List<Customer> customers = customerServ.viewAllCustomers();
		
		assertEquals(3, customers.size());
	}
	
	@Test
	void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("Prithvi Singh");
		customer.setCustomerId(4);
		customer.setMobileNumber("8888888880");
		
		Mockito.when(customerDao.save(customer)).thenReturn(customer);
		Customer response = customerServ.addCustomer(customer);
		
		assertEquals(response, customer);
	}
	
	@Test
	void testUpdateCustomer() {
		
	    int customerId=2;
		Customer customer4 = new Customer(2, "Raj Singh", "9999999990");
		
		Mockito.when(customerDao.findById(customerId)).thenReturn(Optional.of(customer4));
		Mockito.when(customerDao.save(customer4)).thenReturn(customer4);
		
		Customer persistedCustomer = customerServ.updateCustomer(customer4);
		
		assertEquals(persistedCustomer, customer4);
		
		
	}
	
	@Test
	void testViewCustomerById() {
		int customerId = 10;
		Customer customer3 = new Customer("Nagpur", "Raman Singh");
		
		Mockito.when(customerDao.findById(customerId)).thenReturn(Optional.of(customer3));
		
		assertEquals(customer3, customerServ.viewCustomerById(customerId));
		
		
	}
	
	@Test
	void testDeleteCustomer() {
		
		Customer customer = new Customer(2, "Nagpur", "Raman Singh");
		Mockito.when(customerDao.findById(2)).thenReturn(Optional.of(customer));
		customerServ.deleteCustomer(2);
		Mockito.verify(customerDao).deleteById(2);
		
	}
	
	@Test
	void testUpdateCustomerMobNo() {
		
		Customer customer = new Customer(2, "8888888000", "Raman Singh");
		Mockito.when(customerDao.findById(2)).thenReturn(Optional.of(customer));
		Mockito.when(customerDao.save(customer)).thenReturn(customer);
		
		Customer response = customerServ.updateCustomerMobNo(2, "8888888000");
		
		assertEquals(response, customer);
	}
	
	

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
