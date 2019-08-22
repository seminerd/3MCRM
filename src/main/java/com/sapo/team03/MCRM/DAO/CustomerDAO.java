package com.sapo.team03.MCRM.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Marketing.Model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>,MailReceiverDAO {
	@Transactional
	@Query(value="select * from customer where email = ?", nativeQuery = true)
	public Customer findByEmail(String email);
	@Query(value = "select * from customer where phone = ?", nativeQuery = true)
	public Customer findByPhonenumber(String phoneNumber);
	@Query(value = "select * from customer where staff_id = ?", nativeQuery = true)
	public List<Customer> getCustomersByStaffId(Long id);
	@Query(value="select * from customer", nativeQuery = true)
	public Page<Customer> findAllPage(Pageable pageable);  
	@Query(value = "select count(*) from customer", nativeQuery = true)
	Integer getTotalCustomer();
	@Query(value = "select timestampdiff(year, dob, curdate()) from customer where id = ?1", nativeQuery = true)
	public Integer getAgeById(Long id);
	@Query(value = "select timestampdiff(year, ?1 , curdate()) ", nativeQuery = true)
	public Integer getAgeByDate(Date date);
}
