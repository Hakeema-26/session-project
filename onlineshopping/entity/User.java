package com.batch2.onlineshopping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String phoneNo;
	private String emailId;
	private String password;
	@Transient
	private String confirmPassword;
	private String role;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "User_Products", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Products> products;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public User(Integer id, String username, String phoneNo, String emailId, String password, String confirmPassword,
			String role, List<Products> products) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.products = products;
	}

	public User() {
		super();
	}

	public User(String username, String phoneNo, String emailId, String password, String role) {
		super();
		this.username = username;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public User(Integer id, String username, String phoneNo, String emailId, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phoneNo=" + phoneNo + ", emailId=" + emailId
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", role=" + role + ", products="
				+ products + "]";
	}

}
