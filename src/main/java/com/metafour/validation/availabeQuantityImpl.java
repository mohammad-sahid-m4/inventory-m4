package com.metafour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.metafour.model.OrderModel;
import com.metafour.service.ProductService;

public class availabeQuantityImpl implements ConstraintValidator<availabeQuantity,OrderModel>{

	public boolean flag=true;
	@Autowired
	ProductService productService;
	@Override
	public boolean isValid(OrderModel value, ConstraintValidatorContext context) {
		int quantity=value.getProductQuantity();
		String name=value.getProductName();
		String type=value.getOrderType();
		System.out.println(quantity+"  "+name);
		if(availableProduct(name,quantity,type)) {
			return true;
		}
		else
		return false;
	}
	
	public boolean availableProduct(String name,int quantity,String type) {
		flag=true;
		productService.listAllProducts().forEach(product -> {
			if (product.getProductName().equalsIgnoreCase(name)) {
				if(type.equalsIgnoreCase("sale")) {
					if(product.getProductQuantity()>=quantity) {
						flag=true;
					}
					else{
						flag=false;
					}
				}
			}
		});
		return flag;
	}



}
