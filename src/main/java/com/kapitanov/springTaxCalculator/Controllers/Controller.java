package com.kapitanov.springTaxCalculator.Controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kapitanov.springTaxCalculator.model.UserData;
import com.kapitanov.springTaxCalculator.model.UserDataDao;

@RestController
@RequestMapping("/tax-calculator")
public class Controller {
	
	@Autowired
	private UserDataDao userDao;
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public String getTaxCalc() {
		userDao.findAll();
		return null;
	}
	@RequestMapping(method = RequestMethod.POST)
	public UserData postData(@RequestParam("email") String email, @RequestParam("amount") BigDecimal amount, @RequestParam("taxYear") String taxYear) {
		UserData userToStore = new UserData(email,amount,taxYear);
		userDao.save(userToStore);
		return userToStore;
	}
}
