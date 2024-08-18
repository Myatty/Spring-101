package com.jdc.online.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Scope("prototype")
@Component
public class InitializableBean implements InitializingBean, DisposableBean{

	@PostConstruct
	private void postConstruct() {
		System.out.println("Post Construct");
	}
	
	
	@PreDestroy
	private void preDestroy() {
		System.out.println("Pre Destroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After properties set");
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy");
	}

	public void init() {
		System.out.println("Init method");
	}
	
	public void cleanUp() {
		System.out.println("Cleanup method");
	}

	
}
