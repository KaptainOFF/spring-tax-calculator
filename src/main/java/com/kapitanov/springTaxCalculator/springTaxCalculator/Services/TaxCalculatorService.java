package com.kapitanov.springTaxCalculator.springTaxCalculator.Services;

import com.kapitanov.springTaxCalculator.Model.UserData;

public interface TaxCalculatorService {
	
	UserData findById(Long id);
	void save(UserData user);
	void delete(UserData user);

}
