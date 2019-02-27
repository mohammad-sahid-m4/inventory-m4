package com.metafour.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.metafour.validation.availabeQuantity;

import lombok.Data;

@availabeQuantity
@Data
public class OrderModel {
	private String id;
	@NotEmpty
	private String productName;
	@NotEmpty
	private String orderType;
	@Min(value = 1, message = "Quantity must be greater than 0")
	private int productQuantity;
	@Min(value = 1, message = "Price must be greater than 0")
	private int productPrice;
	private int totalPrice;

}
