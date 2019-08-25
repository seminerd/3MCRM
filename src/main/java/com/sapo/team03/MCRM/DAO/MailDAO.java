package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Marketing.Model.Email;
@Repository
public interface MailDAO extends JpaRepository<Email, Long> {
	@Query(value = "select * from mail  where to_mail = ?1", nativeQuery = true)
	public List<Email> getMailHis(String toMail);
}
