package com.ecotage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Category;
import com.ecotage.model.Product;
import com.ecotage.repo.CategoryRepository;
import com.ecotage.repo.ProductRepositry;
import com.ecotage.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepositry productRepo;
	

	@Override
	public List<Category> getAllCategories() {
		
		List<Category> categoryList= categoryRepo.findAll();
		
		System.out.println("categoryList ::"+categoryList);
		
		return categoryList;
	}


	@Override
	public Category addCategory(Category category) throws ProductServiceException{
		
		Category cateEntity = categoryRepo.save(category);
		
		if(cateEntity == null) {
			throw new ProductServiceException("Unable to add Categories");
		}
		return cateEntity;
	}


	@Override
	public List<Product> getAllProducts() {
		
		List<Product> productList = productRepo.findAll();
		
		System.out.println("categoryList ::"+productList);
		
		return productList;
	}


	@Override
	public Product addProduct(Product product) {
		product.getProductDetail().setProduct(product);
		Product prodEntity = productRepo.save(product);
		return prodEntity;	
		}


	@Override
	public Optional<Product> getProduct(Long id) throws ProductServiceException{
		
		
		Optional<Product> product = productRepo.findById(id);
		
		if(product == null) {
			throw new ProductServiceException("product should be valid one");
		}
		
		return product;
		
	}


	@Override
	public List<Product> getProductByCategories(Long id) {
		
		List<Product> productList = productRepo.findProductByCategory(id);
		
		return productList;
	}


	
	
	
	
	
	
	

}
