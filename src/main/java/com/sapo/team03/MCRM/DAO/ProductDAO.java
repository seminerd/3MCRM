package com.sapo.team03.MCRM.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapo.team03.MCRM.Sale.Model.CategoryProduct;
import com.sapo.team03.MCRM.Sale.Model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	@Query(value = "select id_category_good from product ", nativeQuery = true)
	List<CategoryProduct> getAllCategory();
}
