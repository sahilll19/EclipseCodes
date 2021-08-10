package com.cg.mts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
	
	
}
