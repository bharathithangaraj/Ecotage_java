package com.ecotage.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="image")
public class Image {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long imageId;
	@Column(nullable=false)
	private String imageUrl;
	private String imageType;
	@Column(nullable=false)
	private int status;
	@Column(nullable=false)
	private Date createdOn;
	@Column(nullable=false)
	private Date modifiedOn;
	private String imageSource;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prod_id")
	private Product product;
	
	public Image() {
		
	}
	
	public Image(String imageUrl, String imageType, int status, Date createdOn, Date modifiedOn,Product product) {
		super();
		this.imageUrl = imageUrl;
		this.imageType = imageType;
		this.status = status;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.product = product;
	}
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	
	
	
		
}
