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

/**
 * @author Volodymyr Volnoboy
 * @since 2/29/16 8:19 PM
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Constraint(validatedBy = {URLValidator.class})
public @interface URL {

	String message() default "malformed URL";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String protocol() default "";

	String host() default "";

	int port() default -1;
}
