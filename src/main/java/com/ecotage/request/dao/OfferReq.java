package com.ecotage.request.dao;

public class OfferReq {
	
	private int percentage;
	private String offerCode;
	private String offerDetail;
	private int offerStatus;
	
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
	public int getOfferStatus() {
		return offerStatus;
	}
	public void setOfferStatus(int offerStatus) {
		this.offerStatus = offerStatus;
	}
	
	

}
