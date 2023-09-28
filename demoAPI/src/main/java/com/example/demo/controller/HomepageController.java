package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class HomepageController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers(@RequestParam(required = false) String name) {
		if (name != null) {
			return customerService.searchByName(name);
		}
		return customerService.findAll();
	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		if (customerService.findById(id).isPresent()) {
			return customerService.save(customer);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	}

}
