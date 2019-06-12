package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.OrderDetailDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.CancelOrder;
import com.ecotage.model.CartDetail;
import com.ecotage.model.Category;
import com.ecotage.model.OrderDetail;
import com.ecotage.model.Product;
import com.ecotage.model.User;
import com.ecotage.repo.CancelOrderRepository;
import com.ecotage.repo.CartDetailRepository;
import com.ecotage.repo.CategoryRepository;
import com.ecotage.repo.OrderDetailRepository;
import com.ecotage.repo.ProductRepository;
import com.ecotage.repo.UserRepository;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.Products;
import com.ecotage.vo.ShowOrderDetails;

@Component
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	OrderDetailRepository orderRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	CancelOrderRepository cancelRepo;

	@Autowired
	CartDetailRepository cartRepo;
	
	@Autowired
	CategoryRepository cateRepo;
	
	@Override
	public ShowOrderDetails addOrders(AddOrders orderItem) throws ProductServiceException {
		//List<ShowOrderDetails> showOrders = new ArrayList<>();

		//for (AddOrders orderItem : orderList) {
		
		ShowOrderDetails addedOrder = null;

			try {
				 addedOrder = new ShowOrderDetails();

				Optional<Product> productEntity = productRepo.findByProductId(orderItem.getProductId());

				Optional<User> userEntity = userRepo.findById(orderItem.getUserId());

				if (!productEntity.isPresent() || !userEntity.isPresent()) {
					throw new ProductServiceException("Selected User/ Product Not available");

				}
				
				if (productEntity.get().getQuantity() < orderItem.getQuantity()) {
					throw new ProductServiceException(
							"No stockes available for the selected Quantity :" + productEntity.get().getQuantity());
				}
				
				Product prod = productEntity.get();
				prod.setModifiedOn(CURRENT_TIME);
				prod.setQuantity(prod.getQuantity() - orderItem.getQuantity());

				productRepo.save(prod);

				OrderDetail orderEntity = new OrderDetail(orderItem.getProductId(), orderItem.getTotal(),
						orderItem.getQuantity(), orderItem.getOfferId(), orderItem.getUserId(), orderItem.getStatus(),
						CURRENT_TIME, CURRENT_TIME);

				OrderDetail newOrder = orderRepo.save(orderEntity);
				
				addedOrder.setOfferId(newOrder.getOfferId());
				addedOrder.setOrderId(newOrder.getOrderId());
				
				addedOrder.setProductId(newOrder.getProductId());
				addedOrder.setQuantity(newOrder.getQuantity());
				addedOrder.setTotal(newOrder.getTotal());
				addedOrder.setUserId(newOrder.getUserId());
				
				
				Optional<Product> newProduct = productRepo.findByProductId(newOrder.getProductId());

				if (newProduct.isPresent()) {
					Products product = new Products();
					product.setNavigageTo(newProduct.get().getNavigageTo());
					product.setProductName(newProduct.get().getProductName());
					product.setTitle(newProduct.get().getTitle());
					product.setImageUrl(newProduct.get().getImageUrl());
					product.setQuantity(newProduct.get().getQuantity());
					product.setPrice(newProduct.get().getPrice());
					addedOrder.setImageUrl(newProduct.get().getImageUrl());
					
					Optional<Category> category = cateRepo.findById(newProduct.get().getCategoryId());
					
					if(category.isPresent()) {
						addedOrder.setCategoryName(category.get().getCategoryName());
					}
					
					addedOrder.setProduct(product);
				}
				
				//showOrders.add(addedOrder);
				
				Optional<CartDetail> cartEntity = cartRepo.findById(orderItem.getCartId());
				
				cartRepo.delete(cartEntity.get());

			} catch (Exception e) {
				
			}
		//}
		return addedOrder;

	}

	/*@Override
	public List<ShowOrderDetails> addOrders(LinkedList<AddOrders> orderList) throws ProductServiceException {
		List<ShowOrderDetails> showOrders = new ArrayList<>();

		for (AddOrders orderItem : orderList) {

			try {
				ShowOrderDetails addedOrder = new ShowOrderDetails();

				Optional<Product> productEntity = productRepo.findByProductId(orderItem.getProductId());

				Optional<User> userEntity = userRepo.findById(orderItem.getUserId());

				if (!productEntity.isPresent() || !userEntity.isPresent()) {
					throw new ProductServiceException("Selected User/ Product Not available");

				}
				
				if (productEntity.get().getQuantity() < orderItem.getQuantity()) {
					throw new ProductServiceException(
							"No stockes available for the selected Quantity :" + productEntity.get().getQuantity());
				}
				
				Product prod = productEntity.get();
				prod.setModifiedOn(CURRENT_TIME);
				prod.setQuantity(prod.getQuantity() - orderItem.getQuantity());

				productRepo.save(prod);

				OrderDetail orderEntity = new OrderDetail(orderItem.getProductId(), orderItem.getTotal(),
						orderItem.getQuantity(), orderItem.getOfferId(), orderItem.getUserId(), orderItem.getStatus(),
						CURRENT_TIME, CURRENT_TIME);

				OrderDetail newOrder = orderRepo.save(orderEntity);
				
				addedOrder.setOfferId(newOrder.getOfferId());
				addedOrder.setOrderId(newOrder.getOrderId());
				
				addedOrder.setProductId(newOrder.getProductId());
				addedOrder.setQuantity(newOrder.getQuantity());
				addedOrder.setTotal(newOrder.getTotal());
				addedOrder.setUserId(newOrder.getUserId());
				
				
				Optional<Product> newProduct = productRepo.findByProductId(newOrder.getProductId());

				if (newProduct.isPresent()) {
					Products product = new Products();
					product.setNavigageTo(newProduct.get().getNavigageTo());
					product.setProductName(newProduct.get().getProductName());
					product.setTitle(newProduct.get().getTitle());
					product.setImageUrl(newProduct.get().getImageUrl());
					product.setQuantity(newProduct.get().getQuantity());
					product.setPrice(newProduct.get().getPrice());
					addedOrder.setImageUrl(newProduct.get().getImageUrl());
					
					Optional<Category> category = cateRepo.findById(newProduct.get().getCategoryId());
					
					if(category.isPresent()) {
						addedOrder.setCategoryName(category.get().getCategoryName());
					}
					
					addedOrder.setProduct(product);
				}
				
				showOrders.add(addedOrder);
				
				Optional<CartDetail> cartEntity = cartRepo.findById(orderItem.getCartId());
				
				cartRepo.delete(cartEntity.get());

			} catch (Exception e) {
				
			}
		}
		return showOrders;

	}*/

	@Override
	public List<ShowOrderDetails> getOrders(Long userId) throws ProductServiceException {

		List<ShowOrderDetails> orderDetails = null;

		try {
			List<OrderDetail> orderEntity = orderRepo.findByUserId(userId);

			orderDetails = new ArrayList<>();
			for (OrderDetail orderItem : orderEntity) {

				ShowOrderDetails showOrders = new ShowOrderDetails();
				showOrders.setOfferId(orderItem.getOfferId());
				showOrders.setOrderId(orderItem.getOrderId());
				
				showOrders.setProductId(orderItem.getProductId());
				showOrders.setQuantity(orderItem.getQuantity());
				showOrders.setTotal(orderItem.getTotal());
				showOrders.setUserId(orderItem.getUserId());

				Optional<Product> productEntity = productRepo.findByProductId(orderItem.getProductId());

				if (productEntity.isPresent()) {
					
					Products product = new Products();
					product.setNavigageTo(productEntity.get().getNavigageTo());
					product.setProductName(productEntity.get().getProductName());
					product.setTitle(productEntity.get().getTitle());
					product.setImageUrl(productEntity.get().getImageUrl());
					product.setQuantity(productEntity.get().getQuantity());
					product.setPrice(productEntity.get().getPrice());
					showOrders.setImageUrl(productEntity.get().getImageUrl());
					
					Optional<Category> category = cateRepo.findById(productEntity.get().getCategoryId());
					
					if(category.isPresent()) {
						showOrders.setCategoryName(category.get().getCategoryName());
					}
					
					showOrders.setProduct(product);
				}

				orderDetails.add(showOrders);

			}

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return orderDetails;

	}

	@Override
	public ResponseMessage deleteOrders(Long orderId) throws ProductServiceException {

		ResponseMessage res = new ResponseMessage();
		try {

			Optional<OrderDetail> orderEntity = orderRepo.findById(orderId);

			if (!orderEntity.isPresent()) {
				throw new ProductServiceException("Order Item Not Found , Please check");
			}

			Optional<Product> productEntity = productRepo.findByProductId(orderEntity.get().getProductId());

			if (!productEntity.isPresent()) {
				throw new ProductServiceException("Ordered Selected Product Not Found , Please check");
			}

			Product prod = productEntity.get();
			prod.setModifiedOn(CURRENT_TIME);
			prod.setQuantity(prod.getQuantity() + orderEntity.get().getQuantity());

			productRepo.save(prod);

			CancelOrder cancelEntity = new CancelOrder();
			cancelEntity.setCancelDate(CURRENT_TIME);
			cancelEntity.setCancelReason("Not Intrested");
			cancelEntity.setProductId(orderEntity.get().getProductId());
			cancelEntity.setUserId(orderEntity.get().getUserId());
			cancelEntity.setOrderId(orderId);

			cancelRepo.save(cancelEntity);

			OrderDetail deleteOrder = orderEntity.get();

			orderRepo.delete(deleteOrder);

			res.setMessage("success");
			res.setErrorCode("0000");

		} catch (Exception ex) {
			ex.printStackTrace();
			res.setMessage(ex.getMessage());
			res.setErrorCode("E001");
		}
		return res;

	}

}
