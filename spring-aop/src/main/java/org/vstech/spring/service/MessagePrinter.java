package org.vstech.spring.service;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	public void printMethod(String input) {
		System.out.println("MessagePrinter > print method >  "+input);
	}
	
}
