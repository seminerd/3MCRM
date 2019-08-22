package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.ConversionDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.Service.StatisticModel.Conversion;

@CrossOrigin("*")
@RestController
public class ConversionController {
	@Autowired
	ConversionDAO conversionDAO;
	@Autowired
	LeadDAO leadDAO;
	@GetMapping("conversion")
	public List<Conversion> getStatistic(){
		return conversionDAO.findAll();
	}
}
