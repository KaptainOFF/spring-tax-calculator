package com.kapitanov.springtaxcalculator.services;

import com.kapitanov.springtaxcalculator.model.UserData;

public interface TaxCalculatorService {

	UserData findById(Long id);

	Long save(UserData user);

	void delete(UserData user);

}
