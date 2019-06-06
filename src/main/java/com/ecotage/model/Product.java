package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(nullable = false, unique = true)
	private String productName;
	private String title;
	@Column(nullable = false)
	private String navigageTo;
	private Double price;
	private int quantity;
	@Column(nullable = false)
	private int status;
	@Column(nullable = false)
	private Date createdOn;
	@Column(nullable = false)
	private Date modifiedOn;
	
	private String imageUrl;
	private Long categoryId;
	
	public Product() {

	}
	
	public Product(String productName, String title, String navigageTo, Double price, int quantity,
			int status, Date createdOn, Date modifiedOn, Long categoryId) {
		super();
		this.productName = productName;
		this.title = title;
		this.navigageTo = navigageTo;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.categoryId = categoryId;
	}





	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
	

}
