package com.grovatron.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoringSystemValidator implements ConstraintValidator<ScoringSystem, String> {

	private String[] validScoringSystems;
	
	@Override
	public void initialize(ScoringSystem scoringSystem) {
		validScoringSystems = scoringSystem.values();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for (String scoringSystem : validScoringSystems) {
			if (value.equalsIgnoreCase(scoringSystem)) {
				return true;
			}
		}
		return false;
	}
}
