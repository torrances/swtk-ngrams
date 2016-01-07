package org.swtk.ngrams.nocache.core.dto.adapter;

import java.util.Iterator;

import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.dto.Ngrams;

public final class NgramsAdapter {

	public static String toString(Ngrams ngrams) {
		StringBuilder sb = new StringBuilder();

		Iterator<Ngram> iter = ngrams.iterator();
		while (iter.hasNext()) {
			sb.append(NgramAdapter.toString(iter.next()));
			if (iter.hasNext()) sb.append(System.lineSeparator());
		}

		return sb.toString();
	}
}
