package org.swtk.ngrams.nocache.core.dto.adapter;

import java.util.Collection;

import org.swtk.ngrams.nocache.core.dto.Gram;
import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.type.GramLevel;

import com.trimc.blogger.commons.exception.AdapterValidationException;

public final class NgramAdapter {

	public static String toString(Ngram ngram) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ngram.getGrams().length; i++) {
			sb.append(GramAdapter.toString(ngram.getGrams()[i]));
			if (i + 1 < ngram.getGrams().length) sb.append(" ");
		}

		return sb.toString();
	}

	public static Ngram transform(Collection<String> tokens) throws AdapterValidationException {
		return transform((String[]) tokens.toArray(new String[tokens.size()]));
	}

	public static Ngram transform(Gram... grams) throws AdapterValidationException {
		Ngram ngram = new Ngram();

		ngram.setGrams(grams);
		ngram.setGramLevel(GramLevel.find(grams.length));

		return ngram;
	}

	public static Ngram transform(String... tokens) throws AdapterValidationException {
		Gram[] grams = new Gram[tokens.length];
		for (int i = 0; i < tokens.length; i++)
			grams[i] = GramAdapter.transform(tokens[i]);

		return transform(grams);
	}
}
