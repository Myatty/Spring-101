package com.jdc.online.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import com.jdc.online.spring.beans.InitializableBean;

public class InitAndDestroy {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.online.spring")){
			
			var bean = context.getBean(InitializableBean.class);
			assertNotNull(bean);
		}
	}
}
