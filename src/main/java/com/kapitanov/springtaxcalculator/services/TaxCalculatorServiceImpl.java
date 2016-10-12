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
	public Long save(UserData user) {
		BigDecimal takeHomePay = calculator.netAmount(user.getTaxYear(), user.getGrossAmount());
		BigDecimal tax = user.getGrossAmount().subtract(takeHomePay);
		user.setTakeHomePay(takeHomePay);
		user.setTax(tax);
		userDao.save(user);
		return user.getId();
	}

	@Override
	public void delete(UserData user) {
		userDao.delete(user);

	}

}
