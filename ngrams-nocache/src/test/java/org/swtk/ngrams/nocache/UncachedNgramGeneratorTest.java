package org.swtk.ngrams.nocache;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.core.NgramsIocContainer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.dto.adapter.NgramsAdapter;
import org.swtk.ngrams.nocache.svc.UncachedNgramGenerator;

public final class UncachedNgramGeneratorTest {

	private UncachedNgramGenerator getBean() {
		return (UncachedNgramGenerator) NgramsIocContainer.getContext().getBean(UncachedNgramGenerator.class);
	}

	@Test
	public void test() throws Throwable {
		String input = "In the previous exercises, you worked through problems which involved images that were relatively low in resolution, such as small image patches and small images of hand-written digits. In this section, we will develop methods which will allow us to scale up these methods to more realistic datasets that have larger images. ";
		Ngrams ngrams = getBean().generateCleanModel(input, LanguageTag.ENGLISH);
		assertNotNull(ngrams);
		System.err.println(NgramsAdapter.toString(ngrams));
	}
}
