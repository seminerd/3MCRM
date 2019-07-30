package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.CategoryHangHoa;
import com.sapo.team03.MCRM.Model.HangHoa;

@Repository
public interface HanghoaDAO extends JpaRepository<HangHoa, Long>{
	@Transactional
	@Query(value = "select id_categoryhh from hanghoa", nativeQuery = true)
	List<CategoryHangHoa> getAllCategory();

}
