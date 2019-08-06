package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.BusinessLogic.BusinessFunction.Calculator;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.DaySale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.ProductSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.StaffSale;

@RestController
public class RevenueController {
	@Autowired
	Calculator revCalc;
	@GetMapping("/weeksale")
	public List<DaySale> getWeekSale(){
		return revCalc.getWeekSale();
	}
	@GetMapping("/staffmonthly")
	public List<StaffSale> getStaffMonthlySale(){
		return revCalc.getStaffMonthlySale();
	}
	@GetMapping("/totalmonthlysold")
	public List<ProductSale> getNumberOfProdSoldMonthly(){
		return revCalc.getNumberOfProdSoldMonthly();
	}
	@GetMapping("/totalsold")
	public List<ProductSale> getTotalProductSold(){
		return revCalc.getTotalProductSold();
	}
	
	
	

}
