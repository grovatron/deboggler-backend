package com.grovatron;

import java.util.List;

import com.grovatron.deboggler.Word;

public interface DebogglerService {

	List<Word> getWordList(DebogglerForm debogglerForm);
}
