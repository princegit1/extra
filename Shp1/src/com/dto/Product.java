package com.dto;

public class Product {
	private String name,description,image;
	private int id;
	private double unitCost,totalCost;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String description, String image, int id, double unitCost, double totalCost,
			int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.id = id;
		this.unitCost = unitCost;
		this.totalCost = totalCost;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", image=" + image + ", id=" + id
				+ ", unitCost=" + unitCost + ", totalCost=" + totalCost + ", quantity=" + quantity + "]";
	}
	
	
	

}
