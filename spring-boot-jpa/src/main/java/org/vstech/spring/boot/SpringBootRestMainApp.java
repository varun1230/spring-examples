package org.vstech.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
 */

//same as @Configuration @EnableAutoConfiguration @ComponentScan

@SpringBootApplication(scanBasePackages={"org.vstech.spring.boot"})
@EnableJpaAuditing
public class SpringBootRestMainApp extends SpringBootServletInitializer {
 
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootRestMainApp.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestMainApp.class, args);
	}
}
