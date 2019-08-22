package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Marketing.Model.Marketing;
@Repository
public interface MarketingDAO extends JpaRepository<Marketing, Long>{

}
