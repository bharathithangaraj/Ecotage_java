package com.ecotage.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddProduct;
import com.ecotage.vo.Products;

@Service
public interface ProductDAO {

	public List<Products> getProductsByCategory(Long categoryId) throws ProductServiceException;

	public ResponseMessage addProduct(LinkedList<AddProduct> productList) throws ProductServiceException;
	
	public Products getProduct(Long ProductId) throws ProductServiceException;
	
	public List<Products> getProductsName() throws ProductServiceException;
}
