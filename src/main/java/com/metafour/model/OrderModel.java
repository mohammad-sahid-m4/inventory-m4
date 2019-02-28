package com.metafour.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.metafour.validation.availabeQuantity;
import com.metafour.validation.uniqueType;

import lombok.Data;

@availabeQuantity
@Data
public class OrderModel {
	private String id;
	@NotEmpty
	private String productName;
	@NotEmpty
	@uniqueType
	private String orderType;
	@Min(value = 1, message = "Quantity must be greater than 0")
	private int productQuantity;
	@Min(value = 1, message = "Price must be greater than 0")
	private int productPrice;
	private int totalPrice;
	
	
	
	public OrderModel(@NotEmpty String productName, @NotEmpty String orderType,
			@Min(value = 1, message = "Quantity must be greater than 0") int productQuantity,
			@Min(value = 1, message = "Price must be greater than 0") int productPrice, int totalPrice) {
		super();
		this.productName = productName;
		this.orderType = orderType;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
	}
	public OrderModel() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
