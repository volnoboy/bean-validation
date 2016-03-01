package com.volnoboy.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Volodymyr Volnoboy
 * @since 2/29/16 7:48 PM
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Size(min = 1)
@Constraint(validatedBy = {})
public @interface NotEmpty {

	String message() default "should not be empty";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
