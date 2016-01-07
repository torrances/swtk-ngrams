package org.swtk.ngrams.nocache.parse.dmo;

import java.io.File;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.eng.preprocess.functions.CreateSentences;
import org.swtk.eng.tokenizer.text.TextTokenizer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;

import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;
import com.trimc.blogger.commons.utils.file.FileUtils;

@Lazy
@Component
public class DocumentParser {

	@Autowired
	private ChunkParser chunkParser;

	public Ngrams process(File file, Codepage codepage, GramLevel gramLevel, LanguageTag languageTag) throws BusinessException {
		return process(FileUtils.toString(file, codepage), gramLevel, languageTag);
	}

	public Ngrams process(String document, GramLevel gramLevel, LanguageTag languageTag) throws BusinessException {
		Ngrams ngrams = new Ngrams(languageTag);

		Collection<String> sentences = CreateSentences.process(document);
		for (String sentence : sentences) {

			String[] tokens = new TextTokenizer(sentence).tokenize().array();
			ngrams.add(chunkParser.parse(tokens, gramLevel, languageTag));
		}

		return ngrams;
	}
}
