package com.kapitanov.springTaxCalculator.Services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapitanov.springTaxCalculator.Calculator.Calculator;
import com.kapitanov.springTaxCalculator.Dao.UserDataDao;
import com.kapitanov.springTaxCalculator.Model.UserData;

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
		BigDecimal netAmount = calculator.netAmount(taxYear, amount);
		UserData user = new UserData(email,netAmount,taxYear,ip);
		userDao.save(user);
		return user.getId();
	}

	@Override
	public void delete(UserData user) {
		userDao.delete(user);
		
	}

}
