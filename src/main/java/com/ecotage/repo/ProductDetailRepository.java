package com.ecotage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
	
	Optional<ProductDetail> findByProductId(Long productId);

}
