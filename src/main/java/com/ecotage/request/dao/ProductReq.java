package com.ecotage.request.dao;

import java.util.List;

public class ProductReq {
	
	private String productName;
	private String navigageTo;
	private Double price;
	private int quantity;
	private int status;
	private String categoryType;
	private String prodUrl;
	private int prodStatus = 1;
	private String title;
	private String description;
	private String specification;
	
	private List<ImageReq> imgReqList;
	
	private List<OfferReq> offerList;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getNavigageTo() {
		return navigageTo;
	}
	public void setNavigageTo(String navigageTo) {
		this.navigageTo = navigageTo;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getProdUrl() {
		return prodUrl;
	}
	public void setProdUrl(String prodUrl) {
		this.prodUrl = prodUrl;
	}
	public int getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(int prodStatus) {
		this.prodStatus = prodStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public List<ImageReq> getImgReqList() {
		return imgReqList;
	}
	public void setImgReqList(List<ImageReq> imgReqList) {
		this.imgReqList = imgReqList;
	}
	public List<OfferReq> getOfferList() {
		return offerList;
	}
	public void setOfferList(List<OfferReq> offerList) {
		this.offerList = offerList;
	}
	
	
	
	

}
