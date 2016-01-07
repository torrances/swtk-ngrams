package org.swtk.ngrams.nocache.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.filter.util.NgramPipelineHelper;
import org.swtk.ngrams.nocache.parse.svc.GenerateNgrams;

import com.trimc.blogger.commons.exception.BusinessException;

@Lazy
@Service
public class UncachedNgramGenerator {

	@Autowired
	private GenerateNgrams generateNgrams;

	public Ngrams generateCleanModel(String document, LanguageTag languageTag) throws BusinessException {
		Ngrams model = new Ngrams(languageTag);

		for (GramLevel gramLevel : GramLevel.values()) {
			Ngrams ngrams = generateNgrams.process(document, gramLevel, languageTag);
			model.add(NgramPipelineHelper.noStopwordsOrPunctuation(ngrams));
		}

		return model;
	}
}
