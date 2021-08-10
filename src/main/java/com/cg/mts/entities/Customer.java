package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="customer")
public class Customer {
	
	//Fields
	@Id
	@Column(name="customer_id", unique=true, nullable= false)
	private int customerId;
	@NotNull
	@Column(name="customer_name")
	private String customerName;
	@Column(name="address")
	private String address;
	
	@NotNull
	@Column(name="mobile_number", unique=true, nullable= false)
	private String mobileNumber;
	@Column(name="email")
	private String email;
	@Column
	private String password;
	
	//parameterized constructor
	public Customer(int customerId, String customerName, String address, String mobileNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public Customer() {}
	
	//for mockito testcase update customer
	public Customer(int customerId, String customerName, String mobileNumber){} 

	//for mockito testcase all customers
	public Customer(int customerId, String customerName) {}
	
	//for mockito testcase viewCustomer
	public Customer(String string, String string2) {}

	//getters and setters
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
