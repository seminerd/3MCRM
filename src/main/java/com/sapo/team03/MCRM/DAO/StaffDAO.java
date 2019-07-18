package com.sapo.team03.MCRM.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.Staff;

@Repository
public interface StaffDAO extends JpaRepository<Staff, Long> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO NHANVIEN(TEN,EMAIL,NGAY_SINH,DIEN_THOAI,PASSWORD,CHUC_VU,GIOI_TINH,MO_TA) VALUES(:TEN,:EMAIL,:NGAY_SINH,:DIEN_THOAI,:PASSWORD,:CHUC_VU,:GIOI_TINH,:MO_TA)", nativeQuery = true)
	void addStaff(@Param("TEN") String name, @Param("EMAIL") String email, @Param("NGAY_SINH") LocalDate dob,
			@Param("DIEN_THOAI") String phone, @Param("CHUC_VU") String chucvu, @Param("PASSWORD") String password,
			@Param("GIOI_TINH") Integer gender, @Param("MO_TA") String description);

	@Query(value = "SELECT * FROM NHANVIEN WHERE ID = :ID", nativeQuery = true)
	Staff findStaffById(@Param("ID") Long id);
}
