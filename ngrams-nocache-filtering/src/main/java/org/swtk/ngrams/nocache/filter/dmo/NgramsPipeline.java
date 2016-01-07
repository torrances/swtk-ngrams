package org.swtk.ngrams.nocache.filter.dmo;

import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.filter.dmo.function.MustNotHaveOnePunctuation;
import org.swtk.ngrams.nocache.filter.dmo.function.MustNotHaveOneStopword;
import org.swtk.ngrams.nocache.filter.dto.GramClassification;
import org.swtk.ngrams.nocache.filter.dto.LogicalOperator;

import com.trimc.blogger.commons.exception.BusinessException;

public class NgramsPipeline {

	private LanguageTag languageTag;

	private Ngrams modified = null;

	private Ngrams original = null;

	public NgramsPipeline(Ngrams ngrams, LanguageTag languageTag) {
		this.original = ngrams;
		this.languageTag = languageTag;
	}

	public NgramsPipeline filter(LogicalOperator logicalOperator, GramClassification gramClassification) throws BusinessException {

		if (LogicalOperator.MUST_NOT_HAVE_ONE == logicalOperator && GramClassification.STOPWORD == gramClassification) {
			this.modified = MustNotHaveOneStopword.filter(ngrams(), this.languageTag);
		} else if (LogicalOperator.MUST_NOT_HAVE_ONE == logicalOperator && GramClassification.PUNCTUATION == gramClassification) {
			this.modified = MustNotHaveOnePunctuation.filter(ngrams(), this.languageTag);
		} else {
			throw new BusinessException("No Filter Defined (logical-operator = %s, gram-classification = %s)", logicalOperator, gramClassification);
		}

		return this;
	}

	public Ngrams ngrams() {
		return (null != modified) ? modified : original;
	}
}
