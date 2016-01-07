package org.swtk.ngrams.nocache.filter.util;

import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.filter.dmo.NgramsPipeline;
import org.swtk.ngrams.nocache.filter.dto.GramClassification;
import org.swtk.ngrams.nocache.filter.dto.LogicalOperator;

import com.trimc.blogger.commons.exception.BusinessException;

public final class NgramPipelineHelper {

	public static Ngrams noStopwordsOrPunctuation(Ngrams ngrams) throws BusinessException {
		return new NgramsPipeline(ngrams)

		.filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.PUNCTUATION)

		.filter(LogicalOperator.MUST_NOT_HAVE_ONE, GramClassification.STOPWORD)

		.ngrams();
	}
}
