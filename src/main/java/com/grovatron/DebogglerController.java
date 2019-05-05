package com.grovatron;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grovatron.deboggler.Word;

@RestController
public class DebogglerController {

	@Autowired
	private DebogglerFormService debogglerFormService;
	
	@GetMapping("/words")
	List<Word> getWordList(@Valid @RequestBody DebogglerForm debogglerForm) {
		return debogglerFormService.getWordList(debogglerForm);
	}
}
