package com.sapo.team03.MCRM.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO KHACHHANG(TEN,EMAIL,DIEN_THOAI,NHOMKH,GIOI_TINH,NGAY_SINH,CONG_NO,DIA_CHI) "
			+ "VALUES(:TEN,:EMAIL,:DIEN_THOAI,:NHOMKH,:GIOI_TINH,:NGAY_SINH,:CONG_NO,:DIA_CHI)", nativeQuery = true)
	void addCustomer( @Param("TEN") String ten, @Param("EMAIL") String email,
			@Param("DIEN_THOAI") String dien_thoai, @Param("NHOMKH") String nhomkh,
			@Param("GIOI_TINH") Integer gioi_tinh, @Param("NGAY_SINH") LocalDate ngay_sinh,
			@Param("CONG_NO") Double cong_no, @Param("DIA_CHI") String dia_chi);

}
