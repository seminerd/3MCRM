package com.sapo.team03.MCRM.Service.StatisticFunction;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapo.team03.MCRM.DAO.ConversionDAO;
import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.DAO.OrderDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Service.StatisticModel.DaySale;
import com.sapo.team03.MCRM.Service.StatisticModel.MonthSale;
import com.sapo.team03.MCRM.Service.StatisticModel.ProductSale;
import com.sapo.team03.MCRM.Service.StatisticModel.StaffSale;
import com.sapo.team03.MCRM.Service.StatisticModel.Statistics;

public class RevenueCalculator implements Calculator {
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	LeadDAO leadDAO;
	@Autowired
	ConversionDAO conversionDAO;
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<DaySale> getWeekSale() {
		LocalDate today = LocalDate.now();
		List<DaySale> daySale = new ArrayList<DaySale>();
		for (int i = 1; i <= 7; i++) {
			DaySale e = new DaySale();
			today = today.minusDays(1);
			e.setDate(today);
			e.setValues(orderDAO.getSaleByDay(today));
			if(e.getValues()==null) e.setValues(0.0);
			daySale.add(e);
		}
		Collections.reverse(daySale);
		return daySale;
	}

	@Override
	public List<DaySale> getMonthSale() {
		LocalDate today = LocalDate.now();
		List<DaySale> daySale = new ArrayList<DaySale>();
		for (int i = 1; i < 31; i++) {
			DaySale e = new DaySale();
			today = today.minusDays(1);
			e.setDate(today);
			e.setValues(orderDAO.getSaleByDay(today));
			if(e.getValues()==null) e.setValues(0.0);
			daySale.add(e);
		}
		Collections.reverse(daySale);
		return daySale;
	}

	@Override
	public List<MonthSale> getYearSale() {
		List<MonthSale> monthSale = new ArrayList<MonthSale>();		
		for (int i = 0; i < 12; i++) {
			MonthSale e = new MonthSale();
//			YearMonth month = YearMonth.now().minusMonths(i);
			LocalDate today = LocalDate.now().minusMonths(i);
			YearMonth month = YearMonth.from(today);
			e.setMonth(month);
			e.setValues(orderDAO.getSaleByMonth(today));
			if(e.getValues()==null) e.setValues(0.0);
			monthSale.add(e);
		}
		Collections.reverse(monthSale);
		return monthSale;
	}

	@Override
	public List<StaffSale> getStaffSale() {
		List<StaffSale> list = new ArrayList<>();
		List<Long> ID = staffDAO.getStaffId();
		for (Long id : ID) {
			StaffSale e = new StaffSale();
			e.setId(id);
			e.setName(staffDAO.getStaffNameById(id));
			e.setValues(orderDAO.getStaffSale(id));
			if (e.getValues() == null)
				e.setValues(0.0);
			list.add(e);
		}
		Collections.sort(list, (s1, s2) -> {
			return s1.getValues().compareTo(s2.getValues());
		});
		Collections.reverse(list);
		return list;
	}

	@Override
	public List<StaffSale> getStaffMonthlySale() {
		List<StaffSale> list = new ArrayList<>();
		List<Long> ID = staffDAO.getStaffId();
		for (Long id : ID) {
			StaffSale e = new StaffSale();
			e.setId(id);
			e.setName(staffDAO.getStaffNameById(id));
			e.setValues(orderDAO.getStaffMonthlySale(id));
			if (e.getValues() == null)
				e.setValues(0.0);
			list.add(e);
		}
		Collections.sort(list, (s1, s2) -> {
			return s1.getValues().compareTo(s2.getValues());
		});
		Collections.reverse(list);
		return list;
	}

	@Override
	public List<ProductSale> getNumberOfProdSoldMonthly() {
		List<Object[]> temp = entityManager.createQuery("select id, name from Product", Object[].class).getResultList();
		List<ProductSale> list = new ArrayList<>();
		for (Object[] row : temp) {
			ProductSale e = new ProductSale();
			e.setId((Long) row[0]);
			e.setName((String) row[1]);
			e.setQuantity(orderDAO.getProdNum(e.getId()));
			if(e.getQuantity()==null) e.setQuantity(0);
			list.add(e);
		}
		Collections.sort(list, (e1, e2) -> {
			return e1.getQuantity().compareTo(e2.getQuantity());
		});
		Collections.reverse(list);
		return list;
	}

	@Override
	public List<ProductSale> getTotalProductSold() {
		List<ProductSale> temp = new ArrayList<>();
		List<Object[]> list = entityManager
				.createQuery("select id, name, soldQuantity from Product order by soldQuantity desc", Object[].class)
				.getResultList();
		for (Object[] objects : list) {
			ProductSale e = new ProductSale();
			e.setId((Long) objects[0]);
			e.setName((String) objects[1]);
			e.setQuantity((Integer) objects[2]);
			temp.add(e);
		}
		return temp;
	}

	@Override
	public Statistics getStatistics() {
		Statistics statistics = new Statistics();
		statistics.setTotalCustomers(customerDAO.getTotalCustomer());
		statistics.setTotalStaffs(staffDAO.getTotalStaff());
		statistics.setTotalOrders(orderDAO.getTotalOrders());
		statistics.setRevenue(orderDAO.getRevenue());
		statistics.setTotalLead(leadDAO.getTotalLead() + conversionDAO.totalConvertLead());
		statistics.setTotalOpp(leadDAO.getTotalOpportunity()+conversionDAO.totalConvertOpp());
		statistics.setBack(Double.valueOf(customerDAO.moreThanTwoOrders())/customerDAO.getTotalCustomer()*100);
		return statistics;
	}

	@Override
	public List<StaffSale> getCustomerSpending() {
		List<StaffSale> customer = new ArrayList<StaffSale>();
		List<Object[]> list = entityManager.createQuery("select id, name from Customer", Object[].class).getResultList();		
		for (Object[] objects : list) {
			StaffSale e = new StaffSale();
			e.setId((Long)objects[0]);
			e.setName((String)objects[1]);
			e.setValues(orderDAO.getCustomerSpending(e.getId()));
			if (e.getValues() == null)
				e.setValues(0.0);
			customer.add(e);
		}
		Collections.sort(customer, (s1, s2) -> {
			return s1.getValues().compareTo(s2.getValues());
		});
		Collections.reverse(customer);
		return customer;
	}

}
