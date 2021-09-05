package com.hacom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import com.hacom.config.ConfigProperties;

import reactor.netty.http.server.HttpServer;

@Configuration
public class HttpServerConfig {

	@Autowired
    private ConfigProperties serverProperties;
	
	@Bean
	public HttpServer httpServer(RouterFunction<?> routerFunction) {
		HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer server = HttpServer.create().host("localhost").port(serverProperties.getApiPort());
		return server.handle(adapter);
	}
}
