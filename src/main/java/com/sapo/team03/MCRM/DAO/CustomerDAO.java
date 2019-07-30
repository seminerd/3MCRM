package com.sapo.team03.MCRM.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
	@Transactional
	@Modifying
	@Query(value = "insert into khachhang values (?1, ?2, ?3, ?4,?5, ?6, ?7, ?8, ?9, ?9, ?10, ?11)", nativeQuery = true)
	public void insertCustomer(String ten, String dia_chi, LocalDate ngay_sinh, String email, String dien_thoai, 
			Integer uu_tien, Integer gioi_tinh, Double cong_no, String ghi_chu, Long idnv_kh, Long idnhom_kh);
	@Query(value="select * from khachhang where email = ?", nativeQuery = true)
	public Customer findByEmail(String email);
	@Query(value = "select * from khachhang where dien_thoai = ?", nativeQuery = true)
	public Customer findByPhonenumber(String phoneNumber);
	@Query(value = "select * from khachhang where idnv_kh = ?", nativeQuery = true)
	public List<Customer> getCustomersByStaffId(Long id);
	@Query(value="select * from khachhang", nativeQuery = true)
	public Page<Customer> findAllPage(Pageable pageable);  
}
