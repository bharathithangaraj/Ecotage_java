package com.ecotage.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Category;
import com.ecotage.model.Product;
import com.ecotage.request.dao.CategoryReq;
import com.ecotage.request.dao.ProductReq;
import com.ecotage.response.dao.CategoryRes;
import com.ecotage.response.dao.ProductRes;
import com.ecotage.response.dao.ResponseMessage;

@Service
public interface ProductService {
	
	public List<CategoryRes> getAllCategories() throws ProductServiceException;
	
	public ResponseMessage addCategory(LinkedList<CategoryReq> cateReqList) throws ProductServiceException;
	
	public List<Product> getAllProducts();
	
	public ResponseMessage addProduct(LinkedList<ProductReq> prodReqList) throws ProductServiceException;
	
	public ProductRes getProduct(Long id) throws ProductServiceException;
	
	public List<CategoryRes> getProductByCategoryName(String name) throws ProductServiceException;
	
	
	public List<CategoryRes> getProductByCategories(Long id)  throws ProductServiceException;
	
	
	

}
