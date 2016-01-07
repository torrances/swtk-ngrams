package org.swtk.ngrams.nocache.core.dto;

public class NgramCorpus {

	private Ngram ngram;
	
	/**
	 * 	Purpose:
	 * 	the total documents this ngram appears in
	 */
	private long totalDocuments;
	
	/**
	 * 	Purpose:
	 * 	the total number of times this ngram occurs
	 */
	private long totalOccurences;

	public Ngram getNgram() {
		return ngram;
	}

	public long getTotalDocuments() {
		return totalDocuments;
	}

	public long getTotalOccurences() {
		return totalOccurences;
	}

	public void setNgram(Ngram ngram) {
		this.ngram = ngram;
	}

	public void setTotalDocuments(long totalDocuments) {
		this.totalDocuments = totalDocuments;
	}

	public void setTotalOccurences(long totalOccurences) {
		this.totalOccurences = totalOccurences;
	}
}
