package com.metafour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.metafour.service.ProductService;

public class uniqueNameImpl implements ConstraintValidator<uniqueName, String> {

	boolean flag = true;
	@Autowired
	ProductService productService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!nameUnique(value))
			return false;
		else
			return true;
	}

	public boolean nameUnique(String name) {
		productService.listAllProducts().forEach(product -> {
			if (product.getProductName().equalsIgnoreCase(name)) {
				flag = false;
			}
		});
		return flag;
	}

}
