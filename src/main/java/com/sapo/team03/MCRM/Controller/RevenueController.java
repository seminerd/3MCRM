package com.sapo.team03.MCRM.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.Service.StatisticFunction.Calculator;
import com.sapo.team03.MCRM.Service.StatisticModel.DaySale;
import com.sapo.team03.MCRM.Service.StatisticModel.MonthSale;
import com.sapo.team03.MCRM.Service.StatisticModel.ProductSale;
import com.sapo.team03.MCRM.Service.StatisticModel.StaffSale;
import com.sapo.team03.MCRM.Service.StatisticModel.Statistics;

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
	@GetMapping("customersale")
	public List<StaffSale> getCustomerMonthlySpending(){
		return revCalc.getCustomerSpending().stream().limit(5).collect(Collectors.toList());
	}
}
