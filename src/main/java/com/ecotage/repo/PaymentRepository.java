package com.ecotage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.CartDetail;

@Repository
public interface PaymentRepository extends JpaRepository<CartDetail, Long>{
	
}
