package org.swtk.ngrams.nocache.filter.dmo.function;

import java.util.Iterator;

import org.swtk.ngrams.nocache.core.dto.Gram;
import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.dto.Ngrams;

import com.trimc.blogger.commons.exception.BusinessException;

public final class MustNotHaveOneStopword {

	public static Ngrams filter(Ngrams ngrams) throws BusinessException {
		Ngrams _filtered = new Ngrams();

		Iterator<Ngram> iter = ngrams.iterator();
		while (iter.hasNext()) {
			
			Ngram ngram = iter.next();
			for (Gram gram : ngram.getGrams()) {
			
				
			}
		}

		return _filtered;
	}
}
