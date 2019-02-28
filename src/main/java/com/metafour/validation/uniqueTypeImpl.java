package com.metafour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.metafour.service.OrderService;

public class uniqueTypeImpl implements ConstraintValidator<uniqueType, String> {

	boolean flag = true;
	@Autowired
	OrderService orderService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (typeUnique(value))
			return true;
		else
			return false;
	}

	public boolean typeUnique(String type) {
		orderService.listAllOrders().forEach(order -> {
			System.out.println(order.getOrderType());
			if (order.getOrderType().equalsIgnoreCase(type)) {
				flag = true;
			}
			else {
				flag=false;
			}
		});
		return flag;
	}

}
