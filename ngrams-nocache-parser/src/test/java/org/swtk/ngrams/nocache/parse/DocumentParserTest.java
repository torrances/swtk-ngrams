package org.swtk.ngrams.nocache.parse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.parse.dmo.DocumentParser;

public final class DocumentParserTest {

	@Test
	public void test() throws Throwable {

		String input = "This is my sentence. That was it. Here goes nothing!";

		Ngrams ngrams = new DocumentParser().process(input, GramLevel.TRIGRAM);
		assertNotNull(ngrams);

		/*
		 * 	This is my
		 * 	is my sentence
		 * 	my sentence .
		 * 	That was it
		 * 	was it .
		 * 	Here goes nothing
		 * 	goes nothing !
		 */

		assertEquals(7, ngrams.size());
	}
}
