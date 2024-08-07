package com.jdc.spring.events;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextEventListenerDemo {

	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)){
			
		}
	}
}
