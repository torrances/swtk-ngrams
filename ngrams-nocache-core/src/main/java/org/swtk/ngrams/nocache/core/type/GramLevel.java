package org.swtk.ngrams.nocache.core.type;

public enum GramLevel {

	BIGRAM(2), TRIGRAM(3), UNIGRAM(1);

	public static GramLevel find(int level) {
		for (GramLevel value : GramLevel.values())
			if (value.level() == level)
				return value;
		return null;
	}

	private int level;

	private GramLevel(int level) {
		this.level = level;
	}

	public int level() {
		return this.level;
	}
}
