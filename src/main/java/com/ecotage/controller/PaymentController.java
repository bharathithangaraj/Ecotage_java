package com.ecotage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecotage.exception.PaymentServiceException;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.model.CartDetail;
import com.ecotage.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value="/cart/add", method = RequestMethod.POST)
	public CartDetail addToCart(@RequestBody CartDetail cartDetail)  throws ResourceNotFoundException, PaymentServiceException{

		CartDetail cart_det = null;
		try {
			cart_det = paymentService.addToCart(cartDetail);

			if(cart_det == null ) {
				throw new ResourceNotFoundException("Unable to add Cart Details");
			}
		} catch(PaymentServiceException px) {
			throw new PaymentServiceException("Internal Server Exception while add Cart");
		}
		return  cart_det;
	}

}
