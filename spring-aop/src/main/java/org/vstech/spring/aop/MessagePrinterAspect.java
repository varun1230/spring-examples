package org.vstech.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessagePrinterAspect {

	@Before("execution(* org.vstech.spring.service.MessagePrinter.print(..))")
	public void somethingToLog(final JoinPoint joinpoint) {
		System.out.println("This is the logging in for every message "+joinpoint.getSignature() +"begins ");
	}
	
}
