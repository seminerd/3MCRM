package com.sapo.team03.MCRM.BusinessLogic.BusinessFunction;

import java.util.List;

import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.DaySale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.ProductSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.StaffSale;

public interface Calculator {

	List<DaySale> getWeekSale();

	List<DaySale> getMonthSale();

	List<DaySale> getYearSale();

	List<StaffSale> getStaffSale();

	List<StaffSale> getStaffMonthlySale();

	List<ProductSale> getNumberOfProdSoldMonthly();

	List<ProductSale> getTotalProductSold();

}