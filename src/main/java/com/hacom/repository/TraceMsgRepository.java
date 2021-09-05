package com.hacom.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.hacom.entity.TraceMsg;

import reactor.core.publisher.Flux;

public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, Integer> {

	//Flux<TraceMsg> findAll();
	
}
