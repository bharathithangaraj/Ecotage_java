package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cancel_order")
public class CancelOrder {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cancel_order_id")
	private Long cancelOrderId;
	private Long orderId;

	private Date cancelDate;
	private String cancelReason;
	private Long userId;
	private Long productId;

	

	

	public CancelOrder(Long cancelOrderId, Long orderId, Date cancelDate, String cancelReason, Long userId,
			Long productId) {
		super();
		this.cancelOrderId = cancelOrderId;
		this.orderId = orderId;
		this.cancelDate = cancelDate;
		this.cancelReason = cancelReason;
		this.userId = userId;
		this.productId = productId;
	}

	public CancelOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	

}
