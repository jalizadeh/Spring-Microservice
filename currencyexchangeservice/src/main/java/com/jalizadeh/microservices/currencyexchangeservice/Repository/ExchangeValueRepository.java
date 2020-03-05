package com.jalizadeh.microservices.currencyexchangeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalizadeh.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
