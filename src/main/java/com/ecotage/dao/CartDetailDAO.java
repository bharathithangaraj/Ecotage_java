package com.ecotage.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.ShowCartDetails;

@Service
public interface CartDetailDAO {
	
	public ShowCartDetails addToCarts(AddCartDetails cartDetail) throws ProductServiceException;

	public ResponseMessage deleteCarts(Long cartId) throws ProductServiceException;
	
	public ResponseMessage updateCarts(AddCartDetails cartDetail) throws ProductServiceException;
	
	public List<ShowCartDetails> getCarts(Long userId) throws ProductServiceException;
	


}
