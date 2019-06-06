package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ProductDTO {

	private Long productId;
	private String productName;
	private String title;
	private String navigageTo;
	private Double price;
	private int quantity;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
	@JsonManagedReference
	private ProductDetailDTO productDetail;
	@JsonManagedReference
	private List<OfferDTO> offer;
	@JsonManagedReference
	private List<ImageDTO> imageList;
	@JsonBackReference
	private CategoryDTO category;

	public ProductDTO() {
		super();
	}

	public String getProductId() {
		return encryptFromId(productId);
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

	public ProductDetailDTO getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetailDTO productDetail) {
		this.productDetail = productDetail;
	}

	public List<OfferDTO> getOffer() {
		return offer;
	}

	public void setOffer(List<OfferDTO> offer) {
		this.offer = offer;
	}

	public List<ImageDTO> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageDTO> imageList) {
		this.imageList = imageList;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

}
