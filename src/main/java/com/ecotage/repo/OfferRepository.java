package com.ecotage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.Offer;


public interface OfferRepository extends JpaRepository<Offer, Long> {

}
