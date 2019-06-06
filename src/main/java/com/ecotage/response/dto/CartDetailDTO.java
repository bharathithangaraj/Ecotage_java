package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;


public class CartDetailDTO {

	
	
	private Long cartId;
	private int quantity;
	private Double price;
//	private Long userId;
	private int status;
	private Date createdOn;
	private Date modifiedOn;
//	@JsonBackReference
	private ProductDTO product;
//	@JsonBackReference
	private OfferDTO offer;

	/* Request param from Client */

	private String productId;
	private String offerId;

	/* Request param from Client */


//	public Long getCartId() {
//		return cartId;
//	}
	public String getCartId() {
		return encryptFromId(cartId);
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public OfferDTO getOffer() {
		return offer;
	}
	public void setOffer(OfferDTO offer) {
		this.offer = offer;
	}
	
	
	/* Request param from Client */
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	
	/* Request param from Client */
}
