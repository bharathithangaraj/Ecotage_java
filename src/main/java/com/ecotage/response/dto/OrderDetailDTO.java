package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;
import java.util.List;

public class OrderDetailDTO {
	
	private Long orderId;
//	private Long productId;
	private Double total;
	private int quantity;
//	private Long offerId;
//	private Long userId;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	private List<CheckoutProductDTO> checkoutProducts;
	
	
	public String getOrderId() {
		return encryptFromId(orderId);
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public List<CheckoutProductDTO> getCheckoutProducts() {
		return checkoutProducts;
	}
	public void setCheckoutProducts(List<CheckoutProductDTO> checkoutProducts) {
		this.checkoutProducts = checkoutProducts;
	}
	
	
}
