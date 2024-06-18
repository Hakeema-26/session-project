package com.batch2.onlineshopping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private String brand;
	private String description;
	private int cost;
	private int quantity;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "products")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Products() {
		super();
	}

	public Products(int id, String name, String category, String brand, String description, int cost, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

	public Products(String name, String category, String brand, String description, int cost, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand
				+ ", description=" + description + ", cost=" + cost + ", quantity=" + quantity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
