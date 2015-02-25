package net.kvamstadsolutions.urbandict.advanced.backend;

import net.kvamstadsolutions.urbandict.advanced.backend.urbandict.UrbDictRestClientUsage;
import net.kvamstadsolutions.urbandict.data.UrbanWord;

import java.util.ArrayList;
import java.util.List;


import java.util.List;


public class Backend {

	public List<UrbanWord> generateUrbanWords() {
		
		ArrayList<UrbanWord> words = new ArrayList<UrbanWord>();
		
		words.add(new UrbanWord("YOLO", "Abbreviation for: you only live once The dumbass's excuse for something stupid that they did Also one of the most annoying abbreviations ever....", "ShLuBsTeR"));
		words.add(new UrbanWord("Yolo", "\"carpe diem\" for stupid people", "ozball21"));
		words.add(new UrbanWord("Yolo", "The douchebag mating call.", "DeadTheBBQ"));
		words.add(new UrbanWord("Yolo", "YOLO', meaning You Only Live Once, is a viral quote most popularly used by prepubescent girls, but the range is undoubtedly in the teenage community.", "Wuskar"));
		words.add(new UrbanWord("Yolo", "You Obviously Lack Originality", "ispeakdatruthhhh"));
		return words;
	}

	public void lookupUrbanWords(AsyncCallback<List<UrbanWord>> callback,
			String searchTerm) {

		UrbDictRestClientUsage client = new UrbDictRestClientUsage();
		client.getLookupWord(callback, searchTerm);

	}
}
