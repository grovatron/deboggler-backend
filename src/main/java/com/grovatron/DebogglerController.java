package com.grovatron;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grovatron.deboggler.Word;

@RestController
public class DebogglerController {

	@Autowired
	private DebogglerService debogglerFormService;
	
	@CrossOrigin
	@PostMapping("/words")
	List<Word> getWordList(@Valid @RequestBody DebogglerForm debogglerForm) {
		return debogglerFormService.getWordList(debogglerForm);
	}
}
