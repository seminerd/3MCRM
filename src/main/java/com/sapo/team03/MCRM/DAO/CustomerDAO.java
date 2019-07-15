package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
