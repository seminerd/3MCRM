package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.Model.Customer;
import com.sapo.team03.MCRM.Utils.Utilities;

@RestController(value = "customers")
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	Utilities util;

	@GetMapping("customers/list")
	public List<Customer> getAll() {
		return customerDAO.findAll();
	}

	@RequestMapping(value = "customers/add", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerDAO.addCustomer(customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getGroup(),
				customer.getGender(), customer.getDob(), customer.getDebt(), customer.getAddress());
		util.log("Added Successfully");

	}
	@GetMapping("customers/{id}")
	public Customer findCustomerById(@PathVariable("id") long id) {
		return customerDAO.findCustomerById(id);
	}
}
