package com.ecotage.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.vo.CancelOrders;

@Service
public interface CancelOrderDAO {
	
	public List<CancelOrders> getCancelOrder(Long userId) throws ProductServiceException;

}
