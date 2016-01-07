package org.swtk.ngrams.nocache.core.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Ngrams {

	private Collection<Ngram> list;

	public void add(Ngram... ngrams) {
		for (Ngram ngram : ngrams)
			getList().add(ngram);
	}

	public void add(Ngrams ngrams) {
		getList().addAll(ngrams.getList());
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

	private void setList(Collection<Ngram> list) {
		this.list = list;
	}

	public int size() {
		return getList().size();
	}
}
