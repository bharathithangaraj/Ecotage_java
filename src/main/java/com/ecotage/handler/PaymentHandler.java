package com.ecotage.handler;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.service.PaymentService;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.CancelOrders;
import com.ecotage.vo.ShowCartDetails;
import com.ecotage.vo.ShowOrderDetails;

@Component
public class PaymentHandler {

	@Autowired
	PaymentService paymentService;

	@Autowired
	private Mapper mapper;

	public ShowCartDetails addToCarts(@RequestBody AddCartDetails cartDetails)
			throws ResourceNotFoundException, ProductServiceException {

		ShowCartDetails addCart = null;
		try {
			addCart = paymentService.addToCarts(cartDetails);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return addCart;
	}

	public ResponseMessage deleteCarts(@PathVariable("cartId") Long cartId)
			throws ResourceNotFoundException, ProductServiceException {
		ResponseMessage res = null;
		try {
			res = paymentService.deleteCarts(cartId);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;
	}
	
	public ResponseMessage updateCarts(@RequestBody AddCartDetails cartDetail)
			throws ResourceNotFoundException, ProductServiceException {
		ResponseMessage res = null;
		try {
			res = paymentService.updateCarts(cartDetail);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;
	}

	public List<ShowCartDetails> getCarts(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		List<ShowCartDetails> showCarts;
		try {
			showCarts = paymentService.getCarts(userId);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return showCarts;
	}

	public List<ShowOrderDetails> addOrders(@RequestBody LinkedList<AddOrders> orderList)
			throws ResourceNotFoundException, ProductServiceException {

		List<ShowOrderDetails> showOrders = null;
		try {
			showOrders = paymentService.addOrders(orderList);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return showOrders;

	}

	public List<ShowOrderDetails> getOrders(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		List<ShowOrderDetails> showOrders;
		try {
			showOrders = paymentService.getOrders(userId);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return showOrders;
	}

	public ResponseMessage deleteOrders(@PathVariable("orderId") Long orderId)
			throws ResourceNotFoundException, ProductServiceException {
		
		ResponseMessage res = null;
		try {
			res = paymentService.deleteOrders(orderId);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;

	}
	
	public List<CancelOrders> getCancelOrder(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		List<CancelOrders> showOrders;
		try {
			showOrders = paymentService.getCancelOrder(userId);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return showOrders;
	}
}
