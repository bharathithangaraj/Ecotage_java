package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_det_id")
	private Long productDetailId;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String specificaton;
	private Date createdOn;
	private Date modifiedOn;
	private Long productId;

	public ProductDetail() {

	}
	
	

	public ProductDetail(Long productDetailId, String description, String specificaton, Date createdOn, Date modifiedOn,
			Long productId) {
		super();
		this.productDetailId = productDetailId;
		this.description = description;
		this.specificaton = specificaton;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.productId = productId;
	}



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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
