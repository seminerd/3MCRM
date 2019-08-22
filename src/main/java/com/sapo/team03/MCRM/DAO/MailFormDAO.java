package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Marketing.Model.MailForm;
@Repository
public interface MailFormDAO extends JpaRepository<MailForm,Long> {

}
