package com.sapo.team03.MCRM.BusinessLogic.BusinessFunction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.DaySale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.ProductSale;
import com.sapo.team03.MCRM.BusinessLogic.BusinessModel.StaffSale;
import com.sapo.team03.MCRM.DAO.OrderDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;

public class RevenueCalculator implements Calculator {
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	StaffDAO staffDAO;
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
			daySale.add(e);
		}
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
			daySale.add(e);
		}
		return daySale;
	}

	@Override
	public List<DaySale> getYearSale() {
		LocalDate today = LocalDate.now();
		List<DaySale> daySale = new ArrayList<DaySale>();
		for (int i = 1; i <= 12; i++) {
			DaySale e = new DaySale();
			today = today.minusMonths(1);
			e.setDate(today);
			e.setValues(orderDAO.getSaleByMonth(today));
			daySale.add(e);
		}
		return daySale;
	}

	@Override
	public List<StaffSale> getStaffSale() {
		List<StaffSale> list = new ArrayList<>();
		List<Long> ID = staffDAO.getStaffId();
		for (Long id : ID) {
			StaffSale e = new StaffSale();
			e.setId(id);
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
		List<Object[]> temp = entityManager.createQuery("select id, ten from HangHoa", Object[].class).getResultList();
		List<ProductSale> list = new ArrayList<>();
		for (Object[] row : temp) {
			ProductSale e = new ProductSale();
			e.setId((Long) row[0]);
			e.setName((String) row[1]);
			e.setQuantity(orderDAO.getProdNum(e.getId()));
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
				.createQuery("select id, ten, soluong_daban from HangHoa order by soluong_daban desc", Object[].class)
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

}
