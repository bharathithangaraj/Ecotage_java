package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class OfferDTO {


	
	private Long offerId;
	private String eOfferId;
	private int percentage;
	private String offerCode;
	private String offerDetail;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	@JsonBackReference
	private ProductDTO product;
	
	public String getOfferId() {
		return encryptFromId(offerId);
	}
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	public String geteOfferId() {
		return eOfferId;
	}
	public void seteOfferId(String eOfferId) {
		this.eOfferId = eOfferId;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public String getOfferDetail() {
		return offerDetail;
	}
	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
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
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	
}
