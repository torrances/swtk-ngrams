package org.swtk.ngrams.nocache.filter;

import org.junit.Test;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.dto.adapter.NgramAdapter;
import org.swtk.ngrams.nocache.filter.dmo.NgramsPipeline;
import org.swtk.ngrams.nocache.filter.dto.GramClassification;
import org.swtk.ngrams.nocache.filter.dto.LogicalOperator;

public final class NgramsPipelineTest {

	private Ngrams ngrams() throws Throwable {
		Ngrams ngrams = new Ngrams();
		
		ngrams.add(NgramAdapter.transform("the quick brown"));
		ngrams.add(NgramAdapter.transform("quick brown fox"));
		ngrams.add(NgramAdapter.transform("brown fox jumped"));
		ngrams.add(NgramAdapter.transform("fox jumped over"));
		ngrams.add(NgramAdapter.transform("jumped over the"));
		ngrams.add(NgramAdapter.transform("over the lazy"));
		ngrams.add(NgramAdapter.transform("the lazy dog"));
		ngrams.add(NgramAdapter.transform("lazy dog !"));
		
		return ngrams;
	}
	
	@Test
	public void test() throws Throwable {
		
		new NgramsPipeline(ngrams()).filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.STOPWORD);
	}
}
