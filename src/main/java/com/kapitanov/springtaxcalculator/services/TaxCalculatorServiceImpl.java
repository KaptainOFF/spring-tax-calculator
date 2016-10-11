package com.kapitanov.springtaxcalculator.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapitanov.springtaxcalculator.calculator.Calculator;
import com.kapitanov.springtaxcalculator.dao.UserDataDao;
import com.kapitanov.springtaxcalculator.model.UserData;

@Service
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

	@Autowired
	private UserDataDao userDao;
	@Autowired
	private Calculator calculator;

	@Override
	public UserData findById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public Long save(String email, String taxYear, BigDecimal amount, String ip) {
		BigDecimal takeHomePay = calculator.netAmount(taxYear, amount);
		BigDecimal tax = amount.subtract(takeHomePay);
		UserData user = new UserData(email,tax, takeHomePay,taxYear,ip);
		userDao.save(user);
		return user.getId();
	}

	@Override
	public void delete(UserData user) {
		userDao.delete(user);

	}

}
