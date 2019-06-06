package com.ecotage.vo;

public class ProductDetails {

	private Long productDetailId;
	private String description;
	private String specificaton;
	private Long productId;

	public Long getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecificaton() {
		return specificaton;
	}

	public void setSpecificaton(String specificaton) {
		this.specificaton = specificaton;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
