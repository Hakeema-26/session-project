package com.batch2.onlineshopping.dto;

public class ProductsDTO {

	private String name;
	private String category;
	private String brand;
	private String description;
	private int cost;
	private int quantity;

	public ProductsDTO(String name, String category, String brand, String description, int cost, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

	public ProductsDTO() {
		super();
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

	@Override
	public String toString() {
		return "ProductsDTO [name=" + name + ", category=" + category + ", brand=" + brand + ", description="
				+ description + ", cost=" + cost + ", quantity=" + quantity + "]";
	}

}
