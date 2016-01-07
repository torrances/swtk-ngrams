package org.swtk.ngrams.nocache.parse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.core.NgramsIocContainer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.parse.dmo.DocumentParser;

public final class DocumentParserTest {

	private DocumentParser getBean() {
		return (DocumentParser) NgramsIocContainer.getContext().getBean(DocumentParser.class);
	}

	@Test
	public void test() throws Throwable {

		String input = "This is my sentence. That was it. Here goes nothing!";

		Ngrams ngrams = getBean().process(input, GramLevel.TRIGRAM, LanguageTag.ENGLISH);
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
