package com.grovatron;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DebogglerForm {

	@ScoringSystem
	private String scoringSystem;
	@NotNull
	@Valid
	private List<LetterInput> letterInputs;
	
}
