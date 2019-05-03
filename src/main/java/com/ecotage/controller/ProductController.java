package com.ecotage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Category;
import com.ecotage.model.Product;
import com.ecotage.repo.CategoryRepository;
import com.ecotage.request.dao.CategoryReq;
import com.ecotage.response.dao.CategoryRes;
import com.ecotage.service.ProductService;

@RestController
public class ProductController {


	@Autowired
	ProductService productService;

	@RequestMapping(value="/showAllCategory", method = RequestMethod.GET)
	public List<Category> categories(){	
		
		return productService.getAllCategories(); 
	}

	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	public CategoryRes addCategories(@RequestBody CategoryReq cateReq)  throws ResourceNotFoundException, ProductServiceException{

		CategoryRes cate = null;
		try {
			cate = productService.addCategory(cateReq);

			if(cate == null ) {
				throw new ResourceNotFoundException("Unable to add Catgory");
			}
		} catch(ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return  cate;
	}

	@RequestMapping(value="/showAllProducts", method = RequestMethod.GET)
	public List<Product> getAllProducts(){
		return productService.getAllProducts(); 

	}

	@RequestMapping(value="/addProducts", method = RequestMethod.POST)
	public Product addProducts(@RequestBody Product product){

		return productService.addProduct(product);

	}

	@RequestMapping(value="/showProduct/{productId}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable("productId") Long id) throws ResourceNotFoundException, ProductServiceException
	{
		Optional<Product> prod = null;
		try {
			
			prod = productService.getProduct(id);
			if(prod == null || !prod.isPresent()) {
				throw new ResourceNotFoundException("Product Not Found");
			}

		} catch (ProductServiceException px){
			throw new ProductServiceException("Internal Server Exception while getting product");
		}

		return prod;

	}
	
	@RequestMapping(value="/showCategory/{categoryId}", method = RequestMethod.GET)
	public List<Product> getProductByCategory(@PathVariable("categoryId") Long categoryId){
		
		
		return productService.getProductByCategories(categoryId); 
		

	}
	
	
	















}
