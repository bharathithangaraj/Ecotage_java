package com.ecotage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author bharathi.thangaraj
 *
 */
@Entity
public class Category implements Serializable {
	
	private static final long serialVersionUID = -8003246612943943723L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cat_id")
	private Long categoryId;
	@Column(nullable=false)
	private String categoryName;
	@Column(nullable=false,unique=true)
	private String categoryType;
	private String categoryDesc;
	@Column(nullable=false)
	private int status;
	@Column(nullable=false)
	private Date createdOn;
	@Column(nullable=false)
	private Date modifiedOn;
	@Column(nullable=false)
	private String navigateTo;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category", fetch=FetchType.LAZY)
	private Set<Product> productList;
	
	public Category() {
		
	}
	
	public Category(String categoryName, String categoryType, String categoryDesc, int status, Date createdOn,
			Date modifiedOn, String navigateTo) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.categoryDesc = categoryDesc;
		this.status = status;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.navigateTo = navigateTo;
		//this.productList = productList;
	}




	public Set<Product> getProductList() {
		return productList;
	}


	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	public String getCategoryDesc() {
		return categoryDesc;
	}


	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
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


	public String getNavigateTo() {
		return navigateTo;
	}


	public void setNavigateTo(String navigateTo) {
		this.navigateTo = navigateTo;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", categoryDesc=" + categoryDesc + ", status=" + status + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", navigateTo=" + navigateTo + ", productList=" + productList + "]";
	}
	
	
	

	
}
