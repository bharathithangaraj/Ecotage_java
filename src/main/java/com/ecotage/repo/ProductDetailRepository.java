package com.ecotage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

}
