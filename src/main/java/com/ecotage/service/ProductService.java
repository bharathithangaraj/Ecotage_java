package com.ecotage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Category;
import com.ecotage.model.Product;
import com.ecotage.request.dao.CategoryReq;
import com.ecotage.response.dao.CategoryRes;

@Service
public interface ProductService {
	
	public List<Category> getAllCategories();
	
	public CategoryRes addCategory(CategoryReq category) throws ProductServiceException;
	
	public List<Product> getAllProducts();
	
	public Product addProduct(Product product);
	
	public Optional<Product> getProduct(Long id) throws ProductServiceException;
	
	
	public List<Product> getProductByCategories(Long id);
	
	
	

}
