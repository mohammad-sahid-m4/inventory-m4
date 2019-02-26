package com.metafour.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderModel {
	private String id;
	@NotEmpty
	private String productName;
	@NotEmpty
	private String orderType;
	@Min(value = 1, message = "The value must be greater than 0")
	private int productQuantity;
	@Min(value = 1, message = "The value must be greater than 0")
	private int productPrice;
	private int totalPrice;

}
