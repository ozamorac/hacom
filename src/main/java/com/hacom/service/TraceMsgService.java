package com.hacom.service;

import com.hacom.entity.TraceMsg;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TraceMsgService {

	public Flux<TraceMsg> findAll();
	
	public Mono<TraceMsg> create(TraceMsg e);
	
}
