package com.jdc.spring.processors;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.jdc.spring.beans.MyBean;

@Component
public class MyBeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		
		if(bean instanceof MyBean myBean) {
			myBean.setValue("Hello bean post processor");
		}
		
		return bean;
	}
}
