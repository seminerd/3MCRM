package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerGroupDAO;
import com.sapo.team03.MCRM.Model.CustomerGroup;

@RestController
@CrossOrigin(origins = "*")
public class CustomerGroupController {
	@Autowired
	CustomerGroupDAO customerGroupDAO;
	
	@GetMapping("customer-group/list")
	public List<CustomerGroup> getCustomerGroupList(){
		return customerGroupDAO.findAll();
	}
	
	@GetMapping("customer-group/{id}")
	public CustomerGroup getCustomerGroupById(@PathVariable Long id) {
		return customerGroupDAO.findById(id).get();
	}
	
	@PutMapping("customer-group/{id}")
	public CustomerGroup editGroupInf(@PathVariable Long id, @RequestBody CustomerGroup customerGroup) {
		CustomerGroup cg = customerGroupDAO.findById(id).get();
		if(customerGroup.getName()!= null) cg.setName(customerGroup.getName());
		if(customerGroup.getDefaultPrice()!= null) cg.setDefaultPrice(customerGroup.getDefaultPrice());
		if(customerGroup.getDiscount()!= null) cg.setDiscount(customerGroup.getDiscount());
		if(customerGroup.getDefaultTax()!= null) cg.setDefaultTax(customerGroup.getDefaultTax());
		if(customerGroup.getNote() != null) cg.setNote(customerGroup.getNote());
		return customerGroupDAO.saveAndFlush(cg);
	}
}
