package com.grovatron;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.grovatron.deboggler.Deboggler;
import com.grovatron.deboggler.HashMapWordSet;
import com.grovatron.deboggler.Letter;
import com.grovatron.deboggler.Modifier;
import com.grovatron.deboggler.OriginalPointCalculator;
import com.grovatron.deboggler.ValueModifier;
import com.grovatron.deboggler.WithFriendsPointCalculator;
import com.grovatron.deboggler.Word;
import com.grovatron.deboggler.WordConstructor;
import com.grovatron.deboggler.WordPointCalculator;
import com.grovatron.deboggler.WordSet;
import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.DictionaryConstructor;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

@Service
public class DebogglerServiceImplementation implements DebogglerService {

	private Dictionary dictionary;
	
	public DebogglerServiceImplementation() throws IOException {
		DictionaryConstructor constructor = new TrieDictionaryConstructor();
		this.dictionary = constructor.buildDictionary(new ClassPathResource("sowpods.txt").getInputStream());
	}
	
	@Override
	public List<Word> getWordList(DebogglerForm debogglerForm) {
		WordPointCalculator wordPointCalculator = debogglerForm.getScoringSystem().equalsIgnoreCase("Original") ?
				new OriginalPointCalculator() : new WithFriendsPointCalculator();
		WordConstructor wordConstructor = new WordConstructor(wordPointCalculator);
		WordSet wordSet = new HashMapWordSet();
		int minLength = debogglerForm.getScoringSystem().equalsIgnoreCase("Original") ? 3 : 2;
		
		Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
		
		Letter[][] letterGrid = buildLetterGrid(debogglerForm.getLetterInputs());
		
		return deboggler.getWordList(letterGrid);
	}
	
	private Letter[][] buildLetterGrid(List<LetterInput> letterInputs) {
		int size = (int) Math.sqrt(letterInputs.size());
		Letter[][] letterGrid = new Letter[size][size];
		for (int i = 0; i < letterInputs.size(); i++) {
			int row = i / size;
			int col = i % size;
			letterGrid[row][col] = buildLetter(letterInputs.get(i));
		}
		return letterGrid;
	}
	
	private Letter buildLetter(LetterInput letterInput) {
		ValueModifier valueModifier = null;
		
		switch (letterInput.getModifier().toLowerCase()) {
			
		case "dl":
			valueModifier = new ValueModifier(Modifier.LETTER, 2);
			break;
		case "tl":
			valueModifier = new ValueModifier(Modifier.LETTER, 3);
			break;
		case "dw":
			valueModifier = new ValueModifier(Modifier.WORD, 2);
			break;
		case "tw":
			valueModifier = new ValueModifier(Modifier.WORD, 3);
		}
		
		return new Letter(letterInput.getLetter().toUpperCase(), letterInput.getValue(), valueModifier);
	}

	
}
