package com.ecotage.handler;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//import com.ecotage.converter.ProductConverterBk;
//import com.ecotage.converter.ProductConverterBuilder;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.model.Category;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.service.ProductService;
import com.ecotage.vo.AddCategory;
import com.ecotage.vo.MenuCategory;
import com.ecotage.vo.Products;

@Component
public class ProductHandler {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private Mapper mapper;
	
	
	public List<MenuCategory> categories() throws ResourceNotFoundException, ProductServiceException {

		List<MenuCategory> menuCategories;
		try {
			List<Category> categories = productService.getAllCategories();
			menuCategories = categories.stream().map(c -> mapper.map(c, MenuCategory.class)).collect(Collectors.toList());
			if (categories == null) {
				throw new ResourceNotFoundException("Unable to Fetch Catgory");
			}

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while retrive category");
		}
		return menuCategories;
	}
	
	
	public ResponseMessage addCategories(@RequestBody LinkedList<AddCategory> categoryList)
			throws ResourceNotFoundException, ProductServiceException {

		ResponseMessage res = null;
		try {
			res = productService.addCategory(categoryList);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;
	}
	
	public List<Products> getProductsByCategory(@PathVariable("categoryId") Long categoryId)
			throws ResourceNotFoundException, ProductServiceException {

		List<Products> products = null;
		try {

			 products = productService.getProductsByCategory(categoryId);
			//products = product.stream().map(c -> mapper.map(c, Products.class)).collect(Collectors.toList());
			if (products.isEmpty()) {
				throw new ResourceNotFoundException("Product Not Found");
			}
		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while getting product");
		}
		return products;

	}
	
	
	public Products getProduct(@PathVariable("productId") Long productId)
			throws ResourceNotFoundException, ProductServiceException {

		
		try {

			Products product = productService.getProduct(productId);
			//products = product.stream().map(c -> mapper.map(c, Products.class)).collect(Collectors.toList());
			if (product == null) {
				throw new ResourceNotFoundException("Product Not Found");
			}
			return product;
		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while getting product");
		}
	

	}
	
/*
	@Autowired
	ProductService productService;
	
	@Autowired
	private Mapper mapper;

	public List<CategoryDTO> categories() throws ResourceNotFoundException, ProductServiceException {

		List<CategoryDTO> categories = null;
		try {
			List<CategoryDAO> categoriesDAO = productService.getAllCategories();
			categories = categoriesDAO.stream().map(c -> mapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
			if (categories == null) {
				throw new ResourceNotFoundException("Unable to Fetch Catgory");
			}

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while retrive category");
		}
		return categories;
	}

	public ResponseMessage addCategories(@RequestBody LinkedList<CategoryReq> cateReqList)
			throws ResourceNotFoundException, ProductServiceException {

		ResponseMessage res = null;
		try {
			res = productService.addCategory(cateReqList);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;
	}

	public List<CategoryDTO> getAllProducts(@PathVariable("categoryName") String name)
			throws ResourceNotFoundException, ProductServiceException {

		List<CategoryDTO> categories = null;
		try {

			List<CategoryDAO> categoriesDAO = productService.getProductByCategoryName(name);
			categories = categoriesDAO.stream().map(c -> mapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
			if (categories.isEmpty()) {
				throw new ResourceNotFoundException("Product Not Found");
			}
		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while getting product");
		}
		return categories;

	}

	public ResponseMessage addProducts(@RequestBody LinkedList<ProductReq> prodReqList)
			throws ResourceNotFoundException, ProductServiceException {

		ResponseMessage res = null;
		try {
			res = productService.addProduct(prodReqList);

		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while add category");
		}
		return res;

		// return productService.addProduct(product);

	}

	public ProductDTO getProduct(@PathVariable("productId") Long id)
			throws ResourceNotFoundException, ProductServiceException {
		ProductDTO product = null;
		try {

			Optional<ProductDAO> productDAO = productService.getProduct(id);
			if (productDAO.isPresent()) {
				product = mapper.map(productDAO, ProductDTO.class);
			} else {
				throw new ResourceNotFoundException("Product Not Found");
			}

		} catch (ProductServiceException px) {
			throw px;
		}

		return product;

	}

	public CategoryDTO getProductByCategoryId(Long categoryId)
			throws ResourceNotFoundException, ProductServiceException {

		CategoryDTO category = null;

		try {
			Optional<CategoryDAO> categoryDAO = productService.getProductByCategories(categoryId);
			if (categoryDAO.isPresent()) {
				category = mapper.map(categoryDAO, CategoryDTO.class);
			}
			if (category.getProductList() == null) {
				throw new ResourceNotFoundException("Product Not Found");
			}
		} catch (ProductServiceException px) {
			throw new ProductServiceException("Internal Server Exception while getting product");
		}
		return category;

	}
	
	public CartDetailDTO addProductToCard(String productId,String userId,int qunatity) throws ProductServiceException{
		CartDetailDTO cartDet = null;
		CartDetailDAO cartDetailDAO = productService.addToCart(productId,userId,qunatity);
		if (null == cartDetailDAO) {
			cartDet = mapper.map(cartDetailDAO, CartDetailDTO.class);
		}
		return cartDet;
	}
	
	

	public List<ViewCartInter> showCartItems(String productId, String userId)
			throws ProductServiceException {
		List<CartDetailDAO> cartItems = productService.showCartItems(productId, userId);
		List<ViewCartInter> cartItemsRes = cartItems.stream()
				.map(l -> mapper.map(l, com.ecotage.response.dto.CartDetailDTO.class)).collect(Collectors.toList());

		return cartItemsRes;
	}*/
}
