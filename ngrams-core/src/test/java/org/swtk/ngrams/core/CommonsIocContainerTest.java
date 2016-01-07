package org.swtk.ngrams.core;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public final class CommonsIocContainerTest {

	@Test
	public void test() throws Throwable {
		assertNotNull(CommonsIocContainer.getContext());
	}
}
