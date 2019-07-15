package com.sapo.team03.MCRM.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Model.Staff;

@Repository
public interface StaffDAO extends CrudRepository<Staff, Long>{
	
}
