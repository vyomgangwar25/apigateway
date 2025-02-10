package com.ics.gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("running api gateway");
	}

//	@Bean
//	RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder) {
//		return routeLocatorBuilder.routes().route("api_gateway", r -> r.path("/user/**")
//		// filters(f->f.filters( new MyFilterGatewayFilterFactory.Config()) )
//
////				filters(f -> f.filter(filter.apply(new MyFilterGatewayFilterFactory.Config())))
//				.uri("http://localhost:8081/")).build();
//	}

}
