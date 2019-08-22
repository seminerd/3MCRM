package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Marketing.Model.CustomerGroup;

@Repository
public interface CustomerGroupDAO extends JpaRepository<CustomerGroup, Long> {
	@Query(value = "select * from customer_group where id_group != 1 and id_group != 2", nativeQuery = true)
	public List<CustomerGroup> getCustomerGroup();
	@Query(value = "select * from customer_group where (?1 between start_point and end_point) and id_group = 1", nativeQuery = true)
	public CustomerGroup getGroupByAge(int age);
	@Query(value = "select * from customer_group where (?1 between start_point and end_point) and id_group = 2", nativeQuery = true)
	public CustomerGroup getGroupByPoint(int point);
	@Transactional
	@Modifying
	@Query(value = "update cus_group set id_group = ?1 where id_cus = ?2 and id_group = ?3", nativeQuery = true)
	public void updateCustomerGroup(Long idNewGroup, Long idCustomer, Long idGroup);
	@Transactional
	@Modifying
	@Query(value = "delete from cus_group where id_cus = ?1 and id_group = ?2", nativeQuery = true)
	public void deleteOldLink(Long idCustomer, Long group);
	@Transactional
	@Modifying
	@Query(value = "delete from cus_group where id_cus = ?1", nativeQuery = true)
	public void deleteOldCustomer(Long idCustomer);
	@Modifying
	@Query(value = "insert into cus_group values (?1, ?2)", nativeQuery = true)
	public void addNewCustomerGrp(Long idCustomer, Long idGroup);
}
