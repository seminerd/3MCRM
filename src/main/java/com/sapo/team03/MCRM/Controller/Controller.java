package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Model.Customer;
import com.sapo.team03.MCRM.Model.Staff;
import com.sapo.team03.MCRM.Utils.Notification;

@RestController("/")
public class Controller {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	StaffDAO staffDAO;

	@GetMapping("customers")
	public List<Customer> getAll() {
		return customerDAO.findAll();
	}

	@GetMapping("staffs")
	public List<Staff> getAllStaff() {
		return staffDAO.findAll();
	}

	@RequestMapping(value="customers/123",method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerDAO.addCustomer( customer.getName(), customer.getEmail(), customer.getPhoneNumber(),
				customer.getGroup(), customer.getGender(), customer.getDob(), customer.getDebt(),
				customer.getAddress());
		System.out.println("aaaaaaaaaaaaâ");
		
	}
}
