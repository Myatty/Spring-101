package com.jdc.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClient {

	// @Autowired
	private MyService service;
	
//	@Autowired
//	public void setService(MyService service) {
//		this.service = service;
//	}
//	
	public MyClient(MyService service) {
		super();
		this.service = service;
	}

	public void showMessage() {
		System.out.println(service.getMessage());
	}
}
