package com.grovatron;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.grovatron.validation.ScoringSystem;

import lombok.Data;

@Data
public class DebogglerForm {

	@ScoringSystem
	private String scoringSystem;
	@NotNull
	@Valid
	@Size(min=4, message="Must contain at least four letters ('qu' counts as one letter)")
	@SquareGrid
	private List<LetterInput> letterInputs;
	
}
