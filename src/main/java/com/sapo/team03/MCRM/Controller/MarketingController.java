package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.MarketingDAO;
import com.sapo.team03.MCRM.Marketing.Model.Marketing;

@CrossOrigin("*")
@RestController
public class MarketingController {
	@Autowired
	MarketingDAO marketingDAO;
	@GetMapping("marketing")
	public List<Marketing> getListStrategies(){
		return marketingDAO.findAll();
	}
}
