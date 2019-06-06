package com.ecotage.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.ProductDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Image;
import com.ecotage.model.Offer;
import com.ecotage.model.Product;
import com.ecotage.model.ProductDetail;
import com.ecotage.repo.ImageRepository;
import com.ecotage.repo.OfferRepository;
import com.ecotage.repo.ProductDetailRepository;
import com.ecotage.repo.ProductRepository;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddProduct;
import com.ecotage.vo.ProductDetails;
import com.ecotage.vo.ProductImage;
import com.ecotage.vo.ProductOffer;
import com.ecotage.vo.Products;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	ImageRepository imageRepo;

	@Autowired
	OfferRepository offerRepo;

	@Autowired
	ProductDetailRepository prodDetRepo;

	@Override
	public List<Products> getProductsByCategory(Long categoryId) throws ProductServiceException {

		List<Products> productList = null;

		try {

			List<Product> productEntityList = productRepo.findByCategoryId(categoryId);
			System.out.println("productEntityList -->" + productEntityList.toString());
			productList = new ArrayList<>();
			for (Product productItem : productEntityList) {

				Products productRes = getProductRes(productItem);
				List<Image> imageList = imageRepo.findByProductId(productItem.getProductId());

				for (Image imageItem : imageList) {

					ProductImage prodImage = getProductImage(imageItem);
					List<ProductImage> productImageList = new ArrayList<>();
					productImageList.add(prodImage);
					productRes.setProductImageList(productImageList);

				}

				List<Offer> offerList = offerRepo.findByProductId(productItem.getProductId());
				for (Offer offerItem : offerList) {

					ProductOffer prodOffer = getProductOffer(offerItem);
					List<ProductOffer> productOfferList = new ArrayList<>();
					productOfferList.add(prodOffer);
					productRes.setProductOfferList(productOfferList);

				}

				productList.add(productRes);
			}

		} catch (Exception px) {
			px.printStackTrace();
			throw new ProductServiceException("Unable to find categories");
		}
		return productList;
	}

	private Products getProductRes(Product productItem) {

		Products productRes = new Products();
		productRes.setProductId(productItem.getProductId());
		productRes.setCategoryId(productItem.getCategoryId());
		productRes.setNavigageTo(productItem.getNavigageTo());
		productRes.setPrice(productItem.getPrice());
		productRes.setProductName(productItem.getProductName());
		productRes.setStatus(productItem.getStatus());
		productRes.setTitle(productItem.getTitle());

		return productRes;

	}

	private ProductImage getProductImage(Image imageItem) {

		ProductImage prodImage = new ProductImage();
		prodImage.setImageId(imageItem.getImageId());
		prodImage.setImageSource(imageItem.getImageSource());
		prodImage.setImageType(imageItem.getImageType());
		prodImage.setImageUrl(imageItem.getImageUrl());
		prodImage.setStatus(imageItem.getStatus());

		return prodImage;

	}

	private ProductOffer getProductOffer(Offer offerItem) {

		ProductOffer prodOffer = new ProductOffer();
		prodOffer.setOfferCode(offerItem.getOfferCode());
		prodOffer.setOfferDetail(offerItem.getOfferDetail());
		prodOffer.setOfferId(offerItem.getOfferId());
		prodOffer.setPercentage(offerItem.getPercentage());
		prodOffer.setStatus(offerItem.getStatus());

		return prodOffer;

	}

	private ProductDetails getProductOffer(ProductDetail prodDetailItem) {

		ProductDetails prodDetailVO = new ProductDetails();
		prodDetailVO.setDescription(prodDetailItem.getDescription());
		prodDetailVO.setSpecificaton(prodDetailItem.getSpecificaton());

		return prodDetailVO;

	}

	@Override
	public ResponseMessage addProduct(LinkedList<AddProduct> productList) throws ProductServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products getProduct(Long productId) throws ProductServiceException {
		Products productRes = null;
		try {
			Optional<Product> productEntity = productRepo.findByProductId(productId);

			if (productEntity.isPresent()) {
				productRes = getProductRes(productEntity.get());

				Optional<ProductDetail> prodDetEntity = prodDetRepo.findByProductId(productEntity.get().getProductId());

				if (prodDetEntity.isPresent()) {
					productRes.setProductDetails(getProductOffer(prodDetEntity.get()));
				}

				List<Image> imageList = imageRepo.findByProductId(prodDetEntity.get().getProductId());
				productRes.setImageUrl(imageList.get(0).getImageUrl());

				for (Image imageItem : imageList) {

					ProductImage prodImage = getProductImage(imageItem);
					List<ProductImage> productImageList = new ArrayList<>();
					productImageList.add(prodImage);
					productRes.setProductImageList(productImageList);

				}

				List<Offer> offerList = offerRepo.findByProductId(prodDetEntity.get().getProductId());
				for (Offer offerItem : offerList) {

					ProductOffer prodOffer = getProductOffer(offerItem);
					List<ProductOffer> productOfferList = new ArrayList<>();
					productOfferList.add(prodOffer);
					productRes.setProductOfferList(productOfferList);

				}

			}

		} catch (Exception px) {
			px.printStackTrace();
			throw new ProductServiceException("Unable to find categories");
		}
		
		return productRes;
	}

}
