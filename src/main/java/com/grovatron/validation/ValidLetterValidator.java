package com.grovatron.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLetterValidator implements ConstraintValidator<ValidLetter, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (containsNonAlphabeticChars(value) || (!value.equalsIgnoreCase("qu") && value.length() > 1)) {
			return false;
		}
		return true;
	}
	
	private static boolean containsNonAlphabeticChars(String value) {
		for (char character : value.toCharArray()) {
			if (!Character.isAlphabetic(character)) {
				return true;
			}
		}
		return false;
	}

}
