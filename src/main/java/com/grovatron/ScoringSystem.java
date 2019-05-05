package com.grovatron;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=ScoringSystemValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScoringSystem {

	public String[] values() default {"Original", "With Friends"};
	
	public String message() default "Must be a valid scoring system";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload> payload() default {};
}
