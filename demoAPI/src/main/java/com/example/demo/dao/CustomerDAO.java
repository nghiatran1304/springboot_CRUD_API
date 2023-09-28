package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{
	
//	@Query("SELECT c FROM Customer c")
//	List<Customer> lstCustomer();
	
	List<Customer> findByFullnameContaining(String name);
}
