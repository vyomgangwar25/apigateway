package com.ics.gateway.filter;

 

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * GlobalFilter,Ordered (interface)
 */
@Component
public class GlobalCustomFilter implements GlobalFilter, Ordered {

	/**
	 * get order(0) insure that this filter will run first among multiple filters
	 **/
	@Override
	public int getOrder() {

		return 0;
	}

	/**
	 * @exchange is used to access the current request data like request header,read
	 *           request body etc.
	 * @chain provides a way to delegate to the next filter
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		
		 
		System.out.println("helloo from global custom filter");
		return chain.filter(exchange);

	}

}
