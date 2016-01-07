package org.swtk.ngrams.nocache.core.dto;

import org.swtk.ngrams.nocache.core.type.GramLevel;

public class Ngram {

	private GramLevel gramLevel;
	
	private Gram[] grams;

	public GramLevel getGramLevel() {
		return gramLevel;
	}

	public Gram[] getGrams() {
		return grams;
	}

	public void setGramLevel(GramLevel gramLevel) {
		this.gramLevel = gramLevel;
	}

	public void setGrams(Gram[] grams) {
		this.grams = grams;
	}
}
