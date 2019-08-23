package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sapo.team03.MCRM.Management.Model.Staff;

@Repository
public interface StaffDAO extends JpaRepository<Staff, Long> {
	public Staff findByEmail(String email);
	@Query(value = " select id from staff", nativeQuery = true)
	List<Long> getStaffId();
	@Query(value = "select name from staff where id = ?1", nativeQuery = true)
	String getStaffNameById(Long id);
	@Query(value = "select count(*) from staff", nativeQuery = true)
	Integer getTotalStaff();
}
