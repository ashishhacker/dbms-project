package com.sarika.silkhouse.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SuppressWarnings("deprecation")
public class Item {
	int product_id;
	//@NotEmpty(message="required")
	//private String material;
	@NotEmpty(message="required")
	String product_category;
	@NotEmpty(message="required")
	String material;
	@NotEmpty(message="required")
	String name;
	@NotEmpty(message="required")
	String product_type;
	@NotNull(message="required")
	int stock;
	@NotNull(message="required")
	int discount;
	@NotNull(message="required")
	Long price;

   public Item(){}
   public Item(String product_category,String material,String name,String product_type,int stock,int discount,Long price ) {
	this.product_category=product_category;
	this.material=material;
	this.name=name;
	this.product_type=product_type;
	this.stock=stock;
	this.discount=discount;
	this.price=price;
}

	public int getProduct_id() {
		return this.product_id;
	}

	public void setProduct_id(int productId) {
		this.product_id = productId;
	}

	public String getProduct_category() {
		return this.product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_type() {
		return this.product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public  Long getPrice() {
		return this.price;
	}

	public void setPrice( Long price) {
		this.price = price;
	}
	
	
}
