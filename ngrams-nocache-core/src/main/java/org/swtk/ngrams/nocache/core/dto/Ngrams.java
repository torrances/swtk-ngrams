package org.swtk.ngrams.nocache.core.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.swtk.common.framework.type.LanguageTag;

public class Ngrams {

	private LanguageTag languageTag;

	private Collection<Ngram> list;

	public Ngrams(LanguageTag languageTag) {
		setLanguageTag(languageTag);
	}

	public void add(Ngram... ngrams) {
		for (Ngram ngram : ngrams)
			getList().add(ngram);
	}

	public void add(Ngrams ngrams) {
		getList().addAll(ngrams.getList());
	}

	public LanguageTag getLanguageTag() {
		return languageTag;
	}

	private Collection<Ngram> getList() {
		if (null == list) setList(new ArrayList<Ngram>());
		return list;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Iterator<Ngram> iterator() {
		return getList().iterator();
	}

	private void setLanguageTag(LanguageTag languageTag) {
		this.languageTag = languageTag;
	}

	private void setList(Collection<Ngram> list) {
		this.list = list;
	}

	public int size() {
		return getList().size();
	}
}
