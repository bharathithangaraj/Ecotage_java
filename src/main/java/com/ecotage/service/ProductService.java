package com.ecotage.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Category;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCategory;
import com.ecotage.vo.Products;

@Service
public interface ProductService {

	public List<Category> getAllCategories() throws ProductServiceException;

	public ResponseMessage addCategory(LinkedList<AddCategory> categoryList) throws ProductServiceException;

	public List<Products> getProductsByCategory(Long categoryId) throws ProductServiceException;

	public Products getProduct(Long productId) throws ProductServiceException;

	/*
	 * public ResponseMessage addCategory(LinkedList<CategoryReq> categories) throws
	 * ProductServiceException;
	 * 
	 * public List<ProductDAO> getAllProducts();
	 * 
	 * public ResponseMessage addProduct(LinkedList<ProductReq> products) throws
	 * ProductServiceException;
	 * 
	 * public Optional<ProductDAO> getProduct(Long id) throws
	 * ProductServiceException;
	 * 
	 * public List<CategoryDAO> getProductByCategoryName(String categoryName) throws
	 * ProductServiceException;
	 * 
	 * 
	 * public Optional<CategoryDAO> getProductByCategories(Long categoryId) throws
	 * ProductServiceException;
	 * 
	 * public CartDetailDAO addToCart(String productId, String userId, int qunatity)
	 * throws ProductServiceException;
	 * 
	 * public List<CartDetailDAO> showCartItems(String productId, String
	 * cartDetailId) throws ProductServiceException;
	 */

}
