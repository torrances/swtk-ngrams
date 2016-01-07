package org.swtk.ngrams.nocache.parse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.eng.tokenizer.text.TextTokenizer;
import org.swtk.ngrams.core.NgramsIocContainer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.parse.dmo.ChunkParser;

public final class ChunkParserTest {

	@Test
	public void bigrams() throws Throwable {
		String input = "The quick brown fox jumped over the lazy dog today.";
		String[] tokens = new TextTokenizer(input).tokenize().array();
		Ngrams ngrams = getBean().parse(tokens, GramLevel.BIGRAM, LanguageTag.ENGLISH);

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

	private ChunkParser getBean() {
		return (ChunkParser) NgramsIocContainer.getContext().getBean(ChunkParser.class);
	}

	@Test
	public void trigrams() throws Throwable {
		String input = "The quick brown fox jumped over the lazy dog today.";
		String[] tokens = new TextTokenizer(input).tokenize().array();
		Ngrams ngrams = getBean().parse(tokens, GramLevel.TRIGRAM, LanguageTag.ENGLISH);

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
		Ngrams ngrams = getBean().parse(tokens, GramLevel.UNIGRAM, LanguageTag.ENGLISH);

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
