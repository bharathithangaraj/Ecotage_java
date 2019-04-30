package com.ecotage.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CancelOrder {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cancelOrderId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private OrderDetail order;
	
	private Date cancelDate;
	private String cancelReason;
	public Long getCancelOrderId() {
		return cancelOrderId;
	}
	public void setCancelOrderId(Long cancelOrderId) {
		this.cancelOrderId = cancelOrderId;
	}
	public OrderDetail getOrder() {
		return order;
	}
	public void setOrder(OrderDetail order) {
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
