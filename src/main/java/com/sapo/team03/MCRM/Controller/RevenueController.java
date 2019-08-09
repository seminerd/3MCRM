package com.sapo.team03.MCRM.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.BusinessLogic.BusinessFunction.Calculator;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.DaySale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.MonthSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.ProductSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.StaffSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.Statistics;

@RestController
@CrossOrigin(origins="*")
public class RevenueController {
	@Autowired
	Calculator revCalc;
	@GetMapping("/weeksale")
	public List<DaySale> getWeekSale(){
		return revCalc.getWeekSale();
	}
	@GetMapping("/staffmonthly")
	public List<StaffSale> getStaffMonthlySale(){
		return revCalc.getStaffMonthlySale().stream().limit(5).collect(Collectors.toList());
	}
	@GetMapping("/totalmonthlysold")
	public List<ProductSale> getNumberOfProdSoldMonthly(){
		return revCalc.getNumberOfProdSoldMonthly().stream().limit(5).collect(Collectors.toList());
	}
	@GetMapping("/totalsold")
	public List<ProductSale> getTotalProductSold(){
		return revCalc.getTotalProductSold();
	}
	@GetMapping("monthsale")
	public List<DaySale> getMonthSale(){
		return revCalc.getMonthSale();
	}
	@GetMapping("yearsale")
	public List<MonthSale> getYearSale(){
		return revCalc.getYearSale();
	}
	@GetMapping("staffsale")
	public List<StaffSale> getStaffSale(){
		return revCalc.getStaffSale().stream().limit(5).collect(Collectors.toList());
	}
	@GetMapping("statistics")
	public Statistics getStatistics() {
		return revCalc.getStatistics();
	}
}
