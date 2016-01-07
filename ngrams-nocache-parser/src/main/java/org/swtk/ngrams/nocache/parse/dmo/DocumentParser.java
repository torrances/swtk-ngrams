package org.swtk.ngrams.nocache.parse.dmo;

import java.util.Collection;

import org.swtk.eng.preprocess.functions.CreateSentences;
import org.swtk.eng.tokenizer.text.TextTokenizer;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;

import com.trimc.blogger.commons.exception.BusinessException;

public class DocumentParser {

	public Ngrams process(String document, GramLevel gramLevel) throws BusinessException {
		Ngrams ngrams = new Ngrams();

		Collection<String> sentences = CreateSentences.process(document);
		for (String sentence : sentences) {

			String[] tokens = new TextTokenizer(sentence).tokenize().array();
			ngrams.add(new ChunkParser().parse(tokens, gramLevel));
		}

		return ngrams;
	}
}
