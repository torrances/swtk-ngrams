package org.swtk.ngrams.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NgramsIocContainer {

	static ApplicationContext _applicationContext;

	public static final String CONTEXTS = "classpath:config/ngrams-app-config.xml";

	static {
		_applicationContext = new ClassPathXmlApplicationContext(CONTEXTS);
	}

	public static ApplicationContext getContext() {
		return _applicationContext;
	}
}
