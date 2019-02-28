package com.metafour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.metafour.model.OrderModel;
import com.metafour.service.OrderService;
import com.metafour.service.ProductService;

public class availabeQuantityImpl implements ConstraintValidator<availabeQuantity, OrderModel> {

	int prevQuantity = 0;
	public boolean flag = true;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;

	@Override
	public boolean isValid(OrderModel value, ConstraintValidatorContext context) {

		String name = value.getProductName();
		int quantity = value.getProductQuantity()+getPrevQuantity(name);
		String type = value.getOrderType();
		if (availableProduct(name, quantity, type)) {
			return true;
		} else
			return false;
	}

	public int getPrevQuantity(String name) {
		orderService.listAllOrders().forEach(ord -> {
			if (ord.getProductName().equals(name)) {
				prevQuantity = ord.getProductQuantity();
			}
		});
		return prevQuantity;
	}

	public boolean availableProduct(String name, int quantity, String type) {
		flag = true;
		productService.listAllProducts().forEach(product -> {
			if (product.getProductName().equalsIgnoreCase(name)) {
				if (type.equalsIgnoreCase("sale")) {
					if (product.getProductQuantity() >= quantity) {
						flag = true;
					} else {
						flag = false;
						prevQuantity=0;
					}
				}
			}
		});
		return flag;
	}

}
