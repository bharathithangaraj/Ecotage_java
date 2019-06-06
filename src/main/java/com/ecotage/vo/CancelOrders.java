package com.ecotage.vo;

import java.util.Date;

public class CancelOrders {
	
	private Long cancelOrderId;
	private Long orderId;
	private Date cancelDate;
	private String cancelReason;
	private Long userId;

	private Products product;

	public Long getCancelOrderId() {
		return cancelOrderId;
	}

	public void setCancelOrderId(Long cancelOrderId) {
		this.cancelOrderId = cancelOrderId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
