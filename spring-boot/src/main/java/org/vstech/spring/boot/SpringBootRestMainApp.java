package org.vstech.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://websystique.com/spring-boot/spring-boot-rest-api-example/
 * https://stackoverflow.com/questions/28466207/could-not-find-acceptable-representation-using-spring-boot-starter-web
 * https://stackoverflow.com/questions/26549379/when-use-responseentityt-and-restcontroller-for-spring-restful-applications
 *
 */

//same as @Configuration @EnableAutoConfiguration @ComponentScan

@SpringBootApplication(scanBasePackages={"org.vstech.spring.boot"})
public class SpringBootRestMainApp {
 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestMainApp.class, args);
	}
}
