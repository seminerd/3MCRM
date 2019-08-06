package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.CustomerGroupDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Exception.DuplicateEmail;
import com.sapo.team03.MCRM.Exception.DuplicatePhoneNumber;
import com.sapo.team03.MCRM.Exception.StaffNotFound;
import com.sapo.team03.MCRM.Model.Customer;
import com.sapo.team03.MCRM.Utils.Utilities;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	CustomerGroupDAO customerGroupDAO;
	@Autowired
	Utilities util;

//	@GetMapping("customers/list")
//	public List<Customer> getAll() {
//		return customerDAO.findAll();
//	}	
	@PostMapping("customers/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		if (customer.getEmail() != null) {
			Customer cus = customerDAO.findByEmail(customer.getEmail());
			if (cus != null)
				throw new DuplicateEmail(customer.getEmail());
		}
		if (customer.getPhone() != null) {
			Customer cus = customerDAO.findByPhonenumber(customer.getPhone());
			if (cus != null)
				throw new DuplicatePhoneNumber(customer.getPhone());
		}
		if (customer.getStaff() != null) {
			if (customer.getStaff().getId() == null)
				customer.setStaff(null);
			else if (staffDAO.findById(customer.getStaff().getId()).orElse(null) == null) {
				throw new StaffNotFound("Staff Id: " + customer.getStaff().getId());
			}
		}
		if (customer.getGroup() != null) {
			if (customer.getGroup().getId() == null)
				customer.setGroup(null);
			else if (customerGroupDAO.findById(customer.getGroup().getId()).orElse(null) == null) {
				throw new RuntimeException("Group id " + customer.getGroup().getId() + " not found");
			}
		}
		return customerDAO.save(customer);
		
	}

	@GetMapping("customers/{id}")
	public Customer findCustomerById(@PathVariable("id") long id) {
		return customerDAO.findById(id).get();
	}

	@PutMapping("customers/{id}")
	public Customer editCustomer(@RequestBody Customer cus, @PathVariable Long id) {
		Customer customer = customerDAO.findById(id).orElse(null);
		if (customer == null)
			return null;
		if (cus.getAddress() != null || cus.getAddress() != "")
			customer.setAddress(cus.getAddress());
		if (cus.getDebt() != null)
			customer.setDebt(cus.getDebt());
		if (cus.getDob() != null)
			customer.setDob(cus.getDob());
		if (cus.getEmail() != null)
			customer.setEmail(cus.getEmail());
		if (cus.getGender() != null)
			customer.setGender(cus.getGender());
		if (cus.getName() != null)
			customer.setName(cus.getName());
		if (cus.getNote() != null)
			customer.setNote(cus.getNote());
		if (cus.getPhone() != null)
			customer.setPhone(cus.getPhone());
		if (cus.getStaff() != null) {
			if (cus.getStaff().getId() != null) {
				if (staffDAO.findById(cus.getStaff().getId()).orElse(null) != null)
					customer.setStaff(cus.getStaff());
				else
					throw new StaffNotFound("Staff id : " + cus.getStaff().getId());
			}
		}
		if (cus.getGroup() != null) {
			if (cus.getGroup().getId() == null)
				customer.setGroup(null);
			else
				customer.setGroup(cus.getGroup());
		}
		customerDAO.save(customer);
		return customerDAO.findById(id).get();
	}

	@DeleteMapping("customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerDAO.deleteById(id);
	}

	@GetMapping("customers/list")
	public List<Customer> getCustomList(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		if (page != null && size == null)
			return customerDAO.findAll(PageRequest.of(page, 5)).getContent();
		if (page != null && size != null)
			return customerDAO.findAll(PageRequest.of(page, size)).getContent();
		else
			return customerDAO.findAll();
	}

	@GetMapping("customers/staff_id/{id}")
	public List<Customer> getCustomerByStaffId(@PathVariable Long id) {
		return customerDAO.getCustomersByStaffId(id);
	}

}
