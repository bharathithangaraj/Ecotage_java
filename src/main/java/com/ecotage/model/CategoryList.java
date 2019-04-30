package com.ecotage.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

//@Entity
//@Table(name="categorylist")
public class CategoryList {
	
	private static final long serialVersionUID = -8003246612943943723L;
	
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name="cat_list_id")
	private Long id;
	
	private String itemName;
	private String navigateTo;
	
	private Date createdOn;
	private Date modifiedOn;
	private int status;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="cat_list_id")
//	@JsonManagedReference
	private Set<Product> product;
	
	
//	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name = "cat_id")
//	@JsonBackReference
	private Category category;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getNavigateTo() {
		return navigateTo;
	}
	public void setNavigateTo(String navigateTo) {
		this.navigateTo = navigateTo;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
