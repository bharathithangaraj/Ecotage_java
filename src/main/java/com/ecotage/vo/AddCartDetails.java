package com.ecotage.vo;

/**
 * @author bharathi.thangaraj
 *
 */
public class AddCartDetails {

	private Long cartId;
	private int quantity;
	private Double price;
	private Long userId;
	private int status = 1;
	
	private Long productId;

	public Long getCartId() {
		return cartId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "AddCartDetails [cartId=" + cartId + ", quantity=" + quantity + ", price=" + price + ", userId=" + userId
				+ ", status=" + status + ", productId=" + productId + "]";
	}

	
}
