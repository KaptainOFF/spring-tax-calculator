package com.kapitanov.springTaxCalculator.Services;

import java.math.BigDecimal;

import com.kapitanov.springTaxCalculator.Model.UserData;

public interface TaxCalculatorService {
	
	UserData findById(Long id);
	void save(String email, String taxYear, BigDecimal amount, String ip);
	void delete(UserData user);

}
