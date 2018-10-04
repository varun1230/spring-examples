package org.vstech.spring.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class UsageOfControllerAspect {

//	@Before("execution(* org.vstech.spring.controller.UsageOfController.printMessage(..))")

//	public void controllerLog(JoinPoint joinPoint) throws Throwable {
//	@Around("execution(* org.vstech.spring.controller.UsageOfController.printMessage(..))")
	
//	@Around("execution(* org.vstech.spring.controller.*.*(..)) && args(request, response, ..)")
//	public Object controllerLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
	@Around("execution(* org.vstech.spring.controller.*.*(..))")
	public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		long startTime = System.currentTimeMillis();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken by {} is {}"+ timeTaken);
        return joinPoint.proceed();
	}
}
