package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.CartDetailDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Product;
import com.ecotage.model.User;
import com.ecotage.repo.CartDetailRepository;
import com.ecotage.repo.ProductRepository;
import com.ecotage.repo.UserRepository;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.Products;
import com.ecotage.vo.ShowCartDetails;

@Component
public class CartDetailDAOImpl implements CartDetailDAO {

	@Autowired
	CartDetailRepository cartRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public ShowCartDetails addToCarts(AddCartDetails cartItem) throws ProductServiceException {
		ShowCartDetails addedCarts = new ShowCartDetails();

		try {

			Optional<Product> productEntity = productRepo.findByProductId(cartItem.getProductId());

			Optional<User> userEntity = userRepo.findById(cartItem.getUserId());

			if (!productEntity.isPresent() || !userEntity.isPresent()) {
				throw new ProductServiceException("Selected User/ Product Not available");

			}

			if (productEntity.get().getQuantity() < cartItem.getQuantity()) {
				throw new ProductServiceException(
						"No stockes available for the selected Quantity :" + productEntity.get().getQuantity());
			}

			//Product prod = productEntity.get();
			//prod.setModifiedOn(CURRENT_TIME);
			//prod.setQuantity(prod.getQuantity() - cartItem.getQuantity());

			//productRepo.save(prod);

			CartDetail cartEntity = new CartDetail(cartItem.getQuantity(), cartItem.getPrice(), cartItem.getUserId(),
					cartItem.getStatus(), CURRENT_TIME, CURRENT_TIME, cartItem.getProductId());
			CartDetail newCart =  cartRepo.save(cartEntity);
			
			addedCarts.setCartId(newCart.getCartId());
			addedCarts.setPrice(newCart.getPrice());
			addedCarts.setQuantity(newCart.getQuantity());
			addedCarts.setUserId(newCart.getUserId());
			addedCarts.setStatus(newCart.getStatus());
			addedCarts.setProductId(newCart.getProductId());

			Optional<Product> newProduct = productRepo.findByProductId(newCart.getProductId());

			if (newProduct.isPresent()) {
				Products product = new Products();
				product.setNavigageTo(newProduct.get().getNavigageTo());
				product.setProductName(newProduct.get().getProductName());
				product.setTitle(newProduct.get().getTitle());
				product.setImageUrl(newProduct.get().getImageUrl());
				product.setQuantity(newProduct.get().getQuantity());
				addedCarts.setProduct(product);
			}

			// }

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductServiceException("Unable to add cart details");

		}

		// }
		return addedCarts;
	}

	@Override
	public ResponseMessage deleteCarts(Long cartId) throws ProductServiceException {
		ResponseMessage res = new ResponseMessage();
		try {

			Optional<CartDetail> cartEntity = cartRepo.findById(cartId);

			if (!cartEntity.isPresent()) {
				throw new ProductServiceException("Cart Item Not Found , Please check");
			}

			Optional<Product> productEntity = productRepo.findByProductId(cartEntity.get().getProductId());

			if (!productEntity.isPresent()) {
				throw new ProductServiceException("Cart Selected Product Not Found , Please check");
			}

			//Product prod = productEntity.get();
			//prod.setModifiedOn(CURRENT_TIME);
			//prod.setQuantity(prod.getQuantity() + cartEntity.get().getQuantity());

			//productRepo.save(prod);

			cartRepo.delete(cartEntity.get());

			res.setMessage("success");
			res.setErrorCode("0000");

		} catch (Exception ex) {
			res.setMessage(ex.getMessage());
			res.setErrorCode("E001");
		}
		return res;

	}

	@Override
	public List<ShowCartDetails> getCarts(Long userId) throws ProductServiceException {

		List<ShowCartDetails> cartDetails = null;

		try {
			List<CartDetail> cartEntity = cartRepo.findByUserId(userId);
			cartDetails = new ArrayList<>();
			for (CartDetail cartItem : cartEntity) {

				ShowCartDetails showCarts = new ShowCartDetails();
				showCarts.setCartId(cartItem.getCartId());
				showCarts.setPrice(cartItem.getPrice());
				showCarts.setQuantity(cartItem.getQuantity());
				showCarts.setUserId(cartItem.getUserId());
				showCarts.setStatus(cartItem.getStatus());
				showCarts.setProductId(cartItem.getProductId());

				Optional<Product> productEntity = productRepo.findByProductId(cartItem.getProductId());

				if (productEntity.isPresent()) {
					Products product = new Products();
					product.setNavigageTo(productEntity.get().getNavigageTo());
					product.setProductName(productEntity.get().getProductName());
					product.setTitle(productEntity.get().getTitle());
					product.setImageUrl(productEntity.get().getImageUrl());
					product.setQuantity(productEntity.get().getQuantity());
					showCarts.setProduct(product);
				}

				cartDetails.add(showCarts);

			}

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find cart details");
		}
		return cartDetails;

	}

	@Override
	public ResponseMessage updateCarts(AddCartDetails cartItem) throws ProductServiceException {

		ResponseMessage res = new ResponseMessage();

		try {
			int quantity = 0;
			Optional<CartDetail> cartEntity = cartRepo.findById(cartItem.getCartId());

			if (cartEntity.isPresent()) {

				Optional<Product> productEntity = productRepo.findByProductId(cartItem.getProductId());

				Optional<User> userEntity = userRepo.findById(cartItem.getUserId());

				if (!productEntity.isPresent() || !userEntity.isPresent()) {
					throw new ProductServiceException("Selected User/ Product Not available");

				}

				if (productEntity.get().getQuantity() < cartItem.getQuantity()) {
					throw new ProductServiceException(
							"No stockes available for the selected Quantity :" + productEntity.get().getQuantity());
				}

				/*if (cartEntity.get().getQuantity() > cartItem.getQuantity()) {
					quantity = (cartEntity.get().getQuantity() - cartItem.getQuantity());
				}

				if (cartEntity.get().getQuantity() < cartItem.getQuantity()) {
					quantity = -(cartItem.getQuantity() - cartEntity.get().getQuantity());
				}

				Product prod = productEntity.get();
				prod.setModifiedOn(CURRENT_TIME);
				prod.setQuantity(prod.getQuantity() + quantity);

				productRepo.save(prod);*/

				CartDetail cartDetail = cartEntity.get();

				cartDetail.setQuantity(cartItem.getQuantity());
				cartDetail.setModifiedOn(CURRENT_TIME);
				cartDetail.setPrice(cartItem.getPrice());

				cartRepo.save(cartDetail);

				res.setMessage("success");
				res.setErrorCode("0000");
			}

		} catch (Exception px) {

			res.setMessage(px.getMessage());
			res.setErrorCode("E001");
		}
		return res;
	}

}
