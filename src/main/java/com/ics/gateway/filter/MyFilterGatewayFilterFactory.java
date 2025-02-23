package com.ics.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ics.gateway.util.JwtUtil;

/**
 * MyFilterGatewayFilter
 * @author Vyom Gangwar
 * @since 4-feb 2025
 * **/

/**
 * AbstractGatewayFilterFactory is serve as base class for creating custom
 * filter customGatewayFilterFactory
 */
@Component
public class MyFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<MyFilterGatewayFilterFactory.Config> {

	@Autowired
	private JwtUtil jwtUtil;

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
			String path = exchange.getRequest().getURI().getPath();
			if (isOpen(path)) {
				return chain.filter(exchange);
			}
			final String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
			if (authorizationHeader != null) {
				String token_frontend = authorizationHeader.substring(7);
				if (ObjectUtils.isEmpty(token_frontend) || token_frontend.equals("null")) {
					return chain.filter(exchange);
				}
				Boolean isValid = jwtUtil.validateToken(token_frontend);
				if (isValid) {
					return chain.filter(exchange);
				} else {
					System.out.println("invalid token !!");
				}
			}
			System.out.println("token not found!!");
			return null;
		};
	}

	private Boolean isOpen(String endpoint) {
		String openpaths[] = { "/user/login", "/user/registration", "/user/forgetpassword", "/user/refreshtoken" };
		for (String path : openpaths) {
			if (endpoint.equals(path)) {
				// System.out.println(path);
				return true;
			}
		}
		return false;
	}
}
