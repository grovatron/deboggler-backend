package com.grovatron;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grovatron.deboggler.Word;
import com.grovatron.deboggler.dictionary.Dictionary;

@Service
public class DebogglerServiceImplementation implements DebogglerService {

	private Dictionary dictionary;
	
	public DebogglerServiceImplementation() {
		
	}
	
	@Override
	public List<Word> getWordList(DebogglerForm debogglerForm) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
