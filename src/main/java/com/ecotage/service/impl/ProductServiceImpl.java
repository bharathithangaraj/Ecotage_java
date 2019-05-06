package com.ecotage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Category;
import com.ecotage.model.Image;
import com.ecotage.model.Offer;
import com.ecotage.model.Product;
import com.ecotage.model.ProductDetail;
import com.ecotage.repo.CategoryRepository;
import com.ecotage.repo.ImageRepository;
import com.ecotage.repo.OfferRepository;
import com.ecotage.repo.ProductDetailRepository;
import com.ecotage.repo.ProductRepositry;
import com.ecotage.request.dao.CategoryReq;
import com.ecotage.request.dao.ImageReq;
import com.ecotage.request.dao.OfferReq;
import com.ecotage.response.dao.CategoryRes;
import com.ecotage.response.dao.ProductRes;
import com.ecotage.response.dao.ResponseMessage;
import com.ecotage.service.ProductService;
import static com.ecotage.util.CommonUtil.CURRENT_TIME;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepositry productRepo;
	
	@Autowired
	ProductDetailRepository prodDetRepo;
	
	@Autowired
	ImageRepository imageRepo;
	
	@Autowired
	OfferRepository offerRepo;
	

	@Override
	public List<CategoryRes> getAllCategories() throws ProductServiceException{
		
		List<CategoryRes> responseList = null;
		
		List<Category> categoryList= categoryRepo.findAll();
		System.out.println(categoryList);
		
		if(categoryList != null) {
			responseList =new ArrayList<CategoryRes>();
			for(Category cateResult : categoryList) {
				System.out.println("categoryList :::"+categoryList);
				CategoryRes response = new CategoryRes();
				ResponseMessage res = new ResponseMessage();
				
				response.setCategoryId(cateResult.getCategoryId());
				response.setCategoryName(cateResult.getCategoryName());
				response.setCategoryType(cateResult.getCategoryType());
				response.setCateUrl(cateResult.getNavigateTo());
				res.setErrorCode("0000");
				res.setMessage("success");
				response.setResponseMsg(res);
				responseList.add(response);
				
			}
		}
		
		System.out.println("categoryList ::"+categoryList);
		
		return responseList;
	}


	@Override
	public ResponseMessage addCategory(LinkedList<CategoryReq> cateReqList) throws ProductServiceException{
		
		ResponseMessage res = new ResponseMessage();
		

		
		for(CategoryReq cateReq : cateReqList) {
			
			Optional<Category> cateEntity = categoryRepo.findByCategoryType(cateReq.getCategoryType());
			Product product = null;
			
			if(cateEntity.isPresent()) {
				
				System.out.println("category entity already persent");
				 product = new Product(cateReq.getProductName(), cateReq.getTitle(),cateReq.getProdUrl(),cateReq.getPrice(),cateReq.getQuantity(),
						cateReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,cateEntity.get());
				
				
				
				
			}else {
				
				System.out.println("category entity already persent not present");
				
				Category category = new Category(cateReq.getCategoryName(), cateReq.getCategoryType(), cateReq.getCategoryDesc(), cateReq.getCateStaus(), CURRENT_TIME, CURRENT_TIME, cateReq.getCateUrl());
				
				Category categoryEntity = categoryRepo.save(category);
				
				 product = new Product(cateReq.getProductName(), cateReq.getTitle(),cateReq.getProdUrl(),cateReq.getPrice(),cateReq.getQuantity(),
						cateReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,categoryEntity);
				
				/*Product prodEntity = productRepo.save(product);
				
				ProductDetail productDetail = new ProductDetail(cateReq.getDescription(),cateReq.getSpecification(),CURRENT_TIME,CURRENT_TIME,prodEntity);
				
				ProductDetail prodDetailEntity = prodDetRepo.save(productDetail);
				
				for(ImageReq imgReq : cateReq.getImgReqList()) {
					
					Image image = new Image(imgReq.getImageUrl(),imgReq.getImageType(),imgReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME,prodEntity);
					
					Image imageEntity = imageRepo.save(image);
				}
				
				for(OfferReq offReq : cateReq.getOfferList()) {
					
					Offer offer = new Offer(offReq.getPercentage(), offReq.getOfferCode(), offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
					
					Offer offerEntity = offerRepo.save(offer);
				}
				
				if(cateEntity == null) {
					throw new ProductServiceException("Unable to add Categories");
				}*/
				
			}
			
			Product prodEntity = productRepo.save(product);
			
			ProductDetail productDetail = new ProductDetail(cateReq.getDescription(),cateReq.getSpecification(),CURRENT_TIME,CURRENT_TIME,prodEntity);
			
			ProductDetail prodDetailEntity = prodDetRepo.save(productDetail);
			
			for(ImageReq imgReq : cateReq.getImgReqList()) {
				
				Image image = new Image(imgReq.getImageUrl(),imgReq.getImageType(),imgReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME,prodEntity);
				
				Image imageEntity = imageRepo.save(image);
			}
			
			for(OfferReq offReq : cateReq.getOfferList()) {
				
				Offer offer = new Offer(offReq.getPercentage(), offReq.getOfferCode(), offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
				
				Offer offerEntity = offerRepo.save(offer);
			}
			
			if(cateEntity == null) {
				throw new ProductServiceException("Unable to add Categories");
			}
			
			
			
			
		}
		

		res.setMessage("success");
		res.setErrorCode("0000");
		return res;
	}


	@Override
	public List<Product> getAllProducts() {
		
		List<Product> productList = productRepo.findAll();
		
		System.out.println("categoryList ::"+productList);
		
		return productList;
	}


	@Override
	public Product addProduct(Product product) {
	//	product.getProductDetail().setProduct(product);
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


	@Override
	public List<ProductRes> getProductByCategoryName(String name) throws ProductServiceException {
		
		List<ProductRes> responseList = null;
		
		List<Category> categoryList= categoryRepo.findByCategoryName(name);
		System.out.println(categoryList);
		
		if(categoryList != null) {
			responseList =new ArrayList<ProductRes>();
			for(Category cateResult : categoryList) {
				System.out.println("categoryList :::"+categoryList);
				CategoryRes response = new CategoryRes();
				ResponseMessage res = new ResponseMessage();
				
				response.setCategoryId(cateResult.getCategoryId());
				response.setCategoryName(cateResult.getCategoryName());
				response.setCategoryType(cateResult.getCategoryType());
				response.setCateUrl(cateResult.getNavigateTo());
				res.setErrorCode("0000");
				res.setMessage("success");
				response.setResponseMsg(res);
				//responseList.add(response);
				
			}
		}
		
		System.out.println("categoryList ::"+categoryList);
		
		return responseList;
	}


	
	

}
