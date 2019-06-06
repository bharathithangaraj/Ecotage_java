package com.ecotage.response.dto;

import static com.ecotage.util.CommonUtil.encryptFromId;

import java.util.Date;

public class UserDetailDTO {

	private Long userDetailId;
	private String name;
	private String gender;
	private String location;
	private String houseNo;
	private String address1;
	private String address2;
	private String mobileNo;
	private String city;
	private String State;
	private int pincode;
	private String landMark;
	private String addressType;
	private Boolean isPrimaryAddress;
	private Date createdOn;
	private Date modifiedOn;

	private UserDTO user;

	public String getUserDetailId() {
		return encryptFromId(userDetailId);
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getLocation() {
		return location;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return State;
	}

	public int getPincode() {
		return pincode;
	}

	public String getLandMark() {
		return landMark;
	}

	public String getAddressType() {
		return addressType;
	}

	public Boolean getIsPrimaryAddress() {
		return isPrimaryAddress;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		State = state;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public void setIsPrimaryAddress(Boolean isPrimaryAddress) {
		this.isPrimaryAddress = isPrimaryAddress;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}