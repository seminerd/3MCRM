package com.sapo.team03.MCRM.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Marketing.Model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>,MailReceiverDAO {
//	@Query(value="select * from customer where email = ?", nativeQuery = true)
	public Customer findByEmail(String email);
//	@Query(value = "select * from customer where phone = ?", nativeQuery = true)
	public Customer findByPhone(String phoneNumber);
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
	@Query(value = "select count(*) from customer where id in (\n" + 
			"	select id_customer_order from orders group by(id_customer_order) having count(id) > 1\n" + 
			")", nativeQuery = true)
	public int moreThanTwoOrders();
	@Transactional
	@Modifying
	@Query(value = "update lead_source set cnvrt = cnvrt + 1 where id = ?1", nativeQuery = true)
	public void updateLeadSource(Long id);
	@Query(value = "select c.* from customer c, cus_group cg "
			+ "where c.id = cg.id_cus "
			+ "and c.staff_id = ?1 and cg.id_group = ?2", nativeQuery = true)
	public List<Customer> getCustomerByGroup(Long staff_id, Long group_id);

}
