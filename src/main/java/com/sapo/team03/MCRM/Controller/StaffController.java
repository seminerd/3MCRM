package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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

import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Exception.PasswordNotMatch;
import com.sapo.team03.MCRM.Exception.UsernameNotFound;
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
		return staffDAO.findAll();
	}

	@PostMapping("staffs/add")
	public String addStaff(@RequestBody Staff staff) {
		String encoded = BCrypt.hashpw(staff.getPassword(), BCrypt.gensalt());
		staff.setPassword(encoded);
		staffDAO.save(staff);
		return "ok";
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
		if(staff.getDonhang()!= null) sta.setDonhang(staff.getDonhang());
		if(staff.getEmail()!= null) sta.setEmail(staff.getEmail());
		if(staff.getGdkh()!= null) sta.setGdkh(staff.getGdkh());
		if(staff.getGender()!= null) sta.setGender(staff.getGender());
		if(staff.getName()!= null) sta.setName(staff.getName());
		if(staff.getNote()!= null) sta.setNote(staff.getNote());
		if(staff.getPassword()!= null) sta.setPassword(BCrypt.hashpw(staff.getPassword(), BCrypt.gensalt()));
		if(staff.getPhoneNumber()!= null) sta.setPhoneNumber(staff.getPhoneNumber());
		if(staff.getRole()!= null) sta.setRole(staff.getRole());
		if(staff.getRoleUA()!= null) sta.setRoleUA(staff.getRoleUA());
		staffDAO.save(sta);
		return staffDAO.findById(id).get();
	}
	@PostMapping("staffs/login")
	public Staff login(@RequestBody Staff staff) {
		Staff temp = staffDAO.findByEmail(staff.getEmail());
		if(temp == null) throw new UsernameNotFound(staff.getEmail());
		else {
			if( BCrypt.checkpw(staff.getPassword(), temp.getPassword())) {
				
				return temp;
			}
			else throw new PasswordNotMatch();
		}
	}
	@DeleteMapping("staffs/{id}")
	public void deleteStaff(@PathVariable Long id) {
		staffDAO.deleteById(id);
	}
	
}