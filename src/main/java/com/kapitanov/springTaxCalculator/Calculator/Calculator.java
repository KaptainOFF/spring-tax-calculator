package com.kapitanov.springTaxCalculator.Calculator;

import java.math.BigDecimal;

public interface Calculator {
	
	BigDecimal netAmount(String yearEnd, BigDecimal grossAmount);

}
