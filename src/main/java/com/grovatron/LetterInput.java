package com.grovatron;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.grovatron.validation.ValidLetter;
import com.grovatron.validation.ValidModifier;

import lombok.Data;

@Data
public class LetterInput {

	@NotBlank
	@ValidLetter
	private String letter;
	@NotNull
	private Integer value;
	@NotNull
	@ValidModifier
	private String modifier;
	
}
