package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.NhomKhachhang;
@Repository
public interface NhomKhachhangDAO extends JpaRepository<NhomKhachhang, Long> {
	
}
