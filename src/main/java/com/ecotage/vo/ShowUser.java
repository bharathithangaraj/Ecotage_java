package com.ecotage.vo;

import java.util.Date;



public class ShowUser {

	private Long userId;

	private String userName;
//	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private int isActive;
	private int isEmailVerified;
	private int isGuest;
	//private Date createdOn;
	//private Date modifiedOn;
	private int userIdentity = hashCode();
	private String token =null;
	
	private ShowUserDetails showUserDetails;
	
	private ResponseMessage response;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

//	public String getPassword() {
//		return password;
//	}

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

	

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

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


	public int getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(int userIdentity) {
		this.userIdentity = userIdentity;
	}

	public ResponseMessage getResponse() {
		return response;
	}

	public void setResponse(ResponseMessage response) {
		this.response = response;
	}

	public ShowUserDetails getShowUserDetails() {
		return showUserDetails;
	}

	public void setShowUserDetails(ShowUserDetails showUserDetails) {
		this.showUserDetails = showUserDetails;
	}
	
	
}
