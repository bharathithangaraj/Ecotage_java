package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="offer")
public class Offer {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name="offer_id")
	private Long offerId;
	private int percentage;
	private String offerCode;
	private String offerDetail;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	
	
	
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