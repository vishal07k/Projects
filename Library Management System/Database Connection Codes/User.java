package com.itep.library;

import java.util.Random;

public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userDob;
	private String userGender;
	private String userType;
	
	
	public User( String userName, String userEmail, String userPhone, String userDob, String userGender,
			String userType, String userPassword, String userAddress) {
		super();
		this.userId = new Random().nextInt(10000);
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userDob = userDob;
		this.userGender = userGender;
		this.userType = userType;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserDob() {
		return userDob;
	}


	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	private String userPassword;
	private String userAddress;
	
	
	public User() {
		
	}

}
