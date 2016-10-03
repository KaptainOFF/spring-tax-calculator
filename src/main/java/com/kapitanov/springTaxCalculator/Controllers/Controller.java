package com.kapitanov.springTaxCalculator.Controllers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<UserData> getInstance(@PathVariable long id) {
		UserData user = taxCalcService.findById(id);
		if (user == null) {
			return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(user);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserData> postData(@Validated @RequestParam("email") String email,
						@Validated @RequestParam("amount") BigDecimal amount,
						@Validated @RequestParam("taxYear") String taxYear,
						@Validated HttpServletRequest request) {
		Long id = taxCalcService.save(email,taxYear,amount,request.getRemoteAddr());
		if (taxCalcService.findById(id) == null) {
			return new ResponseEntity<UserData>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(taxCalcService.findById(id));
	}
}
