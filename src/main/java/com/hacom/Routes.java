package com.hacom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.hacom.handler.TraceMsgHandler;

@Configuration
public class Routes {

	@Bean
	public RouterFunction<ServerResponse> routes(TraceMsgHandler handler){
		
		return route(GET("/api/tracemsg").or(GET("/api/v3/productos")), handler::listar)
				.andRoute(POST("/api/tracemsg/create"), handler::crear);
	}
}
