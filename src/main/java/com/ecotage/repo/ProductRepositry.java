package com.ecotage.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecotage.model.Product;

public interface ProductRepositry extends JpaRepository<Product, Long> {
	
	
//	List<Product> findByCategoryList(Long id);
//	
	@Query(value="select * from product where cat_id = ?", nativeQuery=true)
	List<Product> findProductByCategory(Long categoryId);
	
	Optional<Product> findByProductName(String name);

	//Optional<Product> findByCategoryList(Long id);

}
