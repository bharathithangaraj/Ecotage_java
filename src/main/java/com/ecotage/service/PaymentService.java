package com.ecotage.service;

import org.springframework.stereotype.Service;

import com.ecotage.exception.PaymentServiceException;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;

@Service
public interface PaymentService {

	public CartDetail addToCart(CartDetail cartDetail) throws PaymentServiceException;
}
