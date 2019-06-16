package com.ecotage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecotage.enums.AddressType;
import com.ecotage.enums.Gender;

@Entity
@Table(name = "userDetailInfo")
public class UserDetail {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userDetailId;

	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String location;
	private String houseNo;
	private String address1;
	private String address2;
	private String mobileNo;
	private String city;
	private String State;
	private String country;
	private int pincode;
	private String landMark;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	private Boolean isPrimaryAddress;
	private Date createdOn;
	private Date modifiedOn;
	@Column(unique = true)
	private String userDetailIdentity;
	private Long userId;
	
	public UserDetail(String name, Gender gender, String location, String houseNo, String address1, String address2,
			String mobileNo, String city, String state, String country, int pincode, String landMark,
			AddressType addressType, Boolean isPrimaryAddress, Date createdOn, Date modifiedOn,
			String userDetailIdentity, Long userId) {
		super();
		this.name = name;
		this.gender = gender;
		this.location = location;
		this.houseNo = houseNo;
		this.address1 = address1;
		this.address2 = address2;
		this.mobileNo = mobileNo;
		this.city = city;
		State = state;
		this.country = country;
		this.pincode = pincode;
		this.landMark = landMark;
		this.addressType = addressType;
		this.isPrimaryAddress = isPrimaryAddress;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.userDetailIdentity = userDetailIdentity;
		this.userId = userId;
	}

	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Boolean getIsPrimaryAddress() {
		return isPrimaryAddress;
	}

	public void setIsPrimaryAddress(Boolean isPrimaryAddress) {
		this.isPrimaryAddress = isPrimaryAddress;
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

	public String getUserDetailIdentity() {
		return userDetailIdentity;
	}

	public void setUserDetailIdentity(String userDetailIdentity) {
		this.userDetailIdentity = userDetailIdentity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", name=" + name + ", gender=" + gender + ", location="
				+ location + ", houseNo=" + houseNo + ", address1=" + address1 + ", address2=" + address2
				+ ", mobileNo=" + mobileNo + ", city=" + city + ", State=" + State + ", country=" + country
				+ ", pincode=" + pincode + ", landMark=" + landMark + ", addressType=" + addressType
				+ ", isPrimaryAddress=" + isPrimaryAddress + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", userDetailIdentity=" + userDetailIdentity + ", userId=" + userId + "]";
	}
	
	
}