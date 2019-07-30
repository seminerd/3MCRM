package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.CategoryHangHoa;
@Repository
public interface CategoryHanghoaDAO  extends JpaRepository<CategoryHangHoa, Long>{
	@Transactional
	@Query(value = "select * from categoryhanghoa where ten = ?", nativeQuery =  true)
	public CategoryHangHoa findCatByName(String name);
	@Transactional
	@Modifying
	@Query(value = "insert into categoryhanghoa(ten) values (:ten)", nativeQuery = true)
	public void addCatByName( @Param("ten") String name);
}
