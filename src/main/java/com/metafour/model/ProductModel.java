package com.metafour.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ProductModel {
	private String id;
	@NotEmpty
	private String name;

	private int product_price;
	
	private int qty;
	@NotNull
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ProductModel(String id, @NotEmpty String name, int product_price,  int qty,
			@NotNull Date date) {
		super();
		this.id = id;
		this.name = name;
		this.product_price = product_price;
		this.qty = qty;
		this.date = date;
	}
	public ProductModel() {
		super();
	}
	
}
