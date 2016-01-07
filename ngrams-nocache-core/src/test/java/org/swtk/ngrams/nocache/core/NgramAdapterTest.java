package org.swtk.ngrams.nocache.core;

import org.junit.Test;
import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.dto.adapter.NgramAdapter;
import org.swtk.ngrams.nocache.core.type.GramLevel;

import static org.junit.Assert.*;

public final class NgramAdapterTest {

	@Test
	public void transform() throws Throwable {

		Ngram ngram = NgramAdapter.transform("quick", "brown", "fox");
		assertNotNull(ngram);
		assertEquals(ngram.getGramLevel(), GramLevel.TRIGRAM);
		assertEquals(3, ngram.getGrams().length);
		assertEquals("quick brown fox", NgramAdapter.toString(ngram));
	}
}
