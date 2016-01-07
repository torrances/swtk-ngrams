package org.swtk.ngrams.nocache.core.dto.adapter;

import org.swtk.ngrams.nocache.core.dto.Gram;

import com.trimc.blogger.commons.exception.AdapterValidationException;

public final class GramAdapter {
	
	public static String toString(Gram gram) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(gram.getToken());
		
		return sb.toString();
	}

	public static Gram transform(String token) throws AdapterValidationException {
		Gram gram = new Gram();
		
		gram.setToken(token);
		
		return gram;
	}
}
