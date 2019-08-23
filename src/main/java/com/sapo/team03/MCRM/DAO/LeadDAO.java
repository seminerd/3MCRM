package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Marketing.Model.Lead;
@Repository
public interface LeadDAO extends JpaRepository<Lead, Long> {
	@Transactional
	@Modifying
	@Query(value = "delete from lead where create_date > now() - interval 10 minute and source is null", nativeQuery = true)
	void undo();
	@Query(value = "select * from lead where email = ?1", nativeQuery = true)
	public Lead findByEmail(String email);
	@Transactional
	@Modifying
	@Query(value = "delete from lead where email = ?1", nativeQuery = true)
	public void deleteByEmail(String email);
	@Query(value = "select * from lead where phone = ?1", nativeQuery = true)
	public Lead findByPhone(String phone);
	@Transactional
	@Modifying
	@Query(value = "delete from lead where phone = ?1", nativeQuery = true)
	public void deleteByPhone(String phone);
	@Query(value = "select count(*) from lead", nativeQuery = true)
	public int getTotalLead();
	@Query(value = "select count(*) from lead where opportunity = 1", nativeQuery = true)
	public int getTotalOpportunity();
	@Query(value = "select * from lead where opportunity = 1 ", nativeQuery = true)
	public List<Lead> getOpportunity();
	@Query(value = "select * from lead where opportunity = 0 ", nativeQuery = true)
	public List<Lead> getLead();
}
