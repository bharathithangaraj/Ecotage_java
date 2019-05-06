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
import javax.persistence.Table;

@Entity
//@Table(name="offer")
public class Offer {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="offer_id")
	private Long offerId;
	@Column(nullable=false)
	private int percentage;
	@Column(nullable=false)
	private String offerCode;
	private String offerDetail;
	@Column(nullable=false)
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prod_id")
	private Product product;


	public Offer() {
		
	}
	
	public Offer(int percentage, String offerCode, String offerDetail, int status, Date createdOn, Date modifiedOn, Product product) {
		super();
		this.percentage = percentage;
		this.offerCode = offerCode;
		this.offerDetail = offerDetail;
		this.status = status;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getOfferId() {
		return offerId;
	}
	public int getPercentage() {
		return percentage;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public String getOfferDetail() {
		return offerDetail;
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
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
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
	
	
	
}
