package com.ics.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * MyFilterGatewayFilter
 * @author Vyom Gangwar
 * @since 4-feb 2025
 * **/

/**
 * AbstractGatewayFilterFactory is serve as base class for creating
 * customGatewayFilterFactory
 */
@Component
public class MyFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<MyFilterGatewayFilterFactory.Config> {

	public MyFilterGatewayFilterFactory() {
		/**
		 * this line is used to tell spring about the configuration class for this
		 * filter
		 */
		super(Config.class);
	}

	public static class Config {

	}

	/**
	 * apply method return gateway filter object
	 */
	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			System.out.println("helloooo from custom filter");
			return chain.filter(exchange);
		};
	}
	// TODO Auto-generated method stub

}
