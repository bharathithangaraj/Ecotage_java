package com.ecotage.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages= {"com.ecotage"})
@Import(JpaConfiguration.class)
@EnableSwagger2
public class EcotageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcotageApplication.class, args);
	}
	

}
