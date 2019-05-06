package com.ecotage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.Offer;


public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	public Optional<Offer> findByOfferCode(String offerCode); 

}
