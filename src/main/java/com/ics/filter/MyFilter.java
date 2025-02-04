package com.ics.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public class MyFilter extends AbstractGatewayFilterFactory<MyFilter.Config> {

	public class Config {

	}

	public MyFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
	    return (exchange, chain) -> {
	    	System.out.println("helloooo");
	  
	    return  null;
	    };
	    }
		// TODO Auto-generated method stub

 
}
