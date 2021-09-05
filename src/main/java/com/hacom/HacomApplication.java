package com.hacom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hacom.config.ConfigProperties;

@SpringBootApplication
@EnableMongoRepositories("com.hacom.repository")
@ComponentScan("com.hacom.*")
public class HacomApplication implements CommandLineRunner {

	@Autowired
    private ServerProperties serverProperties;
	
	@Autowired
    private ConfigProperties configProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(HacomApplication.class, args);
	    
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Puerto Apache: " + serverProperties.getPort());
		System.out.println("Puerto EbFlux: " + configProperties.getApiPort());
	}

}
