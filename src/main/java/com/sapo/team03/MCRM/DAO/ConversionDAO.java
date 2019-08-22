package com.sapo.team03.MCRM.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Service.StatisticModel.Conversion;
@Repository
public interface ConversionDAO extends JpaRepository<Conversion, Long>{
	@Query(value = "select lead_opp/total_lead*100 from conversion_rate where month(curdate()) - 1 = month(month_year)", nativeQuery = true)
	public Double getLeadToOppRate();
	@Query(value = "select * from conversion_rate where month(?1) = month(month_year) "
			+ "and year(?1) = year(month_year)", nativeQuery = true)
	public Conversion findRecordByMonth(LocalDate date);
	@Query(value = "select sum(opp_cus) + sum(lead_cus) from conversion_rate", nativeQuery = true)
	public int totalConvertLead();
	@Query(value = "select sum(opp_cus) from conversion_rate", nativeQuery = true)
	public int totalConvertOpp();
}
