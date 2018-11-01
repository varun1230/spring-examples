package org.vstech.spring.boot.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class UsageOfControllerAspect {
	
//	@Pointcut("execution(* org.vstech.spring...*Controller.*(..)) && @annotation(requestMapping)")
    public void addControllArticle(){};
	
//	@Around("execution(* org.vstech.spring.controller.*.*(..)) && @annotation(requestMapping) && args(request, response)")
//	@Around("execution(* org.vstech.spring.controller.UsageOfController.printMessage(..))  && @annotation(requestMapping) && args(request, response)")
	
//    @Around("addControllArticle()")
    
    
//    @Around("execution(* org.vstech.spring..*Controller.*(..)) && @annotation(requestMapping) && args(request, response)")
    
    
//    @Before("execution(* org.vstech..*Controller.*(..)) && @annotation(requestMapping) && args(request, response)")
//	@Before("execution(* org.vstech.spring.controller.UsageOfController.printMessage(..))")

//	public void controllerLog(JoinPoint joinPoint) throws Throwable {
//	@Around("execution(* org.vstech.spring.controller.UsageOfController.printMessage(..))")
	
//	@Around("execution(* org.vstech.spring.controller.*.*(..)) && args(request, response, ..)")
//	public Object controllerLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
	@Around("execution(* org.vstech.spring.boot..*.*(..))")
	public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			
        HttpSession session = request.getSession(true);
        System.out.println("Printing what all the objects have ");
//        for (Object arg : args) {
//        	System.out.println("arg "+arg);
//			
//		}
        
        return joinPoint.proceed();
	}
}
