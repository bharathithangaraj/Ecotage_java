package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ProductDetailDTO {

	private Long productDetailId;
	private String description;
	private String specificaton;
	private Date createdOn;
	private Date modifiedOn;
	@JsonBackReference
    private ProductDTO product;
    
	public String getProductDetailId() {
		return encryptFromId(productDetailId);
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
