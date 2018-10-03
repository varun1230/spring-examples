package org.vstech.spring.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UsageOfControllerAspect {

	@Around("execution(* org.vstech.spring.service.controller.printMessage(..)) && @annotation(@RequestMapping)")
	public void controllerLog() {
		
	}
}
