package com.ecotage.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.handler.ProductHandler;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCategory;
import com.ecotage.vo.MenuCategory;
import com.ecotage.vo.Products;

@RestController("/product")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductHandler productHandler;
	
	@GetMapping(value = "/categories")
	public List<MenuCategory> getAllcategories() throws ResourceNotFoundException, ProductServiceException {
		return productHandler.categories();
	}
	
	@PostMapping(value = "/categories")
	public ResponseMessage addCategories(@RequestBody LinkedList<AddCategory> categoryList)
			throws ResourceNotFoundException, ProductServiceException {

		return productHandler.addCategories(categoryList);
	}
	
	@GetMapping(value = "/category/products/{categoryId}")
	public List<Products> getProductsByCategory(@PathVariable("categoryId") Long categoryId)
			throws ResourceNotFoundException, ProductServiceException {
		return productHandler.getProductsByCategory(categoryId);

	}
	
	@GetMapping(value = "/products/{productId}")
	public Products getProduct(@PathVariable("productId") Long productId)
			throws ResourceNotFoundException, ProductServiceException {
		return productHandler.getProduct(productId);

	}
	
	@GetMapping(value="/products/names")
	public List<Products> getAllProductNames() throws ResourceNotFoundException, ProductServiceException{
		
		return productHandler.getAllProductNames();
	}
	
}
