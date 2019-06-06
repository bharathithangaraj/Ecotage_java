package com.ecotage.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages= {"com.ecotage"})
@Import(JpaConfiguration.class)
@EnableSwagger2
public class EcotageApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EcotageApplication.class, args);
		
	}
	

}
