package com.ecotage.request.dto;

public class ImageReq {
	
	private String imageType;
	private String imageUrl;
	private int imgStatus = 1;
	
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getImgStatus() {
		return imgStatus;
	}
	public void setImgStatus(int imgStatus) {
		this.imgStatus = imgStatus;
	}
	
	

}
