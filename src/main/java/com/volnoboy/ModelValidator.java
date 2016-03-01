package com.volnoboy;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * @author Volodymyr Volnoboy
 * @since 2/14/16 6:50 PM
 */
public class ModelValidator<T> {

	ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	Validator validator = validatorFactory.getValidator();

	private Set<ConstraintViolation<T>> violations;

	public void  validateModel(T t) {
		violations = validator.validate(t);
	}

	public Set<ConstraintViolation<T>> getViolations() {
		violations.forEach(violation -> System.out.println(violation.getRootBeanClass().getSimpleName().concat(".")
				+ violation.getPropertyPath().toString().concat(" is '")
				+ violation.getInvalidValue().toString().concat("': ")
				+ violation.getMessage().concat(" ")));
		return violations;
	}

	public void closeValidator() {
		validatorFactory.close();
	}
}
