package com.grovatron.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.grovatron.LetterInput;

public class SquareGridValidator implements ConstraintValidator<SquareGrid, List<LetterInput>> {

	@Override
	public boolean isValid(List<LetterInput> value, ConstraintValidatorContext context) {
		double sqrt = Math.sqrt(value.size());
		int sqrtFloor = (int) sqrt;
		return sqrt - sqrtFloor < .0000001;
	}

}
