package com.ecotage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
	
	public List<CartDetail> findByUserId(Long userId); 

}
