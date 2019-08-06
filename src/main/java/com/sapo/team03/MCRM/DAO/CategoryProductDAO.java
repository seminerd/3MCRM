package com.sapo.team03.MCRM.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.Model.CategoryProduct;

@Repository
public interface CategoryProductDAO extends JpaRepository<CategoryProduct, Long>{
	@Query(value = "select * from category_product where name = ?1", nativeQuery = true)
	public CategoryProduct findCatByName(String name);
	@Transactional
	@Modifying
	@Query(value = "insert into category_product(name) value (?1)", nativeQuery = true)
	public void addCatByName(String name);
}
