package org.swtk.ngrams.nocache.parse.svc;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.swtk.common.framework.type.LanguageTag;
import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.type.GramLevel;
import org.swtk.ngrams.nocache.parse.dmo.ChunkParser;
import org.swtk.ngrams.nocache.parse.dmo.DocumentParser;

import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;

@Lazy
@Service
public class GenerateNgrams {

	@Autowired
	private ChunkParser chunkParser;

	@Autowired
	private DocumentParser documentParser;

	public Ngrams process(File file, Codepage codepage, GramLevel gramLevel, LanguageTag languageTag) throws BusinessException {
		return documentParser.process(file, codepage, gramLevel, languageTag);
	}

	public Ngrams process(String document, GramLevel gramLevel, LanguageTag languageTag) throws BusinessException {
		return documentParser.process(document, gramLevel, languageTag);
	}

	public Ngrams process(String[] tokens, GramLevel gramLevel, LanguageTag languageTag) throws BusinessException {
		return chunkParser.parse(tokens, gramLevel, languageTag);
	}
}
