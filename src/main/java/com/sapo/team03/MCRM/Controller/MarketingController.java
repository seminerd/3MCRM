package com.sapo.team03.MCRM.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CustomerGroupDAO;
import com.sapo.team03.MCRM.DAO.MarketingDAO;
import com.sapo.team03.MCRM.Marketing.Model.Customer;
import com.sapo.team03.MCRM.Marketing.Model.CustomerGroup;
import com.sapo.team03.MCRM.Marketing.Model.Marketing;
import com.sapo.team03.MCRM.Service.MailService;

@CrossOrigin("*")
@RestController
public class MarketingController {
	@Autowired
	MarketingDAO marketingDAO;
	@Autowired
	MailService mailServie;
	@Autowired
	CustomerGroupDAO customerGroupDAO;
	@GetMapping("marketing")
	public List<Marketing> getListStrategies() {
		return marketingDAO.findAll();
	}
	@Transactional
	@PostMapping("marketing/{id}")
	public Marketing addStrategy(@RequestBody Marketing marketing, @PathVariable int id) {
//		long start = System.nanoTime();
		try {
			marketingDAO.saveAndFlush(marketing);
			Set<Customer> recipients  = new HashSet<Customer>();
			
			for (CustomerGroup customerGroup : marketing.getGroupMarketing()) {
				for(Customer customer : customerGroupDAO.findById(customerGroup.getId()).get().getCustomers()){
					recipients.add(customer);
				}
				
			}
			for(Customer customer : recipients) {
				mailServie.sendMail(customer.getName(), id, customer.getEmail());
			}
			System.out.println("okok");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		long end = System.nanoTime();
//		System.out.println("execute time = " + (end - start)/1000000);
		return null;
	}
}
