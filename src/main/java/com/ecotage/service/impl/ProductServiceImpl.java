package com.ecotage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ecotage.request.dao.ProductReq;
import com.ecotage.response.dao.CategoryRes;
import com.ecotage.response.dao.ProductRes;
import com.ecotage.response.dao.ResponseMessage;
import com.ecotage.service.ProductService;
import static com.ecotage.util.CommonUtil.CURRENT_TIME;

@Component
public class ProductServiceImpl implements ProductService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
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
		
		try {
		List<Category> categoryList= categoryRepo.findAll();
		System.out.println(categoryList);
		
		if(categoryList != null) {
			responseList =new ArrayList<CategoryRes>();
			for(Category cateResult : categoryList) {
				log.info("categoryList :::"+categoryList);
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
		
		} catch(Exception px) {
			
			throw new ProductServiceException("Unable to find categories");
		}
		
				
		return responseList;
	}


	@Override
	public ResponseMessage addCategory(LinkedList<CategoryReq> cateReqList) throws ProductServiceException{
		
		ResponseMessage res = new ResponseMessage();
		
		for(CategoryReq cateReq : cateReqList) {
			
			Optional<Category> cateEntity = categoryRepo.findByCategoryType(cateReq.getCategoryType());
			
			
			if(cateEntity.isPresent()) {
				Product product = null;
				
				log.info("category entity already persent");
				
				
				Optional<Product> findprodEntity = productRepo.findByProductName(cateReq.getProductName());
				
				if(findprodEntity.isPresent()) {
					
					Product updateProduct = findprodEntity.get();
					updateProduct.setModifiedOn(CURRENT_TIME);
					updateProduct.setStatus(cateReq.getProdStatus());
					Product prodEntity = productRepo.save(updateProduct);
					
					if(!cateReq.getDescription().equalsIgnoreCase("string")) {
						Optional<ProductDetail> findProdDet = prodDetRepo.findByProduct(prodEntity);
						if(findProdDet.isPresent()) {
							
							ProductDetail updateProductDtls = findProdDet.get();
							
							updateProductDtls.setDescription(cateReq.getDescription());
							updateProductDtls.setModifiedOn(CURRENT_TIME);
							prodDetRepo.save(updateProductDtls);
							
						}
					}
					
					for(ImageReq imgReq : cateReq.getImgReqList()) {
						
						Optional<Image> findByImage = imageRepo.findByImageUrl(imgReq.getImageUrl());
						if(findByImage.isPresent()) {
							Image updateImage = findByImage.get();
							updateImage.setImageUrl(imgReq.getImageUrl());
							updateImage.setModifiedOn(CURRENT_TIME);
							
						} else {
							Image image = new Image(imgReq.getImageUrl(),imgReq.getImageType(),imgReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME,prodEntity);
							
							Image imageEntity = imageRepo.save(image);
						}
						
						
					}
					
					for(OfferReq offReq : cateReq.getOfferList()) {
						
						if(!offReq.getOfferCode().equals("######"))
						{
							Offer offer = new Offer(offReq.getPercentage(), offReq.getOfferCode(), offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
							
							Offer offerEntity = offerRepo.save(offer);
						}
						
						
					}
					
				}
				else {
					 product = new Product(cateReq.getProductName(), cateReq.getTitle(),cateReq.getProdUrl(),cateReq.getPrice(),cateReq.getQuantity(),
								cateReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,cateEntity.get());
					 
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
				}
				
				
			}else {
				Product product = null;
				log.info("category entity already persent not present");
				
				Category category = new Category(cateReq.getCategoryName(), cateReq.getCategoryType(), cateReq.getCategoryDesc(), cateReq.getCateStaus(), CURRENT_TIME, CURRENT_TIME, cateReq.getCateUrl());
				
				Category categoryEntity = categoryRepo.save(category);
				
				 product = new Product(cateReq.getProductName(), cateReq.getTitle(),cateReq.getProdUrl(),cateReq.getPrice(),cateReq.getQuantity(),
						cateReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,categoryEntity);
				 
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
				
			}
			
			if(!cateEntity.isPresent()) {
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
	public ResponseMessage addProduct(LinkedList<ProductReq> prodReqList) throws ProductServiceException {
	//	product.getProductDetail().setProduct(product);
		//Product prodEntity = productRepo.save(product);
		ResponseMessage res = new ResponseMessage();
		
		for(ProductReq prodReq : prodReqList) {
			
			Optional<Product> findProduct = productRepo.findByProductName(prodReq.getProductName());
			
			if(findProduct.isPresent()) {

				
				Product updateProduct = findProduct.get();
				updateProduct.setModifiedOn(CURRENT_TIME);
				updateProduct.setStatus(prodReq.getStatus());
				Product prodEntity = productRepo.save(updateProduct);
				
				if(!prodReq.getDescription().equalsIgnoreCase("string")) {
					Optional<ProductDetail> findProdDet = prodDetRepo.findByProduct(prodEntity);
					if(findProdDet.isPresent()) {
						
						ProductDetail updateProductDtls = findProdDet.get();
						
						updateProductDtls.setDescription(prodReq.getDescription());
						updateProductDtls.setModifiedOn(CURRENT_TIME);
						prodDetRepo.save(updateProductDtls);
						
					}
				}
				
				for(ImageReq imgReq : prodReq.getImgReqList()) {
					
					Optional<Image> findByImage = imageRepo.findByImageUrl(imgReq.getImageUrl());
					if(findByImage.isPresent()) {
						Image updateImage = findByImage.get();
						updateImage.setImageUrl(imgReq.getImageUrl());
						updateImage.setModifiedOn(CURRENT_TIME);
						
					} else {
						Image image = new Image(imgReq.getImageUrl(),imgReq.getImageType(),imgReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME,prodEntity);
						
						Image imageEntity = imageRepo.save(image);
					}
					
					
				}
				
				for(OfferReq offReq : prodReq.getOfferList()) {
					
					if(!offReq.getOfferCode().equals("######"))
					{
						Offer offer = new Offer(offReq.getPercentage(), offReq.getOfferCode(), offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
						
						Offer offerEntity = offerRepo.save(offer);
					}
				
				}
				
			} else {
				
				Optional<Category> findCategory = categoryRepo.findByCategoryType(prodReq.getCategoryType());
				
				if(findCategory.isPresent()) {
				
				Product product = new Product(prodReq.getProductName(), prodReq.getTitle(),prodReq.getProdUrl(),prodReq.getPrice(),prodReq.getQuantity(),
						prodReq.getProdStatus(),CURRENT_TIME,CURRENT_TIME,findCategory.get());
				 
				 Product prodEntity = productRepo.save(product);
					
				ProductDetail productDetail = new ProductDetail(prodReq.getDescription(),prodReq.getSpecification(),CURRENT_TIME,CURRENT_TIME,prodEntity);
				
				ProductDetail prodDetailEntity = prodDetRepo.save(productDetail);
				
				for(ImageReq imgReq : prodReq.getImgReqList()) {
					
					Image image = new Image(imgReq.getImageUrl(),imgReq.getImageType(),imgReq.getImgStatus(),CURRENT_TIME,CURRENT_TIME,prodEntity);
					
					Image imageEntity = imageRepo.save(image);
				}
				
				for(OfferReq offReq : prodReq.getOfferList()) {
					
					Offer offer = new Offer(offReq.getPercentage(), offReq.getOfferCode(), offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
					
					Offer offerEntity = offerRepo.save(offer);
				}
				} else {
					res.setErrorCode("E1111");
					res.setMessage("Unable to add products");
				}
				
			}
			
			res.setErrorCode("0000");
			res.setMessage("Success");
			
		}
		
		return res;	
		}


	@Override
	public ProductRes getProduct(Long id) throws ProductServiceException{
		
		
		Optional<Product> product = productRepo.findById(id);
		
		
		if(!product.isPresent()) {
			throw new ProductServiceException("product should be valid one");
		}
		ProductRes prodRes = new ProductRes();
		
		Product prodResult = product.get();
		
		prodRes.setProductName(prodResult.getProductName());
		prodRes.setProductId(prodResult.getProductId());
		prodRes.setQuantity(prodResult.getQuantity());
		prodRes.setPrice(prodResult.getPrice());
		prodRes.setNavigateTo(prodResult.getNavigageTo());
		prodRes.setDescription(prodResult.getProductDetail().getDescription());
		prodRes.setSpecification(prodResult.getProductDetail().getSpecificaton());
		List<Image> imageList = new ArrayList<Image>(prodResult.getImageList());
		prodRes.setImageUrl(imageList.get(0).getImageUrl());
		List<Offer> offerList = new ArrayList<Offer>(prodResult.getOffer());
		prodRes.setOfferDetail(offerList.get(0).getOfferDetail());
		prodRes.setOfferPercentage(offerList.get(0).getPercentage());
		
		return prodRes;
		
	}


	@Override
	public List<CategoryRes> getProductByCategories(Long id)  throws ProductServiceException{
		
		List<CategoryRes> responseList = null;
		
		Optional<Category> categoryResult = categoryRepo.findById(id);
		
		if(categoryResult.isPresent()) {
			Category cateResult = categoryResult.get();
			responseList =new ArrayList<CategoryRes>();
			CategoryRes cateResponse = new CategoryRes();
			ResponseMessage res = new ResponseMessage();
			List<ProductRes> prodResList = new ArrayList<>();
			cateResponse.setCategoryName(cateResult.getCategoryName());
			
			for(Product prodResult : cateResult.getProductList())
			{
				ProductRes prodRes = new ProductRes();
				
				prodRes.setProductId(prodResult.getProductId());
				prodRes.setProductName(prodResult.getProductName());
				prodRes.setNavigateTo(prodResult.getNavigageTo());
				prodRes.setPrice(prodResult.getPrice());
				List<Image> imgList = new ArrayList<Image>(prodResult.getImageList());
				prodRes.setImageUrl(imgList.get(0).getImageUrl());
				
				List<Offer> offerList = new ArrayList<Offer>(prodResult.getOffer());
				prodRes.setOfferDetail(offerList.get(0).getOfferDetail());
				prodRes.setOfferPercentage(offerList.get(0).getPercentage());
				
				prodResList.add(prodRes);
				
			}
			cateResponse.setProductResList(prodResList);
			
			res.setErrorCode("0000");
			res.setMessage("success");
			cateResponse.setResponseMsg(res);
			responseList.add(cateResponse);
		}
		
		return responseList;
	}


	@Override
	public List<CategoryRes> getProductByCategoryName(String name) throws ProductServiceException {
		
		List<CategoryRes> responseList = null;
		
		List<Category> categoryList= categoryRepo.findByCategoryName(name);
		//System.out.println(categoryList);
		
		if(categoryList != null) {
			responseList =new ArrayList<CategoryRes>();
			for(Category cateResult : categoryList) {
				
				
				CategoryRes cateResponse = new CategoryRes();
				
				ResponseMessage res = new ResponseMessage();
				
				List<ProductRes> prodResList = new ArrayList<>();
				
				
				
				cateResponse.setCategoryName(cateResult.getCategoryName());
				for(Product prodResult : cateResult.getProductList())
				{
					ProductRes prodRes = new ProductRes();
					
					prodRes.setProductId(prodResult.getProductId());
					prodRes.setProductName(prodResult.getProductName());
					prodRes.setNavigateTo(prodResult.getNavigageTo());
					prodRes.setPrice(prodResult.getPrice());
					List<Image> imgList = new ArrayList<Image>(prodResult.getImageList());
					prodRes.setImageUrl(imgList.get(0).getImageUrl());
					
					List<Offer> offerList = new ArrayList<Offer>(prodResult.getOffer());
					prodRes.setOfferDetail(offerList.get(0).getOfferDetail());
					prodRes.setOfferPercentage(offerList.get(0).getPercentage());
					
					prodResList.add(prodRes);
					
				}
				
				cateResponse.setProductResList(prodResList);
				
				res.setErrorCode("0000");
				res.setMessage("success");
				cateResponse.setResponseMsg(res);
				responseList.add(cateResponse);
				

				
			}
		}
		
		System.out.println("categoryList ::"+categoryList);
		
		return responseList;
	}


	
	

}
