package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.MailDAO;
import com.sapo.team03.MCRM.DAO.MailFormDAO;
import com.sapo.team03.MCRM.Marketing.Model.Customer;
import com.sapo.team03.MCRM.Marketing.Model.Email;
import com.sapo.team03.MCRM.Marketing.Model.MailForm;

@CrossOrigin("*")
@RestController
public class MailController {
	@Autowired
	MailFormDAO mailFormDAO;
	@Autowired
	MailDAO mailDAO;
	@Autowired
	CustomerDAO customerDAO;
	@GetMapping("mail-form")
	public List<MailForm> getMailForm(){
		return mailFormDAO.findAll();
	}
	@PostMapping("mail-form/add")
	public MailForm addForm(@RequestBody MailForm form) {
		return mailFormDAO.save(form);
	}
	@GetMapping("mail/list/{id}")
	public List<Email> getEmailList(@PathVariable Long id){
		Customer customer = customerDAO.findById(id).get();
		return mailDAO.getMailHis(customer.getEmail());
	}
}
