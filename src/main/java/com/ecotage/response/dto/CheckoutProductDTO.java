package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;
public class CheckoutProductDTO {

	private Long checkoutProductId;
//	private Long productId;
	private String productName;
	private String title;
	private String navigageTo;
	private String description;	
	private String specificaton;
	private Double price;
	private Long quantity;
	private int status;
	private Date checkoutDate;	
	private ProductDTO product;
	private OrderDetailDTO orderDetail;
	
	public String getCheckoutProductId() {
		return encryptFromId(checkoutProductId);
	}
	public void setCheckoutProductId(Long checkoutProductId) {
		this.checkoutProductId = checkoutProductId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNavigageTo() {
		return navigageTo;
	}
	public void setNavigageTo(String navigageTo) {
		this.navigageTo = navigageTo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecificaton() {
		return specificaton;
	}
	public void setSpecificaton(String specificaton) {
		this.specificaton = specificaton;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public OrderDetailDTO getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetailDTO orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
}
