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
	
	@Column(name="categoryname")
	private String categoryName;
	@Column(name="categorytype")
	private String categoryType;
	@Column(name="categorydesc")
	private String categoryDesc;
	@Column(name="status")
	private int status;
	@Column(name="createdon")
	private Date createdOn;
	@Column(name="modifiedon")
	private Date modifiedOn;
	
	@OneToMany(mappedBy="category")
	private List<Product> productList;
	
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
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


	
}
