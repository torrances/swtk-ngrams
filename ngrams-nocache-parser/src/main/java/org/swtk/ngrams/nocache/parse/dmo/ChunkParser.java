package org.swtk.ngrams.nocache.parse.dmo;

import java.util.ArrayList;
import java.util.List;

import org.swtk.ngrams.nocache.core.dto.Ngrams;
import org.swtk.ngrams.nocache.core.dto.adapter.NgramAdapter;
import org.swtk.ngrams.nocache.core.type.GramLevel;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;

public class ChunkParser {

	public static LogManager logger = new LogManager(ChunkParser.class);

	public Ngrams parse(String[] tokens, GramLevel gramLevel) throws BusinessException {
		Ngrams ngrams = new Ngrams();

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < tokens.length; i++) {
			list.add(tokens[i]);

			if (list.size() >= gramLevel.level()) {
				ngrams.add(NgramAdapter.transform(list));
				list = new ArrayList<String>();

				if (gramLevel.level() > 1) i -= gramLevel.level() - 1;
			}
		}

		return ngrams;
	}
}
