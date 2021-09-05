package com.hacom.controller;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hacom.entity.TraceMsg;
import com.hacom.service.TraceMsgService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//import com.hacom.entity.Configuracion;


@RestController
@RequestMapping("/tracemsg")
public class TraceMsgController {

	@Autowired	
	private TraceMsgService traceMsgService;	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public Mono<ResponseEntity<Map<String, Object>>> creteTrace(@RequestBody TraceMsg e) {
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		return traceMsgService.create(e).map(p-> {
			respuesta.put("trace", p);
			respuesta.put("mensaje", "Trace creado con éxito");
			respuesta.put("timestamp", new Date());
			return ResponseEntity
				.created(URI.create("/api/tracemsg/".concat(p.getSessionId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(respuesta);
			});
	}
	
	@GetMapping
	public Mono<ResponseEntity<Flux<TraceMsg>>> lista(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(traceMsgService.findAll())
				);
	}
	 
}
