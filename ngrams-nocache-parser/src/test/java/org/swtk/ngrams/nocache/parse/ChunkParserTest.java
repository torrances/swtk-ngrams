package org.swtk.ngrams.nocache.parse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.swtk.eng.tokenizer.text.TextTokenizer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.parse.dmo.ChunkParser;

public final class ChunkParserTest {

	@Test
	public void bigrams() throws Throwable {
		String input = "The quick brown fox jumped over the lazy dog today.";
		String[] tokens = new TextTokenizer(input).tokenize().array();
		Ngrams ngrams = new ChunkParser().parse(tokens, GramLevel.BIGRAM);

		/*
		 * 	The quick
		 * 	quick brown
		 * 	brown fox
		 * 	fox jumped
		 * 	jumped over
		 * 	over the
		 * 	the lazy
		 * 	lazy dog
		 * 	dog today
		 * 	today .
		 */
		assertEquals(10, ngrams.size());
	}

	@Test
	public void trigrams() throws Throwable {
		String input = "The quick brown fox jumped over the lazy dog today.";
		String[] tokens = new TextTokenizer(input).tokenize().array();
		Ngrams ngrams = new ChunkParser().parse(tokens, GramLevel.TRIGRAM);

		/*
		 * 	The quick brown
		 * 	quick brown fox
		 * 	brown fox jumped
		 * 	fox jumped over
		 * 	jumped over the	
		 * 	over the lazy
		 * 	the lazy dog
		 * 	lazy dog today
		 * 	dog today .
		 */
		assertEquals(9, ngrams.size());
	}

	@Test
	public void unigrams() throws Throwable {
		String input = "The quick brown fox jumped over the lazy dog today.";
		String[] tokens = new TextTokenizer(input).tokenize().array();
		Ngrams ngrams = new ChunkParser().parse(tokens, GramLevel.UNIGRAM);

		/*
		 * 	The
		 * 	quick
		 * 	brown
		 * 	fox
		 * 	jumped
		 * 	over
		 * 	the
		 * 	lazy
		 * 	dog
		 * 	today
		 * 	.
		 */
		assertEquals(11, ngrams.size());
	}
}
