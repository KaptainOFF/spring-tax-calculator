package com.kapitanov.springtaxcalculator.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kapitanov.springtaxcalculator.model.UserData;
import com.kapitanov.springtaxcalculator.services.TaxCalculatorService;

@RestController
@RequestMapping("/tax-calculator")
public class Controller {

	@Autowired
	private TaxCalculatorService taxCalcService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<UserData> getInstance(@PathVariable long id) {
		UserData user = taxCalcService.findById(id);
		if (user == null) {
			return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(user);
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<UserData> postData(@Validated @RequestBody UserData user, HttpServletRequest req) {
		Long id = taxCalcService.save(user);
		user.setIp(req.getRemoteAddr());
		return ResponseEntity.ok(taxCalcService.findById(id));
	}

}
