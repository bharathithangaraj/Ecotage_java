package com.ecotage.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.CancelOrderDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CancelOrder;
import com.ecotage.model.Product;
import com.ecotage.repo.CancelOrderRepository;
import com.ecotage.repo.OrderDetailRepository;
import com.ecotage.repo.ProductRepository;
import com.ecotage.vo.CancelOrders;
import com.ecotage.vo.Products;

@Component
public class CancelOrderDAOImpl implements CancelOrderDAO {
	
	@Autowired
	CancelOrderRepository cancelRepo;
	
	@Autowired
	ProductRepository productRepo;


	@Override
	public List<CancelOrders> getCancelOrder(Long userId) throws ProductServiceException {
		
		List<CancelOrders> cancelDetails = null;

		try {
			List<CancelOrder> cancelEntity = cancelRepo.findByUserId(userId);

			cancelDetails = new ArrayList<>();
			for (CancelOrder cancelItem : cancelEntity) {

				CancelOrders cancelOrders = new CancelOrders();
				cancelOrders.setCancelDate(cancelItem.getCancelDate());
				cancelOrders.setCancelOrderId(cancelItem.getCancelOrderId());
				cancelOrders.setCancelReason(cancelItem.getCancelReason());
				cancelOrders.setOrderId(cancelItem.getOrderId());
				cancelOrders.setUserId(cancelItem.getUserId());
				
				Optional<Product> productEntity = productRepo.findByProductId(cancelItem.getProductId());

				if (productEntity.isPresent()) {
					
					Products product = new Products();
					product.setProductId(productEntity.get().getProductId());
					product.setPrice(productEntity.get().getPrice());
					product.setNavigageTo(productEntity.get().getNavigageTo());
					product.setProductName(productEntity.get().getProductName());
					product.setTitle(productEntity.get().getTitle());
					product.setImageUrl(productEntity.get().getImageUrl());
					
					cancelOrders.setProduct(product);
				}

				cancelDetails.add(cancelOrders);

			}

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return cancelDetails;
	}

}
