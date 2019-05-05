package com.grovatron.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidModifierValidator implements ConstraintValidator<ValidModifier, String> {

	private String[] validModifiers;
	
	@Override
	public void initialize(ValidModifier validModifier) {
		validModifiers = validModifier.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		for (String modifier : validModifiers) {
			if (value.equalsIgnoreCase(modifier)) {
				return true;
			}
		}
		return false;
	}

}
