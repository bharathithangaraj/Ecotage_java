package com.ecotage.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.CancelOrders;
import com.ecotage.vo.ShowCartDetails;
import com.ecotage.vo.ShowOrderDetails;

@Service
public interface PaymentService {
	
	public ShowCartDetails addToCarts(AddCartDetails cartDetails) throws ProductServiceException;
	
	public ResponseMessage deleteCarts(Long cartId) throws ProductServiceException;
	
	public ResponseMessage updateCarts(AddCartDetails cartDetail) throws ProductServiceException;
	
	public List<ShowCartDetails> getCarts(Long userId) throws ProductServiceException;
	
	public ResponseMessage addOrders(LinkedList<AddOrders> orderList) throws ProductServiceException;
	
	public List<ShowOrderDetails> getOrders(Long userId) throws ProductServiceException;
	
	public ResponseMessage deleteOrders(Long orderId) throws ProductServiceException;
	
	public List<CancelOrders> getCancelOrder(Long userId) throws ProductServiceException;

}
