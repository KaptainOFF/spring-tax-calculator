package com.kapitanov.springTaxCalculator.Controllers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kapitanov.springTaxCalculator.Model.UserData;
import com.kapitanov.springTaxCalculator.Services.TaxCalculatorService;

@RestController
@RequestMapping("/tax-calculator")
public class Controller {
	
	@Autowired
	private TaxCalculatorService taxCalcService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserData getInstance(@PathVariable long id) {
		UserData user = taxCalcService.findById(id);
		return user;
	}
	@RequestMapping(method = RequestMethod.POST)
	public void postData(@Valid @RequestParam("email") String email, BindingResult emailResult,
						@Valid @RequestParam("amount") BigDecimal amount,  BindingResult amountResult,
						@Valid @RequestParam("taxYear") String taxYear,  BindingResult taxYearResult,
						HttpServletRequest request) {
		taxCalcService.save(email,taxYear,amount,request.getRemoteAddr());
	}
}
