package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Marketing.Model.LeadSource;

@Repository
public interface LeadSourceDAO extends JpaRepository<LeadSource, Long> {
//	@Query(value = "select * from lead_source where name = ?1", nativeQuery = true)
	LeadSource findByName(String name);



}
