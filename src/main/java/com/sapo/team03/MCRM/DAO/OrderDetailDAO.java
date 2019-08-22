package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Sale.Model.OrderDetail;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
	@Query(value="select * from detail_order where id_order = ?", nativeQuery = true)
	public List<OrderDetail> findAllByOrderId(Long id);
}
