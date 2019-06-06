package com.ecotage.vo;

public class ShowUser {

	private Long userId;
	private String firstName;
	private String mobileNumber;
	private String email;
	private int isActive;
	private int isEmailVerified;
	private int isGuest;
	private String loginId;

	private ResponseMessage response;
	
	public ResponseMessage getResponse() {
		return response;
	}

	public void setResponse(ResponseMessage response) {
		this.response = response;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(int isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public int getIsGuest() {
		return isGuest;
	}

	public void setIsGuest(int isGuest) {
		this.isGuest = isGuest;
	}

}
