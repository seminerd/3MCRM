package com.sapo.team03.MCRM.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sapo.team03.MCRM.DAO.CategoryProductDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.Model.Lead;
import com.sapo.team03.MCRM.Service.LeadService;
import com.sapo.team03.MCRM.Service.XlsxHandler;

@RestController
public class LeadController {
	@Autowired
	LeadDAO leadDAO;
	@Autowired
	CategoryProductDAO categoryDAO;

	@GetMapping("/lead/list")
	public List<Lead> getListLead(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		if (page != null && size == null)
			return leadDAO.findAll(PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "updateDate"))).getContent();
		if (page != null && size != null)
			return leadDAO.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updateDate"))).getContent();
		else
			return leadDAO.findAll();
	}

	@RequestMapping(value = "/lead/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadXlsx(@RequestParam("file") MultipartFile file) {
		XlsxHandler handler = new XlsxHandler(file);
		LeadService service = new LeadService();
		try {
			handler.receiveFile();
			service.setHandler(handler);
			service.setLeadDAO(leadDAO);
			service.setCategoryDAO(categoryDAO);
			service.addLeads();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

}
