package org.swtk.ngrams.nocache.filter.dmo.function;

import java.util.Iterator;

import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.nocache.core.dto.Gram;
import org.swtk.ngrams.nocache.core.dto.Ngram;
import org.swtk.ngrams.nocache.core.dto.Ngrams;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.utils.TextUtils;

public final class MustNotHaveOnePunctuation {

	public static LogManager logger = new LogManager(MustNotHaveOnePunctuation.class);

	public static Ngrams filter(Ngrams ngrams, LanguageTag languageTag) throws BusinessException {
		Ngrams _filtered = new Ngrams();

		Iterator<Ngram> iter = ngrams.iterator();
		while (iter.hasNext()) {
			Ngram ngram = iter.next();

			if (hasPunctuation(ngram, languageTag)) continue;
			_filtered.add(ngram);
		}

		return _filtered;
	}

	private static boolean hasPunctuation(Ngram ngram, LanguageTag languageTag) throws BusinessException {
		for (Gram gram : ngram.getGrams())
			if (TextUtils.isPunctuation(gram.getToken())) return true;

		return false;
	}
}
