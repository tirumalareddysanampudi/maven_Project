package com.app.sathya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}
		public RestTemplate restTemplate()
		{
			
		return new RestTemplate();
		
	}

}
