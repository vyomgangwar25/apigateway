package com.ics.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
 

}
