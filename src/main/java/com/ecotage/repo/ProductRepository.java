package com.ecotage.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ecotage.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//@Query(value="SELECT * from product a INNER JOIN image b ON a.product_id = b.product_id where category_id = 5", nativeQuery=true)
	List<Product> findByCategoryId(Long CategoryId);
	
	Optional<Product> findByProductId(Long productId);
	
	@Query(value="select productId,productName from Product where Status = 1")
	List<Object[]> getProductsName();

}
