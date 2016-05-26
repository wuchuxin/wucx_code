package com.mvn_pro.project.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
	
	private static final String FILE_LOCATION = "classpath:application-context.xml";
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext(FILE_LOCATION);

	public static Object getBean(String name) {
		return context.getBean(name);
	}

	public static <Bean> Bean getBean(Class<Bean> clazz) {
		return (Bean) context.getBean(clazz);
	}
}
