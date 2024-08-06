package com.jdc.ioc;

import org.springframework.context.annotation.Bean;

public class HelloBean {

	@Bean
	public String sayHello() {
		return "Hello Bean annotation";
	}
}
