package com.ecotage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.exception.PaymentServiceException;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;
import com.ecotage.repo.PaymentRepository;
import com.ecotage.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;

	@Override
	public CartDetail addToCart(CartDetail cartDetail) throws PaymentServiceException{
		
		CartDetail cart_det = paymentRepo.save(cartDetail);
		if(cart_det == null) {
			throw new PaymentServiceException("Unable to add Cart detail");
		}
		
		return cart_det;
		
		
	}
	
}
