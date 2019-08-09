package com.sapo.team03.MCRM.Controller;

import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.StaffDAO;
//import com.sapo.team03.MCRM.Exception.UsernameNotFound;
import com.sapo.team03.MCRM.Model.Staff;
import com.sapo.team03.MCRM.Utils.Utilities;
@CrossOrigin(origins="*")
@RestController(value = "staffs")
public class StaffController {
	@Autowired
	Utilities util;
	@Autowired
	StaffDAO staffDAO;

	@GetMapping("staffs/list")
	public List<Staff> getAllStaff(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
		if(page != null && size != null) return staffDAO.findAll(PageRequest.of(page, size)).getContent();
		if(page != null && size == null) return staffDAO.findAll(PageRequest.of(page, 20)).getContent();
		return staffDAO.findAll(Sort.by(Sort.Direction.DESC, "updateDate"));
	}

	@PostMapping("staffs/add")
	public Staff addStaff(@RequestBody Staff staff) {
		String encoded = BCrypt.hashpw(staff.getPassword(), BCrypt.gensalt());
		staff.setPassword(encoded);
		staff.setUpdateDate(new Date());
		return staffDAO.save(staff);
		
	}

	@GetMapping("staffs/{id}")
	public Staff findStaffById(@PathVariable("id") Long id) {
		return staffDAO.findById(id).orElse(null);
	}
	@PutMapping("staffs/{id}")
	public Staff editStaff(@PathVariable Long id, @RequestBody Staff staff) {
		Staff sta = staffDAO.findById(id).orElse(null);
		if(sta == null) return null;
		if(staff.getCustomers()!= null) sta.setCustomers(staff.getCustomers());
		if(staff.getDob()!= null) sta.setDob(staff.getDob());
		if(staff.getOrders()!= null) sta.setOrders(staff.getOrders());
		if(staff.getEmail()!= null) sta.setEmail(staff.getEmail());
		if(staff.getTransactions()!= null) sta.setTransactions(staff.getTransactions());
		if(staff.getGender()!= null) sta.setGender(staff.getGender());
		if(staff.getName()!= null) sta.setName(staff.getName());
		if(staff.getDescription()!= null) sta.setDescription(staff.getDescription());
		if(staff.getPassword()!= null) sta.setPassword(BCrypt.hashpw(staff.getPassword(), BCrypt.gensalt()));
		if(staff.getPhone()!= null) sta.setPhone(staff.getPhone());
		if(staff.getRole()!= null) sta.setRole(staff.getRole());
		if(staff.getJobTitle()!= null) sta.setJobTitle(staff.getJobTitle());
		sta.setUpdateDate(new Date());
		staffDAO.save(sta);
		return staffDAO.findById(id).get();
	}

	@DeleteMapping("staffs/{id}")
	public void deleteStaff(@PathVariable Long id) {
		staffDAO.deleteById(id);
	}
	
}