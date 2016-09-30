package com.kapitanov.springTaxCalculator.springTaxCalculator.Services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.kapitanov.springTaxCalculator.Dao.UserDataDao;
import com.kapitanov.springTaxCalculator.Model.UserData;

public class TaxCalculatorServiceImpl implements TaxCalculatorService {
	
	@Autowired
	private UserDataDao userDao;

	@Override
	public UserData findById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public void save(UserData user) {
		BigDecimal amount = user.getAmount();
		
		userDao.save(user);
		
	}

	@Override
	public void delete(UserData user) {
		userDao.delete(user);
		
	}

}
