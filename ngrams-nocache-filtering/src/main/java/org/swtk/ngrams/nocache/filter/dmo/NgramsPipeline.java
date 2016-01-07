package org.swtk.ngrams.nocache.filter.dmo;

import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.filter.dto.GramClassification;
import org.swtk.ngrams.nocache.filter.dto.LogicalOperator;

public class NgramsPipeline {

	private Ngrams modified = null;

	private Ngrams original = null;

	public NgramsPipeline(Ngrams ngrams) {
		original = ngrams;
	}
	
	public NgramsPipeline filter(LogicalOperator logicalOperator, GramClassification gramClassification) {
		return this;
	}

	public Ngrams ngrams() {
		return (null != modified) ? modified : original;
	}
}
