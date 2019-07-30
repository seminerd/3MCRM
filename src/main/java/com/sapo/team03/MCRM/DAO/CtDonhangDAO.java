package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Model.CTDonHang;

@Repository
public interface CtDonhangDAO extends JpaRepository<CTDonHang, Long> {
	@Query(value="select * from ctdonhang where id_donhang = ?", nativeQuery = true)
	public List<CTDonHang> findAllByOrderId(Long id);
}
