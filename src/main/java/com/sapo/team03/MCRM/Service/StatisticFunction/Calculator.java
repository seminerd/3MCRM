package com.sapo.team03.MCRM.Service.StatisticFunction;

import java.util.List;

import com.sapo.team03.MCRM.Service.StatisticModel.DaySale;
import com.sapo.team03.MCRM.Service.StatisticModel.MonthSale;
import com.sapo.team03.MCRM.Service.StatisticModel.ProductSale;
import com.sapo.team03.MCRM.Service.StatisticModel.StaffSale;
import com.sapo.team03.MCRM.Service.StatisticModel.Statistics;

public interface Calculator {

	List<DaySale> getWeekSale();

	List<DaySale> getMonthSale();

	List<MonthSale> getYearSale();

	List<StaffSale> getStaffSale();

	List<StaffSale> getStaffMonthlySale();

	List<ProductSale> getNumberOfProdSoldMonthly();

	List<ProductSale> getTotalProductSold();

	Statistics getStatistics();
}