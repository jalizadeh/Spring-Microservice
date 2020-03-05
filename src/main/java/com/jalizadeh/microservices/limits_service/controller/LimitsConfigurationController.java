package com.jalizadeh.microservices.limits_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalizadeh.microservices.limits_service.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(1000, 1);
	}

}
