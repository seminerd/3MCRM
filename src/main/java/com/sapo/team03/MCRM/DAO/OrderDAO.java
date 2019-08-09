package com.sapo.team03.MCRM.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Model.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Long> {
	@Query(value = "select sum(total_money) from orders where (date_ship = ?1 and state = 1 ) ", nativeQuery = true)
	public Double getSaleByDay(LocalDate date);
	
	@Query(value = "select sum(total_money) from orders \n" + 
				   "where ( month(?1) = month(date_ship) and year(?1) = year(date_ship) "
				   +"and state = 1) ", nativeQuery = true)
	public Double getSaleByMonth(LocalDate date);
	
	@Query(value = "select sum(total_money) from orders where (id_staff_order = ?1 and state = 1)", nativeQuery = true)
	public Double getStaffSale(Long id);
	
	@Query(value = "select sum(total_money) from orders "
			+ "where id_staff_order = ?1 and month(date_ship) = month(date_sub(curdate(), interval 1 month)) "
			+ "and state = 1", nativeQuery = true)
	public Double getStaffMonthlySale(Long id);
	
	@Query(value = "select sum(quantity) from detail_order where \n" + 
				   "id_product = ?1 and\n" + 
				   "id_order in (select id from orders where datediff(curdate(), date_ship) <30 "
				   		+ "and datediff(curdate(), date_ship) >= 0 and state = 1)", nativeQuery = true)
	public Integer getProdNum(Long id);	
	
	@Query(value = "select count(*) from orders", nativeQuery = true)
	Integer getTotalOrders();
	
	@Query(value = "select sum(total_money) from orders where state = 1", nativeQuery = true)
	Double getRevenue();
}
