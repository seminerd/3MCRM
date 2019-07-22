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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.Exception.DuplicateEmail;
import com.sapo.team03.MCRM.Exception.DuplicatePhoneNumber;
import com.sapo.team03.MCRM.Model.Customer;
import com.sapo.team03.MCRM.Utils.Utilities;
@CrossOrigin(origins="*")
@RestController(value = "customers")
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	Utilities util;

//	@GetMapping("customers/list")
//	public List<Customer> getAll() {
//		return customerDAO.findAll();
//	}	
	@PostMapping("customers/add")
	public void addCustomer(@RequestBody Customer customer) {
		if (customer.getEmail()!= null) {
			Customer cus = customerDAO.findByEmail(customer.getEmail());
		if(cus!= null) throw new DuplicateEmail(customer.getEmail());
		}
		if(customer.getPhoneNumber()!= null) {
		Customer cus = customerDAO.findByPhonenumber(customer.getPhoneNumber());
		if(cus!= null) throw new DuplicatePhoneNumber(customer.getPhoneNumber());
		
	}
		customerDAO.save(customer);
	//	return "ok";
	}
	
	@GetMapping("customers/{id}")
	public Customer findCustomerById(@PathVariable("id") long id) {
		return customerDAO.findById(id).orElse(null);
	}
	
	@PutMapping("customers/{id}")
	public Customer editCustomer(@RequestBody Customer cus, @PathVariable Long id) {
		Customer customer = customerDAO.findById(id).orElse(null);
		if(customer==null)  return null;
		if(cus.getAddress()!= null || cus.getAddress()!= "") customer.setAddress(cus.getAddress());
		if(cus.getDebt()!= null) customer.setDebt(cus.getDebt());	
		if(cus.getDob()!=null) customer.setDob(cus.getDob());
		if(cus.getEmail()!=null) customer.setEmail(cus.getEmail());
		if(cus.getGender()!= null) customer.setGender(cus.getGender());
		if(cus.getName()!= null) customer.setName(cus.getName());
		if(cus.getNote()!= null) customer.setNote(cus.getNote());
		if(cus.getPhoneNumber()!= null) customer.setPhoneNumber(cus.getPhoneNumber());
		if(cus.getPriority()!= null) customer.setPriority(cus.getPriority());
		if(cus.getStaff()!= null || cus.getStaff().getId()!=null ) customer.setStaff(cus.getStaff());
		if(cus.getNhomkhachhang()!= null) customer.setNhomkhachhang(cus.getNhomkhachhang());
		customerDAO.save(customer);
		return customerDAO.findById(id).get();
	}
	@DeleteMapping("customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerDAO.deleteById(id);
	}
	@GetMapping("customers/list")
	public List<Customer> getCustomList(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size){
		if(page != null && size == null) return customerDAO.findAll(PageRequest.of(page, 5)).getContent();
		if(page != null && size != null) return customerDAO.findAll(PageRequest.of(page, size)).getContent();
		else return customerDAO.findAll();
	}
//	@PostMapping("customers/insert")
//	public void insertCustomers(@RequestBody Customer customer) {
//		customerDAO.insertCustomer(customer.getName(), customer.getAddress(), customer.getDob(), customer.getEmail(),
//				customer.getPhoneNumber(), customer.getPriority(), customer.getGender(), customer.getDebt(), customer.getNote(),
//				customer.getStaff().getId(), customer.getNhomkhachhang().getId());
//	}
	@GetMapping("customers/staff_id/{id}")
	public List<Customer> getCustomerByStaffId(@PathVariable Long id){
		return customerDAO.getCustomersByStaffId(id);
	}
}
