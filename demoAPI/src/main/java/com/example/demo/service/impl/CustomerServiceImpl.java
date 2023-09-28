package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<Customer> lstCustomer() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	public List<Customer> searchByName(String name) {
		return customerDAO.findByFullnameContaining(name);
	}

	public Customer save(Customer customer) {
		return customerDAO.save(customer);
	}

	public void delete(Long id) {
		customerDAO.deleteById(id);
	}

	public Optional<Customer> findById(Long id) {
		return customerDAO.findById(id);
	}

}
