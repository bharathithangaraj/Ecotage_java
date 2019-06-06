package com.ecotage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	
	List<Image> findByProductId(Long productId);
}
