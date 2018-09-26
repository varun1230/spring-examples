package org.vstech.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vstech.spring.service.MessagePrinter;

public class SpringTestMainClass {

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
	MessagePrinter printer = applicationContext.getBean("messagePrinter", MessagePrinter.class);
	
//	printer.

}
