package com.sapo.team03.MCRM.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sapo.team03.MCRM.DAO.CategoryProductDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.DAO.LeadSourceDAO;
import com.sapo.team03.MCRM.Marketing.Model.Lead;
import com.sapo.team03.MCRM.Marketing.Model.LeadSource;
import com.sapo.team03.MCRM.Service.LeadService;
import com.sapo.team03.MCRM.Service.MailService;
import com.sapo.team03.MCRM.Service.XlsxHandler;

@RestController
@CrossOrigin(origins = "*")
public class LeadController {
	@Autowired
	LeadSourceDAO sourceDAO;
	@Autowired
	MailService mailService;
	@Autowired
	LeadDAO leadDAO;
	@Autowired
	CategoryProductDAO categoryDAO;

	@GetMapping("/lead/list")
	public List<Lead> getListLead(@RequestParam(value = "opportunity", required = false) Integer opp) {
		List<Lead> list = new ArrayList<Lead>();
		if(opp!= null && opp == 0) list =  leadDAO.getLead();
		else if( opp!= null && opp == 1 ) list =  leadDAO.getOpportunity();
		else list = leadDAO.findAll();
		Collections.sort(list, (s1, s2) -> {
			return s1.getCreate_date().compareTo(s2.getCreate_date());
		});
		Collections.reverse(list);
		return list;
	}

	@RequestMapping(value = "/lead/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadXlsx(@RequestParam("file") MultipartFile file) {
		XlsxHandler handler = new XlsxHandler(file);
		LeadService service = new LeadService();
		try {
			handler.receiveFile();
			service.setHandler(handler);
			service.setSourceDAO(sourceDAO);
			service.setLeadDAO(leadDAO);
			service.setCategoryDAO(categoryDAO);
			service.setMailService(mailService);
			service.addLeads();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("lead/add")
	public Lead addLead(@RequestBody Lead lead) {
		if(lead.getName()==null) throw new RuntimeException("Name can not be null");
		return leadDAO.saveAndFlush(lead);
	}

	@DeleteMapping("lead/delete/{id}")
	public void deleteLead(@PathVariable Long id) {
		leadDAO.deleteById(id);
	}
	@DeleteMapping("lead/delete")
	public void undo(){
		leadDAO.undo();
	}
	@GetMapping("source/list")
	public List<LeadSource> getListSource(){
		return sourceDAO.findAll();
	}

}
