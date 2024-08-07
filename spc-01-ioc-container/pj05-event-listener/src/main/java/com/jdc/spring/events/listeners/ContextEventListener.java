package com.jdc.spring.events.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListener{

	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {

		System.out.println(event.getClass().getSimpleName());
	}

	 
	
}
