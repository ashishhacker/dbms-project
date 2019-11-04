package com.sarika.silkhouse.model;

public class Cart {
	String cart_id;
	int product_id; 
	int quantity;
	int total_price;
	String name;
	int price;
	int discount;

	public String getCart_id() {
		return this.cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public int getProduct_id() {
		return this.product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return this.total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}


}
