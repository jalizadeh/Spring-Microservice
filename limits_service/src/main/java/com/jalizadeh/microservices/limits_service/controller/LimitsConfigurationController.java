package com.jalizadeh.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalizadeh.microservices.limits_service.bean.LimitConfiguration;
import com.jalizadeh.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(config.getMaximum(), config.getMinimum());
	}

}
