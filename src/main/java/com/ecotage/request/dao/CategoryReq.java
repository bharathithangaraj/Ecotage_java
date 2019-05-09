package com.ecotage.request.dao;

import java.util.List;

import com.ecotage.request.dao.ImageReq;

public class CategoryReq {
	
	private String categoryDesc;
	private String categoryName;
	private String categoryType;
	private String cateUrl;
	private int cateStaus = 1;
	private String prodUrl;
	private double price;
	private String productName;
	private int quantity;
	private int prodStatus = 1;
	private String title;
	private String description;
	private String specification;
	
	private List<ImageReq> imgReqList;
	
	private List<OfferReq> offerList;
	
	
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getCateUrl() {
		return cateUrl;
	}
	public void setCateUrl(String cateUrl) {
		this.cateUrl = cateUrl;
	}
	public int getCateStaus() {
		return cateStaus;
	}
	public void setCateStaus(int cateStaus) {
		this.cateStaus = cateStaus;
	}
	public String getProdUrl() {
		return prodUrl;
	}
	public void setProdUrl(String prodUrl) {
		this.prodUrl = prodUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
