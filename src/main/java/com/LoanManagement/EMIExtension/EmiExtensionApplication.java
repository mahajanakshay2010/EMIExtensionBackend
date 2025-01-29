package com.LoanManagement.EMIExtension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EmiExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmiExtensionApplication.class, args);
		
		
	}
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
