package com.sapo.team03.MCRM.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Model.Customer;
import com.sapo.team03.MCRM.Model.Staff;

@RestController("/")
public class Controller {
	@Autowired 
	CustomerDAO customerDAO;
	@Autowired
	StaffDAO staffDAO;
	@GetMapping("customers")
	public List<Customer> getAll(){
		List<Customer> list = new ArrayList<Customer>();
		customerDAO.findAll().forEach(e -> list.add(e));
		return list;
	}
	@GetMapping("staffs")
	public List<Staff> getAllStaff(){
		List<Staff> list = new ArrayList<Staff>();
		staffDAO.findAll().forEach(e -> list.add(e));
		return list;
	}
}
