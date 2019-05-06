package com.ecotage.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@Table(name="productdetail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="prod_det_id")
	private Long productDetailId;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private String specificaton;
	private Date createdOn;
	private Date modifiedOn;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prod_id")
	@JsonBackReference
    private Product product;

	
	
	public ProductDetail() {
		
	}
	public ProductDetail(String description, String specificaton, Date createdOn, Date modifiedOn, Product product) {
		super();
		this.description = description;
		this.specificaton = specificaton;
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


	public Long getProductDetailId() {
		return productDetailId;
	}


	public String getDescription() {
		return description;
	}


	public String getSpecificaton() {
		return specificaton;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


//	public Product getProduct() {
//		return product;
//	}


	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setSpecificaton(String specificaton) {
		this.specificaton = specificaton;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


//	public void setProduct(Product product) {
//		this.product = product;
//	}


		
}
