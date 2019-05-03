package com.ecotage.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import com.ecotage.response.dao.CategoryRes;
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
	public List<Category> getAllCategories() {
		
		List<Category> categoryList= categoryRepo.findAll();
		
		System.out.println("categoryList ::"+categoryList);
		
		return categoryList;
	}


	@Override
	public CategoryRes addCategory(CategoryReq cateReq) throws ProductServiceException{
		
		CategoryRes res = new CategoryRes();
		
//		Category category = new Category();
//		
//		category.setCategoryDesc(cateReq.getCategoryDesc());
//		category.setCategoryName(cateReq.getCategoryName());
//		category.setCategoryType(cateReq.getCategoryType());
//		category.setStatus(cateReq.getCateStaus());
//		category.setCreatedOn(new Date());
//		category.setModifiedOn(new Date());
//		
//		
//		Product product = new Product();
//		
//		product.setProductName(cateReq.getProductName());
//		product.setNavigageTo(cateReq.getProdUrl());
//		product.setOffer_id(new Long(1));
//		product.setPrice(cateReq.getPrice());
//		product.setQuantity(new Long(cateReq.getQuantity()));
//		product.setTitle(cateReq.getTitle());
//		product.setStatus(cateReq.getProdStatus());
//		product.setCreatedOn(new Date());
//		product.setModifiedOn(new Date());
//		
//		Image image = new Image();
//		image.setImageType(cateReq.getImageType());
//		image.setImageUrl(cateReq.getImgUrl());
//		image.setCreatedOn(new Date());
//		image.setModifiedOn(new Date());
//		
//		Set<Image> imageList = new LinkedHashSet<>();
//		imageList.add(image);
//		product.setImageList(imageList);
//		
//		
//		ProductDetail productDetail = new ProductDetail();
//		productDetail.setSpecificaton(cateReq.getSpecification());
//		productDetail.setDescription(cateReq.getDesc());
//		productDetail.setCreatedOn(new Date());
//		productDetail.setModifiedOn(new Date());
//		
//		product.setProductDetail(productDetail);
//		
//		Set<Product> productList = new LinkedHashSet<Product>();
//		productList.add(product);
//		category.setProduct(productList);
//		
		
		////////////////////////////////////////////
		
//		ProductDetail productDetail = new ProductDetail(cateReq.getDescription(),cateReq.getSpecification(),CURRENT_TIME,CURRENT_TIME);
//		Image image = new Image(cateReq.getImageUrl(),cateReq.getImageType(),cateReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME);
//
//				
//		Set<Image> imageList = new LinkedHashSet<>();
//		imageList.add(image);
//		
//		
//		Offer offer = new Offer(cateReq.getPercentage(), cateReq.getOfferCode(), cateReq.getOfferDetail(), cateReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME);
//		
//		Set<Offer> offerList = new LinkedHashSet<>();
//		offerList.add(offer);
//		
//		
//		
//		
//		Set<Product> productList = new LinkedHashSet<Product>();
//		productList.add(product);
		
		Category category = new Category(cateReq.getCategoryName(), cateReq.getCategoryType(), cateReq.getCategoryDesc(), cateReq.getCateStaus(), CURRENT_TIME, CURRENT_TIME, cateReq.getCateUrl());
		
		Category cateEntity = categoryRepo.save(category);
		
		Product product = new Product(cateReq.getProductName(), cateReq.getTitle(),cateReq.getProdUrl(),cateReq.getPrice(),cateReq.getQuantity(),
				cateReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,cateEntity);
		
		Product prodEntity = productRepo.save(product);
		
		if(cateEntity == null) {
			throw new ProductServiceException("Unable to add Categories");
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


	
	

}
