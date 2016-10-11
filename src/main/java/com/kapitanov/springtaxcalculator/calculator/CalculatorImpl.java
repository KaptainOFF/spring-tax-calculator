package com.kapitanov.springtaxcalculator.calculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
	public static final BigDecimal BASIC_RATE = new BigDecimal("0.20");
	public static final BigDecimal HIGHER_RATE = new BigDecimal("0.40");
	public static final BigDecimal ADDITIONAL_RATE = new BigDecimal("0.45");
	public static final BigDecimal limit = new BigDecimal("200000");

	private BigDecimal basicRateStart;
	private BigDecimal higherRateStart;
	private BigDecimal additionalRateStart;

	@Override
	public BigDecimal netAmount(String yearEnd, BigDecimal grossAmount) {


		if (yearEnd.equals("2014/2015")) {

			basicRateStart = new BigDecimal("10000");
			higherRateStart = new BigDecimal("41865");
			additionalRateStart = new BigDecimal("150000");

			return takeHomeHelper(basicRateStart, higherRateStart, additionalRateStart, grossAmount);

		}

		if (yearEnd.equals("2015/2016")) {

			basicRateStart = new BigDecimal("10600");
			higherRateStart = new BigDecimal("42385");
			additionalRateStart = new BigDecimal("150000");

			return takeHomeHelper(basicRateStart, higherRateStart, additionalRateStart, grossAmount);

		} 
		return new BigDecimal("0");
	}

	private BigDecimal takeHomeHelper(BigDecimal basicRateStart,
			BigDecimal higherRateStart,
			BigDecimal additionalRateStart,
			BigDecimal grossAmount) {
		BigDecimal finalAmount = new BigDecimal("0");

		if (grossAmount.compareTo(basicRateStart) == -1) {
			
			//Calculating tax of 0 %

			finalAmount = grossAmount;

		} else if (grossAmount.compareTo(basicRateStart) == 1 && 
				(grossAmount.compareTo(higherRateStart) == 0 ||
				grossAmount.compareTo(higherRateStart) == -1) ) {

			BigDecimal taxableAmount = grossAmount.subtract(basicRateStart);

			// Calculating tax for basic rate of 20%

			BigDecimal tax =  taxableAmount.multiply(BASIC_RATE);

			finalAmount = grossAmount.subtract(tax);
			System.out.println("Your tax is: " + tax);
		} else if ( grossAmount.compareTo(higherRateStart) == 1 &&
				(grossAmount.compareTo(additionalRateStart) == 0 ||
				grossAmount.compareTo(additionalRateStart) == -1) ) {

			BigDecimal firstTaxableAmount = new BigDecimal("31865");
			BigDecimal secondTaxableAmount = grossAmount.subtract(higherRateStart);


			// Calculating higher tax rate of 40%

			BigDecimal tax = ((firstTaxableAmount.multiply(
					BASIC_RATE)).add(
							secondTaxableAmount.multiply(
									HIGHER_RATE)));

			finalAmount = grossAmount.subtract(tax);
		} else if ( grossAmount.compareTo(additionalRateStart) == 1 ) {

			BigDecimal firstTaxableAmount = new BigDecimal("31865");
			BigDecimal secondTaxableAmount = additionalRateStart.subtract(higherRateStart);
			BigDecimal thirdTaxableAmount = limit.subtract(grossAmount);

			// Calculating additional tax rate of 45%

			BigDecimal tax = (firstTaxableAmount.multiply(
					BASIC_RATE).add(
							secondTaxableAmount.multiply(
									HIGHER_RATE).add(
											thirdTaxableAmount.multiply(
													ADDITIONAL_RATE))));

			finalAmount = grossAmount.subtract(tax);
		}
		return finalAmount;
	}

}




