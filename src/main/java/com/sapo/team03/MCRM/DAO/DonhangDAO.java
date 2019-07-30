package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Model.DonHang;

@Repository
public interface DonhangDAO extends JpaRepository<DonHang, Long>{

}
