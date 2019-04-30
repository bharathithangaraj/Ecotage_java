package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartDetail {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long cartId;
	private int quantity;
	private Double price;
//	private Long userId;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="offer_id")
	private Offer offer;
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Long getCartId() {
		return cartId;
	}

//	private Long userId;
	
	
	public int getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
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

//	public Product getProduct() {
//		return product;
//	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
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

//	public void setProduct(Product product) {
//		this.product = product;
//	}
	
		
}
