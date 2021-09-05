package com.hacom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ConfigMongoDB {
	
		private String mongodbDatabase;  
		private String mongodbUri;
		
		public String getMongodbDatabase() {
			return mongodbDatabase;
		}
		public void setMongodbDatabase(String mongodbDatabase) {
			this.mongodbDatabase = mongodbDatabase;
		}
		public String getMongodbUri() {
			return mongodbUri;
		}
		public void setMongodbUri(String mongodbUri) {
			this.mongodbUri = mongodbUri;
		}
}
