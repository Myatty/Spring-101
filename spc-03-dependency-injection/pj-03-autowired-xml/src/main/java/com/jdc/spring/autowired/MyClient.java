package com.jdc.spring.autowired;

public class MyClient {
	
	// Dependency
	private MyService service;
	
	public void showMessage() {
		System.out.printf(service.message());
	}

	public void setService(MyService service) {
		this.service = service;
	}

//  bean creation using constructor
//	public MyClient(MyService service) {
//		super();
//		this.service = service;
//	}
}
