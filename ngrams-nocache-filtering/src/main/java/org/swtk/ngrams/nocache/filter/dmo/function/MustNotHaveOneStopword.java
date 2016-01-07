package org.swtk.ngrams.nocache.filter.dmo.function;

import java.util.Iterator;

import org.swtk.common.framework.type.LanguageTag;
import org.swtk.commons.dict.stopwords.StopwordsDb;
import org.swtk.ngrams.nocache.core.dto.Gram;
import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.dto.Ngrams;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;

public final class MustNotHaveOneStopword {

	public static LogManager logger = new LogManager(MustNotHaveOneStopword.class);

	public static Ngrams filter(Ngrams ngrams, LanguageTag languageTag) throws BusinessException {
		Ngrams _filtered = new Ngrams(languageTag);

		Iterator<Ngram> iter = ngrams.iterator();
		while (iter.hasNext()) {
			Ngram ngram = iter.next();

			if (hasStopword(ngram, languageTag)) continue;
			_filtered.add(ngram);
		}

		return _filtered;
	}

	private static boolean hasStopword(Ngram ngram, LanguageTag languageTag) throws BusinessException {
		for (Gram gram : ngram.getGrams())
			if (StopwordsDb.isStopword(gram.getToken(), languageTag)) return true;

		return false;
	}
}
