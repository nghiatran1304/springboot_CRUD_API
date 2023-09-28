package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;

public interface CustomerService {
	public List<Customer> lstCustomer();

	public List<Customer> findAll();

	public List<Customer> searchByName(String name);

	public Customer save(Customer customer);

	public void delete(Long id);

	public Optional<Customer> findById(Long id);
}
