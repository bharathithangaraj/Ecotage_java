package com.ecotage.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.CategoryDAO;
import com.ecotage.dao.ProductDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Category;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.service.ProductService;
import com.ecotage.vo.AddCategory;
import com.ecotage.vo.Products;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	ProductDAO productDao;

	@Override
	public List<Category> getAllCategories() throws ProductServiceException {
		List<Category> categoryList = null;

		try {
			categoryList = categoryDao.getAllCategories();

			System.out.println(categoryList);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return categoryList;
	}

	@Override
	public ResponseMessage addCategory(LinkedList<AddCategory> categoryList) throws ProductServiceException {

		ResponseMessage res = null;

		try {
			res = categoryDao.addCategories(categoryList);

			System.out.println(categoryList);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}

		return res;

	}

	@Override
	public List<Products> getProductsByCategory(Long id) throws ProductServiceException {
		List<Products> productList = null;

		try {
			productList = productDao.getProductsByCategory(id);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return productList;
	}

	@Override
	public Products getProduct(Long productId) throws ProductServiceException {
		Products product = null;

		try {
			product = productDao.getProduct(productId);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return product;
	}

	/*
	 * Logger log = LoggerFactory.getLogger(this.getClass().getName());
	 * 
	 * @Autowired CategoryRepository categoryRepo;
	 * 
	 * @Autowired ProductRepositry productRepo;
	 * 
	 * @Autowired ProductDetailRepository prodDetRepo;
	 * 
	 * @Autowired ImageRepository imageRepo;
	 * 
	 * @Autowired OfferRepository offerRepo;
	 * 
	 * @Autowired CartRepository cartRepo;
	 * 
	 * @Override public List<CategoryDAO> getAllCategories() throws
	 * ProductServiceException {
	 * 
	 * // List<CategoryRes> responseList = null; List<CategoryDAO> categoryList =
	 * null;
	 * 
	 * try { categoryList = categoryRepo.findAll(); //
	 * System.out.println(categoryList); // // if(categoryList != null) { //
	 * responseList =new ArrayList<CategoryRes>(); // for(CategoryDAO cateResult :
	 * categoryList) { // log.info("categoryList :::"+categoryList); // Category
	 * response = new CategoryRes(); // ResponseMessage res = new ResponseMessage();
	 * // // response.setCategoryId(cateResult.getCategoryId()); //
	 * response.setCategoryName(cateResult.getCategoryName()); //
	 * response.setCategoryType(cateResult.getCategoryType()); //
	 * response.setCateUrl(cateResult.getNavigateTo()); // res.setErrorCode("0000");
	 * // res.setMessage("success"); // response.setResponseMsg(res); //
	 * responseList.add(response); // // } // // }
	 * 
	 * } catch (Exception px) {
	 * 
	 * throw new ProductServiceException("Unable to find categories"); }
	 * 
	 * return categoryList; }
	 * 
	 * @Override public ResponseMessage addCategory(LinkedList<CategoryReq>
	 * cateReqList) throws ProductServiceException {
	 * 
	 * ResponseMessage res = new ResponseMessage();
	 * 
	 * for (CategoryReq cateReq : cateReqList) {
	 * 
	 * Optional<CategoryDAO> cateEntity =
	 * categoryRepo.findByCategoryType(cateReq.getCategoryType());
	 * 
	 * if (cateEntity.isPresent()) { ProductDAO product = null;
	 * 
	 * log.info("category entity already persent");
	 * 
	 * Optional<ProductDAO> findprodEntity =
	 * productRepo.findByProductName(cateReq.getProductName());
	 * 
	 * if (findprodEntity.isPresent()) {
	 * 
	 * ProductDAO updateProduct = findprodEntity.get();
	 * updateProduct.setModifiedOn(CURRENT_TIME);
	 * updateProduct.setStatus(cateReq.getProdStatus()); ProductDAO prodEntity =
	 * productRepo.save(updateProduct);
	 * 
	 * if (!cateReq.getDescription().equalsIgnoreCase("string")) {
	 * Optional<ProductDetailDAO> findProdDet =
	 * prodDetRepo.findByProduct(prodEntity); if (findProdDet.isPresent()) {
	 * 
	 * ProductDetailDAO updateProductDtls = findProdDet.get();
	 * 
	 * updateProductDtls.setDescription(cateReq.getDescription());
	 * updateProductDtls.setModifiedOn(CURRENT_TIME);
	 * prodDetRepo.save(updateProductDtls);
	 * 
	 * } }
	 * 
	 * for (ImageReq imgReq : cateReq.getImgReqList()) {
	 * 
	 * Optional<ImageDAO> findByImage =
	 * imageRepo.findByImageUrl(imgReq.getImageUrl()); if (findByImage.isPresent())
	 * { ImageDAO updateImage = findByImage.get();
	 * updateImage.setImageUrl(imgReq.getImageUrl());
	 * updateImage.setModifiedOn(CURRENT_TIME);
	 * 
	 * } else { ImageDAO image = new ImageDAO(imgReq.getImageUrl(),
	 * imgReq.getImageType(), imgReq.getImgStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * ImageDAO imageEntity = imageRepo.save(image); }
	 * 
	 * }
	 * 
	 * for (OfferReq offReq : cateReq.getOfferList()) {
	 * 
	 * if (!offReq.getOfferCode().equals("######")) { OfferDAO offer = new
	 * OfferDAO(offReq.getPercentage(), offReq.getOfferCode(),
	 * offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * OfferDAO offerEntity = offerRepo.save(offer); }
	 * 
	 * }
	 * 
	 * } else { product = new ProductDAO(cateReq.getProductName(),
	 * cateReq.getTitle(), cateReq.getProdUrl(), cateReq.getPrice(),
	 * cateReq.getQuantity(), cateReq.getProdStatus(), CURRENT_TIME, CURRENT_TIME,
	 * cateEntity.get());
	 * 
	 * ProductDAO prodEntity = productRepo.save(product);
	 * 
	 * ProductDetailDAO productDetail = new
	 * ProductDetailDAO(cateReq.getDescription(), cateReq.getSpecification(),
	 * CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ProductDetailDAO prodDetailEntity = prodDetRepo.save(productDetail);
	 * 
	 * for (ImageReq imgReq : cateReq.getImgReqList()) {
	 * 
	 * ImageDAO image = new ImageDAO(imgReq.getImageUrl(), imgReq.getImageType(),
	 * imgReq.getImgStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ImageDAO imageEntity = imageRepo.save(image); }
	 * 
	 * for (OfferReq offReq : cateReq.getOfferList()) {
	 * 
	 * OfferDAO offer = new OfferDAO(offReq.getPercentage(), offReq.getOfferCode(),
	 * offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * OfferDAO offerEntity = offerRepo.save(offer); } }
	 * 
	 * } else { ProductDAO product = null;
	 * log.info("category entity already persent not present");
	 * 
	 * CategoryDAO category = new CategoryDAO(cateReq.getCategoryName(),
	 * cateReq.getCategoryType(), cateReq.getCategoryDesc(), cateReq.getCateStaus(),
	 * CURRENT_TIME, CURRENT_TIME, cateReq.getCateUrl());
	 * 
	 * CategoryDAO categoryEntity = categoryRepo.save(category);
	 * 
	 * product = new ProductDAO(cateReq.getProductName(), cateReq.getTitle(),
	 * cateReq.getProdUrl(), cateReq.getPrice(), cateReq.getQuantity(),
	 * cateReq.getProdStatus(), CURRENT_TIME, CURRENT_TIME, categoryEntity);
	 * 
	 * ProductDAO prodEntity = productRepo.save(product);
	 * 
	 * ProductDetailDAO productDetail = new
	 * ProductDetailDAO(cateReq.getDescription(), cateReq.getSpecification(),
	 * CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ProductDetailDAO prodDetailEntity = prodDetRepo.save(productDetail);
	 * 
	 * for (ImageReq imgReq : cateReq.getImgReqList()) {
	 * 
	 * ImageDAO image = new ImageDAO(imgReq.getImageUrl(), imgReq.getImageType(),
	 * imgReq.getImgStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ImageDAO imageEntity = imageRepo.save(image); }
	 * 
	 * for (OfferReq offReq : cateReq.getOfferList()) {
	 * 
	 * OfferDAO offer = new OfferDAO(offReq.getPercentage(), offReq.getOfferCode(),
	 * offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * OfferDAO offerEntity = offerRepo.save(offer); }
	 * 
	 * }
	 * 
	 * if (!cateEntity.isPresent()) { throw new
	 * ProductServiceException("Unable to add Categories"); }
	 * 
	 * }
	 * 
	 * res.setMessage("success"); res.setErrorCode("0000"); return res; }
	 * 
	 * @Override public List<ProductDAO> getAllProducts() {
	 * 
	 * List<ProductDAO> productList = productRepo.findAll();
	 * 
	 * System.out.println("categoryList ::" + productList);
	 * 
	 * return productList; }
	 * 
	 * @Override public ResponseMessage addProduct(LinkedList<ProductReq>
	 * prodReqList) throws ProductServiceException { //
	 * product.getProductDetail().setProduct(product); // Product prodEntity =
	 * productRepo.save(product); ResponseMessage res = new ResponseMessage();
	 * 
	 * for (ProductReq prodReq : prodReqList) {
	 * 
	 * Optional<ProductDAO> findProduct =
	 * productRepo.findByProductName(prodReq.getProductName());
	 * 
	 * if (findProduct.isPresent()) {
	 * 
	 * ProductDAO updateProduct = findProduct.get();
	 * updateProduct.setModifiedOn(CURRENT_TIME);
	 * updateProduct.setStatus(prodReq.getStatus()); ProductDAO prodEntity =
	 * productRepo.save(updateProduct);
	 * 
	 * if (!prodReq.getDescription().equalsIgnoreCase("string")) {
	 * Optional<ProductDetailDAO> findProdDet =
	 * prodDetRepo.findByProduct(prodEntity); if (findProdDet.isPresent()) {
	 * 
	 * ProductDetailDAO updateProductDtls = findProdDet.get();
	 * 
	 * updateProductDtls.setDescription(prodReq.getDescription());
	 * updateProductDtls.setModifiedOn(CURRENT_TIME);
	 * prodDetRepo.save(updateProductDtls);
	 * 
	 * } }
	 * 
	 * for (ImageReq imgReq : prodReq.getImgReqList()) {
	 * 
	 * Optional<ImageDAO> findByImage =
	 * imageRepo.findByImageUrl(imgReq.getImageUrl()); if (findByImage.isPresent())
	 * { ImageDAO updateImage = findByImage.get();
	 * updateImage.setImageUrl(imgReq.getImageUrl());
	 * updateImage.setModifiedOn(CURRENT_TIME);
	 * 
	 * } else { ImageDAO image = new ImageDAO(imgReq.getImageUrl(),
	 * imgReq.getImageType(), imgReq.getImgStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * ImageDAO imageEntity = imageRepo.save(image); }
	 * 
	 * }
	 * 
	 * for (OfferReq offReq : prodReq.getOfferList()) {
	 * 
	 * if (!offReq.getOfferCode().equals("######")) { OfferDAO offer = new
	 * OfferDAO(offReq.getPercentage(), offReq.getOfferCode(),
	 * offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * OfferDAO offerEntity = offerRepo.save(offer); }
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * Optional<CategoryDAO> findCategory =
	 * categoryRepo.findByCategoryType(prodReq.getCategoryType());
	 * 
	 * if (findCategory.isPresent()) {
	 * 
	 * ProductDAO product = new ProductDAO(prodReq.getProductName(),
	 * prodReq.getTitle(), prodReq.getProdUrl(), prodReq.getPrice(),
	 * prodReq.getQuantity(), prodReq.getProdStatus(), CURRENT_TIME, CURRENT_TIME,
	 * findCategory.get());
	 * 
	 * ProductDAO prodEntity = productRepo.save(product);
	 * 
	 * ProductDetailDAO productDetail = new
	 * ProductDetailDAO(prodReq.getDescription(), prodReq.getSpecification(),
	 * CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ProductDetailDAO prodDetailEntity = prodDetRepo.save(productDetail);
	 * 
	 * for (ImageReq imgReq : prodReq.getImgReqList()) {
	 * 
	 * ImageDAO image = new ImageDAO(imgReq.getImageUrl(), imgReq.getImageType(),
	 * imgReq.getImgStatus(), CURRENT_TIME, CURRENT_TIME, prodEntity);
	 * 
	 * ImageDAO imageEntity = imageRepo.save(image); }
	 * 
	 * for (OfferReq offReq : prodReq.getOfferList()) {
	 * 
	 * OfferDAO offer = new OfferDAO(offReq.getPercentage(), offReq.getOfferCode(),
	 * offReq.getOfferDetail(), offReq.getOfferStatus(), CURRENT_TIME, CURRENT_TIME,
	 * prodEntity);
	 * 
	 * OfferDAO offerEntity = offerRepo.save(offer); } } else {
	 * res.setErrorCode("E1111"); res.setMessage("Unable to add products"); }
	 * 
	 * }
	 * 
	 * res.setErrorCode("0000"); res.setMessage("Success");
	 * 
	 * }
	 * 
	 * return res; }
	 * 
	 * @Override public Optional<ProductDAO> getProduct(Long id) throws
	 * ProductServiceException {
	 * 
	 * Optional<ProductDAO> product = productRepo.findById(id);
	 * 
	 * if (!product.isPresent()) { throw new
	 * ProductServiceException("product should be valid one"); } // ProductRes
	 * prodRes = new ProductRes(); // // ProductDAO prodResult = product.get(); //
	 * // prodRes.setProductName(prodResult.getProductName()); //
	 * prodRes.setProductId(prodResult.getProductId()); //
	 * prodRes.setQuantity(prodResult.getQuantity()); //
	 * prodRes.setPrice(prodResult.getPrice()); //
	 * prodRes.setNavigateTo(prodResult.getNavigageTo()); //
	 * prodRes.setDescription(prodResult.getProductDetail().getDescription()); //
	 * prodRes.setSpecification(prodResult.getProductDetail().getSpecificaton()); //
	 * List<ImageDAO> imageList = new
	 * ArrayList<ImageDAO>(prodResult.getImageList()); //
	 * prodRes.setImageUrl(imageList.get(0).getImageUrl()); // List<OfferDAO>
	 * offerList = new ArrayList<OfferDAO>(prodResult.getOffer()); //
	 * prodRes.setOfferDetail(offerList.get(0).getOfferDetail()); //
	 * prodRes.setOfferPercentage(offerList.get(0).getPercentage());
	 * 
	 * return product;
	 * 
	 * }
	 * 
	 * @Override public Optional<CategoryDAO> getProductByCategories(Long id) throws
	 * ProductServiceException {
	 * 
	 * List<CategoryDAO> responseList = null;
	 * 
	 * Optional<CategoryDAO> categoryResult = categoryRepo.findById(id);
	 * 
	 * if (categoryResult.isPresent()) { // CategoryDAO cateResult =
	 * categoryResult.get(); // responseList =new ArrayList<CategoryRes>(); //
	 * CategoryRes cateResponse = new CategoryRes(); // ResponseMessage res = new
	 * ResponseMessage(); // List<ProductRes> prodResList = new ArrayList<>(); //
	 * cateResponse.setCategoryName(cateResult.getCategoryName()); // //
	 * for(ProductDAO prodResult : cateResult.getProductList()) // { // ProductRes
	 * prodRes = new ProductRes(); // //
	 * prodRes.setProductId(prodResult.getProductId()); //
	 * prodRes.setProductName(prodResult.getProductName()); //
	 * prodRes.setNavigateTo(prodResult.getNavigageTo()); //
	 * prodRes.setPrice(prodResult.getPrice()); // List<ImageDAO> imgList = new
	 * ArrayList<ImageDAO>(prodResult.getImageList()); //
	 * prodRes.setImageUrl(imgList.get(0).getImageUrl()); // // List<OfferDAO>
	 * offerList = new ArrayList<OfferDAO>(prodResult.getOffer()); //
	 * prodRes.setOfferDetail(offerList.get(0).getOfferDetail()); //
	 * prodRes.setOfferPercentage(offerList.get(0).getPercentage()); // //
	 * prodResList.add(prodRes); // // } //
	 * cateResponse.setProductResList(prodResList); // // res.setErrorCode("0000");
	 * // res.setMessage("success"); // cateResponse.setResponseMsg(res); //
	 * responseList.add(cateResponse); // responseList =
	 * categoryResult.get().getProductList() }
	 * 
	 * return categoryResult; }
	 * 
	 * @Override public List<CategoryDAO> getProductByCategoryName(String name)
	 * throws ProductServiceException {
	 * 
	 * // List<CategoryRes> responseList = null;
	 * 
	 * List<CategoryDAO> categoryList = categoryRepo.findByCategoryName(name); //
	 * System.out.println(categoryList);
	 * 
	 * // if(categoryList != null) { // responseList =new ArrayList<CategoryRes>();
	 * // for(CategoryDAO cateResult : categoryList) { // // // CategoryRes
	 * cateResponse = new CategoryRes(); // // ResponseMessage res = new
	 * ResponseMessage(); // // List<ProductRes> prodResList = new ArrayList<>(); //
	 * // // // cateResponse.setCategoryName(cateResult.getCategoryName()); //
	 * for(ProductDAO prodResult : cateResult.getProductList()) // { // ProductRes
	 * prodRes = new ProductRes(); // //
	 * prodRes.setProductId(prodResult.getProductId()); //
	 * prodRes.setProductName(prodResult.getProductName()); //
	 * prodRes.setNavigateTo(prodResult.getNavigageTo()); //
	 * prodRes.setPrice(prodResult.getPrice()); // List<ImageDAO> imgList = new
	 * ArrayList<ImageDAO>(prodResult.getImageList()); //
	 * prodRes.setImageUrl(imgList.get(0).getImageUrl()); // // List<OfferDAO>
	 * offerList = new ArrayList<OfferDAO>(prodResult.getOffer()); //
	 * prodRes.setOfferDetail(offerList.get(0).getOfferDetail()); //
	 * prodRes.setOfferPercentage(offerList.get(0).getPercentage()); // //
	 * prodResList.add(prodRes); // // } // //
	 * cateResponse.setProductResList(prodResList); // // res.setErrorCode("0000");
	 * // res.setMessage("success"); // cateResponse.setResponseMsg(res); //
	 * responseList.add(cateResponse); // // // // } // }
	 * 
	 * System.out.println("categoryList ::" + categoryList);
	 * 
	 * return categoryList; }
	 * 
	 * private Optional<OfferDAO> getOfferChild(Long offerId) {
	 * 
	 * return offerRepo.findById(offerId); }
	 * 
	 * private Optional<ProductDAO> getProductChild(Long id) {
	 * 
	 * return productRepo.findById(id);
	 * 
	 * }
	 * 
	 * @Override public CartDetailDAO addToCart(String productId, String userId, int
	 * quantity) throws ProductServiceException { Long productID =
	 * CommonUtil.decryptToId(productId);
	 * 
	 * // Long userId = null; //CommonUtil.decryptToId(cartDetail.);
	 * 
	 * ProductDAO product = getProductChild(productID).get(); // (Long cartId, int
	 * quantity, Double price, int status, Date createdOn, Date //
	 * modifiedOn,Product product, Offer offer CartDetailDAO cart = new
	 * CartDetailDAO(quantity, product.getPrice(), CURRENT_TIME, CURRENT_TIME,
	 * product); return cartRepo.save(cart); }
	 * 
	 * @Override public List<CartDetailDAO> showCartItems(String productId, String
	 * userId) { ProductDAO product = null; Long productID =
	 * CommonUtil.decryptToId(productId); Long userID =
	 * CommonUtil.decryptToId(userId); try { System.out.println("ProductId:" +
	 * productID); product = getProductChild(productID).get(); } catch (Exception e)
	 * { e.printStackTrace(); } return cartRepo.findByProduct(product); }
	 */

}
