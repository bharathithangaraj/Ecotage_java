package com.ecotage.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.handler.PaymentHandler;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.CancelOrders;
import com.ecotage.vo.ShowCartDetails;
import com.ecotage.vo.ShowOrderDetails;

@RestController
@CrossOrigin("*")
public class PaymentController {

	//CartServices
	@Autowired
	PaymentHandler paymentHandler;

	@PostMapping(value = "/cart/product/add/")
	public ShowCartDetails addToCarts(@RequestBody AddCartDetails cartDetails)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.addToCarts(cartDetails);
	}

	@DeleteMapping(value = "/cart/product/remove/{cartId}")
	public ResponseMessage deleteCarts(@PathVariable("cartId") Long cartId)
			throws ResourceNotFoundException, ProductServiceException {
		
		return paymentHandler.deleteCarts(cartId);

	}
	
	@PutMapping(value = "/cart/product/update/")
	public ResponseMessage updateCarts(@RequestBody AddCartDetails cartDetail)
			throws ResourceNotFoundException, ProductServiceException {
		
		return paymentHandler.updateCarts(cartDetail);

	}
	
	@GetMapping(value = "/cart/products/{userId}")
	public List<ShowCartDetails> getCarts(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.getCarts(userId);
	}
	
	
	//Order Services
	@PostMapping(value = "/order/new/")
	public ResponseMessage addOrders(@RequestBody LinkedList<AddOrders> orderList)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.addOrders(orderList);
	}
	
	@GetMapping(value = "/order/products/{userId}")
	public List<ShowOrderDetails> getOrders(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.getOrders(userId);
	}
	
	@DeleteMapping(value = "/order/remove/{orderId}")
	public ResponseMessage deleteOrders(@PathVariable("orderId") Long orderId)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.deleteOrders(orderId);
	}
	
	@PutMapping(value = "/order/cancel")
	public List<CancelOrders> getCancelOrder(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException, ProductServiceException {

		return paymentHandler.getCancelOrder(userId);
	}
	
	

}
