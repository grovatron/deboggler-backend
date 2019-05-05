package com.grovatron;

import javax.validation.constraints.NotNull;

import com.grovatron.validation.ValidLetter;

import lombok.Data;

@Data
public class LetterInput {

	@ValidLetter
	private String letter;
	@NotNull
	private Integer value;
	@ValidModifier
	private String modifier;
	
}
