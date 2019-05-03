package com.ecotage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
@Entity
//@Table(name="product")
public class Product {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long productId;
	
	@Column(name="productname")
	private String productName;
	private String title;
	@Column(name="navigageto")
	private String navigageTo;
	private Double price;
	private int quantity;
	private int status;
	@Column(name="createdon")
	private Date createdOn;
	@Column(name="modifiedon")
	private Date modifiedOn;
	
	public Product() {
		
	}
	
	
	public Product(String productName, String title, String navigageTo, Double price, int quantity, int status,
			Date createdOn, Date modifiedOn, Category category) {
		super();
		this.productName = productName;
		this.title = title;
		this.navigageTo = navigageTo;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
//		this.productDetail = productDetail;
//		this.offer = offer;
//		this.imageList = imageList;
		this.category = category;
	}


	@OneToOne(cascade=CascadeType.ALL,mappedBy="product",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private ProductDetail productDetail;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="product",fetch = FetchType.LAZY)
	private Set<Offer> offer;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="product", fetch = FetchType.LAZY)	
	private Set<Image> imageList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cat_id") // alter the table with column name of category_id
	private Category category;
	
	public Long getProductId() {
		return productId;
	}

	public Set<Image> getImageList() {
		return imageList;
	}

	public void setImageList(Set<Image> imageList) {
		this.imageList = imageList;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public String getTitle() {
		return title;
	}

	public String getNavigageTo() {
		return navigageTo;
	}

	public Double getPrice() {
		return price;
	}

	
	public int getStatus() {
		return status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNavigageTo(String navigageTo) {
		this.navigageTo = navigageTo;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	public void setStatus(int status) {
		this.status = status;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Set<Offer> getOffer() {
		return offer;
	}


	public void setOffer(Set<Offer> offer) {
		this.offer = offer;
	}

	
	
	
	
//	public void setProductDetail(ProductDetail productDetail) {
//		this.productDetail = productDetail;
//	}
//
//	public void setOffer(Offer offer) {
//		this.offer = offer;
//	}
//
//	public void setImage(Image image) {
//		this.image = image;
//	}
	


			

}
