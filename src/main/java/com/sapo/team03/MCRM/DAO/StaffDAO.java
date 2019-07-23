package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.Staff;

@Repository
public interface StaffDAO extends JpaRepository<Staff, Long> {
	@Transactional
	@Query(value = "select * from nhanvien where email = ?", nativeQuery = true)
	public Staff findByEmail(String email);
}
