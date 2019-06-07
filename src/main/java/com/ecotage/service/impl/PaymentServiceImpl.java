package com.ecotage.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.CancelOrderDAO;
import com.ecotage.dao.CartDetailDAO;
import com.ecotage.dao.OrderDetailDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.service.PaymentService;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.CancelOrders;
import com.ecotage.vo.ShowCartDetails;
import com.ecotage.vo.ShowOrderDetails;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	private static Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	CartDetailDAO cartDetailDao;
	
	@Autowired
	OrderDetailDAO orderDetailDao;
	
	@Autowired
	CancelOrderDAO cancelOrderDao;
	

	@Override
	public ShowCartDetails addToCarts(AddCartDetails cartDetail) throws ProductServiceException {
		ShowCartDetails addCart = null;

		try {
			addCart = cartDetailDao.addToCarts(cartDetail);

			log.info(cartDetail.toString());

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return addCart;
	}

	@Override
	public ResponseMessage deleteCarts(Long cartId) throws ProductServiceException {
		ResponseMessage res = null;

		try {
			res = cartDetailDao.deleteCarts(cartId);

			//log.info(cartId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return res;
		
	}
	
	@Override
	public ResponseMessage updateCarts(AddCartDetails cartDetail) throws ProductServiceException {
		ResponseMessage res = null;

		try {
			res = cartDetailDao.updateCarts(cartDetail);

			//log.info(cartId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return res;
	}

	@Override
	public List<ShowCartDetails> getCarts(Long userId) throws ProductServiceException {
		
		List<ShowCartDetails> cartDetails = null;

		try {
			cartDetails = cartDetailDao.getCarts(userId);

			

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return cartDetails;
		
	}

	@Override
	public List<ShowOrderDetails> addOrders(LinkedList<AddOrders> orderList) throws ProductServiceException {
		
		List<ShowOrderDetails> showOrders = null;

		try {
			showOrders = orderDetailDao.addOrders(orderList);

			//log.info(orderList);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return showOrders;
		
	}

	@Override
	public List<ShowOrderDetails> getOrders(Long userId) throws ProductServiceException {
		List<ShowOrderDetails> orderDetails = null;

		try {
			orderDetails = orderDetailDao.getOrders(userId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return orderDetails;
	}

	@Override
	public ResponseMessage deleteOrders(Long orderId) throws ProductServiceException {
		ResponseMessage res = null;

		try {
			res = orderDetailDao.deleteOrders(orderId);

			//log.info(orderId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return res;
	}

	@Override
	public List<CancelOrders> getCancelOrder(Long userId) throws ProductServiceException {
		List<CancelOrders> orderDetails = null;

		try {
			orderDetails = cancelOrderDao.getCancelOrder(userId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return orderDetails;
	}

	

}
