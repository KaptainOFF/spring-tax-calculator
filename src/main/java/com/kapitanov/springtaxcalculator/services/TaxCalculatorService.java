package com.kapitanov.springtaxcalculator.services;

import java.math.BigDecimal;

import com.kapitanov.springtaxcalculator.model.UserData;

public interface TaxCalculatorService {
	
	UserData findById(Long id);
	Long save(String email, String taxYear, BigDecimal amount, String ip);
	void delete(UserData user);

}
