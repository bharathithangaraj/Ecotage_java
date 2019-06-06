package com.ecotage.response.dto;

import java.util.Date;

public class CancelOrderDTO {

	private Long cancelOrderId;
	private OrderDetailDTO order;
	private Date cancelDate;
	private String cancelReason;
	
	
	// to avoid the visibility in client side
	public Long getCancelOrderId() {
		return cancelOrderId;
	}
	public void setCancelOrderId(Long cancelOrderId) {
		this.cancelOrderId = cancelOrderId;
	}
	public OrderDetailDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDetailDTO order) {
		this.order = order;
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

	
}
