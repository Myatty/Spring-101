
package com.jdc.spring.di;

public class MyClient {

	private MyService service;
	private String name;
	
	public void showMessage() {
		System.out.printf("%s -> %s%n", name , service.message());
	}

	public MyClient() {

	}

	public void setMyService(MyService service) {
		this.service = service;
	}

	public MyClient(MyService service) {
		super();
		this.service = service;
	}
}
