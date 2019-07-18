package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Model.Staff;
import com.sapo.team03.MCRM.Utils.Utilities;

@RestController(value = "staffs")
public class StaffController {
	@Autowired
	Utilities util;
	@Autowired
	StaffDAO staffDAO;

	@GetMapping("staffs/list")
	public List<Staff> getAllStaff() {
		return staffDAO.findAll();
	}

	@PostMapping("staffs/add")
	public void addStaff(@RequestBody Staff staff) {
		staffDAO.addStaff(staff.getName(), staff.getEmail(), staff.getDob(), staff.getPhoneNumber(),
				staff.getPassword(), staff.getRole(), staff.getGender(), staff.getNote());
		util.log("Add staff Successfully");
	}

	@GetMapping("staffs/{id}")
	public Staff findStaffById(@PathVariable("id") Long id) {
		return staffDAO.findStaffById(id);
	}
}