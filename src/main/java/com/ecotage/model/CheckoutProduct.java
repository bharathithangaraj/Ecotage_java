package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CheckoutProduct {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long checkoutProductId;
//	private Long productId;
	private String productName;
	private String title;
	private String navigageTo;
	private String description;	
	private String specificaton;
	private Double price;
	private Long quantity;
	private int status;
	private Date checkoutDate;	
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private OrderDetail orderDetail;
	
	/*
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id") // alter the table with column name of category_id
	private Category category;
	*/
	
	public Long getCheckoutProductId() {
		return checkoutProductId;
	}

	public void setCheckoutProductId(Long checkoutProductId) {
		this.checkoutProductId = checkoutProductId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	


	
	
	
	
}
