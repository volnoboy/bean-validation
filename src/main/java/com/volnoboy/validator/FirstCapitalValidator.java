package com.volnoboy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Volodymyr Volnoboy
 * @since 3/1/16 5:19 PM
 */
public class FirstCapitalValidator implements ConstraintValidator<FirstCapital, String> {

	private String value;

	@Override
	public void initialize(FirstCapital url) {
		this.value = url.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Character.isUpperCase(value.charAt(0));
	}
}
