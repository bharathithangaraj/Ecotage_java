package com.ecotage.main;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.ecotage.exception.RestTemplateResponseErrorHandler;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages= {"com.ecotage"})
@Import(JpaConfiguration.class)
@EnableSwagger2
public class EcotageApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EcotageApplication.class, args);
		
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

	@Bean(name = "template2")
	public RestTemplate restTemplate2(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(4)).build();
	}
	

}
