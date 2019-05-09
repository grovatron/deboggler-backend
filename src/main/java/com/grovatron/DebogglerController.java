package com.grovatron;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@CrossOrigin
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	void pingServer() {
		
	}
	
}
