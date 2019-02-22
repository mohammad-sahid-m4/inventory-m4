package com.metafour.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderModel {
	private String id;
	private String orderType;
	@NotEmpty
	private String productName;
	@NotEmpty
	private int productPrice;
	@NotEmpty
	private int productQuantity;
	
	
	public OrderModel() {}
	public OrderModel(String id, String orderType, @NotEmpty String productName, @NotEmpty int productPrice,
			@NotEmpty int productQuantity) {
		super();
		this.id = id;
		this.orderType = orderType;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
	
}
