package com.ecotage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
	
	List<Offer> findByProductId(Long productId);

}
