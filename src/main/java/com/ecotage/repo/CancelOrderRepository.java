package com.ecotage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.CancelOrder;

public interface CancelOrderRepository extends JpaRepository<CancelOrder, Long> {
	
	public List<CancelOrder> findByUserId(Long userId);

}
