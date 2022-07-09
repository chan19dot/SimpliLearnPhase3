package com.sportyshoes.webproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdetails")
public class Product {
	@Id
	private int productid;
	private String category;
	private String shoename;
	private int quantity;
	private double price;
	
	public Product() {
	}

	public Product(int productid, String category, String shoename, int quantity, double price) {
		super();
		this.productid = productid;
		this.category = category;
		this.shoename = shoename;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getShoename() {
		return shoename;
	}

	public void setShoename(String shoename) {
		this.shoename = shoename;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
