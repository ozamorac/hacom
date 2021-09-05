package com.hacom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacom.entity.TraceMsg;
import com.hacom.repository.TraceMsgRepository;
import com.hacom.service.TraceMsgService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TraceMsgServiceImpl implements TraceMsgService {

	@Autowired
	TraceMsgRepository traceMsgRepo;
	
	@Override
	public Mono<TraceMsg> create(TraceMsg e) {
		return traceMsgRepo.save(e);
	}

	@Override
	public Flux<TraceMsg> findAll() {
		return traceMsgRepo.findAll();
	}

}
