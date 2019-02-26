package com.metafour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class validPriceImpl implements ConstraintValidator<validPrice,Integer>{

	private int min;
	@Override
	public void initialize(validPrice constraintAnnotation) {
		min=constraintAnnotation.min();
	}
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value>=min) {
			return true;
		}
		return false;
	}

}
