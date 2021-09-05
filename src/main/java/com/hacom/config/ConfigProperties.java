package com.hacom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "variables")
public class ConfigProperties {
	private Integer apiPort;

	public Integer getApiPort() {
		return apiPort;
	}

	public void setApiPort(Integer apiport) {
		this.apiPort = apiport;
	}
	
}
