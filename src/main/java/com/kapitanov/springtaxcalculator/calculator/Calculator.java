package com.kapitanov.springtaxcalculator.calculator;

import java.math.BigDecimal;

public interface Calculator {
	
	BigDecimal netAmount(String yearEnd, BigDecimal grossAmount);

}
