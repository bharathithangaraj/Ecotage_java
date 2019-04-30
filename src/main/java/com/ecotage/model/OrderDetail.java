package com.ecotage.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long orderId;
//	private Long productId;
	private Double total;
	private int quantity;
//	private Long offerId;
//	private Long userId;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	
	@OneToMany(mappedBy="orderDetail")
	private List<CheckoutProduct> checkoutProducts;
	

	
	public Long getOrderId() {
		return orderId;
	}
	public int getStatus() {
		return status;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
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
	public List<CheckoutProduct> getCheckoutProducts() {
		return checkoutProducts;
	}
	public void setCheckoutProducts(List<CheckoutProduct> checkoutProducts) {
		this.checkoutProducts = checkoutProducts;
	}
	
	
	
	
}
