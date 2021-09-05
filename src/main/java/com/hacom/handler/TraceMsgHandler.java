package com.hacom.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hacom.entity.TraceMsg;
import com.hacom.service.TraceMsgService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TraceMsgHandler {

	@Autowired
	private TraceMsgService service;
	
	public Mono<ServerResponse> crear(ServerRequest request){
		Mono<TraceMsg> traceMsg = request.bodyToMono(TraceMsg.class);
		
		return traceMsg.flatMap(p -> {
				return service.create(p).flatMap(pdb -> ServerResponse
						.created(URI.create("/api/v2/productos/".concat(pdb.getSessionId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(fromObject(pdb)));
			
		});
	}
	
	public Mono<ServerResponse> listar(ServerRequest request){
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), TraceMsg.class);
	}
}
