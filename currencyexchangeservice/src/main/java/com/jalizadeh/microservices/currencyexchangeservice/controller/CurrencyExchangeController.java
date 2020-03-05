package com.jalizadeh.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalizadeh.microservices.currencyexchangeservice.Repository.ExchangeValueRepository;
import com.jalizadeh.microservices.currencyexchangeservice.model.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to) {
		ExchangeValue ev = repository.findByFromAndTo(from, to);
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));		
		return ev;
	}

}
