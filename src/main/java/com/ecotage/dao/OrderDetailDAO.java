package com.ecotage.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.ShowOrderDetails;

@Service
public interface OrderDetailDAO {
	
	public ResponseMessage addOrders(LinkedList<AddOrders> orderList) throws ProductServiceException;
	
	public List<ShowOrderDetails> getOrders(Long userId) throws ProductServiceException;
	
	public ResponseMessage deleteOrders(Long orderId) throws ProductServiceException;

}
