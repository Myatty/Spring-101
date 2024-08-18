package com.jdc.online.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.beans.MyService;

public class ScopeUsageDemo {

	@Test
	void demo() {
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)){
			
			var singleton1 = context.getBean("myService", MyService.class);
			var singleton2 = context.getBean("myService", MyService.class);
			
			var prototype1 = context.getBean("prototypeService", MyService.class);
			var prototype2 = context.getBean("prototypeService", MyService.class);
		
			for (var i = 0; i < 5; i++) {
			    String message = String.format("Message %d", i + 1);
			    singleton1.addMessage(message);
			    singleton2.addMessage(message);
			    prototype1.addMessage(message);
			    prototype2.addMessage(message);
			}

			
			singleton1.addMessage("Other Message");
			prototype1.addMessage("Other Message");
			
			System.out.println(singleton1.getMessages());
			System.out.println(singleton2.getMessages());
			System.out.println(prototype1.getMessages());
			System.out.println(prototype2.getMessages());
		}
	}
}
