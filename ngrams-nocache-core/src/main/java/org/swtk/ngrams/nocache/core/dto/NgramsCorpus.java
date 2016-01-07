package org.swtk.ngrams.nocache.core.dto;

public class NgramsCorpus {

	private Ngrams ngrams;
	
	private long totalDocuments;
	
	private long totalNgrams;

	public Ngrams getNgrams() {
		return ngrams;
	}

	public long getTotalDocuments() {
		return totalDocuments;
	}

	public long getTotalNgrams() {
		return totalNgrams;
	}

	public void setNgrams(Ngrams ngrams) {
		this.ngrams = ngrams;
	}

	public void setTotalDocuments(long totalDocuments) {
		this.totalDocuments = totalDocuments;
	}

	public void setTotalNgrams(long totalNgrams) {
		this.totalNgrams = totalNgrams;
	}
}
