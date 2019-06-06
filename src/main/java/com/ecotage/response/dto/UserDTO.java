package com.ecotage.response.dto;

import java.util.Date;

public class UserDTO {

	private Long userId;
	private String loginId;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private int isActive;
	private int isEmailVerified;
	private int isGuest;
	private Date createdOn;
	private Date modifiedOn;

	private UserDetailDTO userDetail;

	public Long getUserId() {
		return userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public int getIsActive() {
		return isActive;
	}

	public int getIsEmailVerified() {
		return isEmailVerified;
	}

	public int getIsGuest() {
		return isGuest;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public UserDetailDTO getUserDetail() {
		return userDetail;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public void setIsEmailVerified(int isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public void setIsGuest(int isGuest) {
		this.isGuest = isGuest;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setUserDetail(UserDetailDTO userDetail) {
		this.userDetail = userDetail;
	}

}
