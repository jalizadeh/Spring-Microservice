package com.jalizadeh.microservices.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudconfigserverApplication.class, args);
	}

}
