package com.jdc.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// @AllArgsConstructor
@Component
@RequiredArgsConstructor
public class MyClient {
	
	// Dependency
	// @Autowired
	private final MyService service;
	
	public void showMessage() {
		System.out.printf(service.message());
	}
//
//	@Autowired
//	public void setService(MyService service) {
//		this.service = service;
//	}

//  bean creation using constructor
//	public MyClient(MyService service) {
//		super();
//		this.service = service;
//	}
	
	
//	@Autowired
//	public MyClient(MyService service) {
//		super();
//		this.service = service;
//	}
// If you use Constructor, you don't need @Autowired
}
