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
	private Long quantity;
	private int status;
	@Column(name="createdon")
	private Date createdOn;
	@Column(name="modifiedon")
	private Date modifiedOn;
	
	
	@OneToOne(mappedBy="product",fetch=FetchType.LAZY)
	@JoinColumn(name="product_detail_id")
	@JsonManagedReference
	private ProductDetail productDetail;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="offer_id")
	private Offer offer;
	
	@OneToMany( fetch = FetchType.LAZY)	
	@JoinColumn(name="imageId")
	private Set<Image> imageList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id") // alter the table with column name of category_id
	private Category category;
	
//	@ManyToOne(cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
//	@JoinColumn(name="cat_list_id")
//	@JsonBackReference
//	private CategoryList categoryList;

	
	public Long getProductId() {
		return productId;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
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

	public Long getQuantity() {
		return quantity;
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

//	public ProductDetail getProductDetail() {
//		return productDetail;
//	}
//
//	public Offer getOffer() {
//		return offer;
//	}
//
//	public Image getImage() {
//		return image;
//	}

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

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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
