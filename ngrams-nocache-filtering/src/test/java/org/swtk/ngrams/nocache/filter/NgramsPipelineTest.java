package org.swtk.ngrams.nocache.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.dto.adapter.NgramAdapter;
import org.swtk.ngrams.nocache.filter.dmo.NgramsPipeline;
import org.swtk.ngrams.nocache.filter.dto.GramClassification;
import org.swtk.ngrams.nocache.filter.dto.LogicalOperator;

public final class NgramsPipelineTest {

	@Test
	public void mustNotHaveOneStopword() throws Throwable {

		Ngrams ngrams = new NgramsPipeline(ngrams())

		.filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.STOPWORD).ngrams();

		assertNotNull(ngrams);

		/*
		 * 	quick brown fox	
		 * 	brown fox jumped
		 * 	lazy dog !
		 */
		assertEquals(3, ngrams.size());
	}

	@Test
	public void mustNotHaveOneStopwordOrPunctuation() throws Throwable {

		Ngrams ngrams = new NgramsPipeline(ngrams())

		.filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.STOPWORD)

		.filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.PUNCTUATION).ngrams();

		assertNotNull(ngrams);

		/*
		 * 	quick brown fox	
		 * 	brown fox jumped
		 */
		assertEquals(2, ngrams.size());
	}

	private Ngrams ngrams() throws Throwable {
		Ngrams ngrams = new Ngrams(LanguageTag.ENGLISH);

		ngrams.add(NgramAdapter.transform("the", "quick", "brown"));
		ngrams.add(NgramAdapter.transform("quick", "brown", "fox"));
		ngrams.add(NgramAdapter.transform("brown", "fox", "jumped"));
		ngrams.add(NgramAdapter.transform("fox", "jumped", "over"));
		ngrams.add(NgramAdapter.transform("jumped", "over", "the"));
		ngrams.add(NgramAdapter.transform("over", "the", "lazy"));
		ngrams.add(NgramAdapter.transform("the", "lazy", "dog"));
		ngrams.add(NgramAdapter.transform("lazy", "dog", "!"));

		return ngrams;
	}
}
