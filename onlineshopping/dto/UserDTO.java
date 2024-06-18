package com.batch2.onlineshopping.dto;

public class UserDTO {

	private String username;
	private String phoneNo;
	private String emailId;
	private String password;
	private String confirmPassword;
	private String role;

	public UserDTO(String username, String phoneNo, String emailId, String password, String role,
			String confirmPassword) {
		super();
		this.username = username;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String username, String phoneNo, String emailId, String role) {
		super();
		this.username = username;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", phoneNo=" + phoneNo + ", emailId=" + emailId + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", role=" + role + "]";
	}
}
