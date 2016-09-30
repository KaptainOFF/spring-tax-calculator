package com.kapitanov.springTaxCalculator.Calculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
	private static final BigDecimal PERCENTAGE_TIER_ONE = new BigDecimal("0.20");
	private static final BigDecimal PERCENTAGE_TIER_TWO = new BigDecimal("0.40");
	private static final BigDecimal PERCENTAGE_TIER_THREE = new BigDecimal("0.45");

	@Override
	public BigDecimal netAmount(String yearEnd, BigDecimal grossAmount) {
		BigDecimal finalAmount = new BigDecimal("0");
		
		if (yearEnd.equals("2014/2015")) {
			
			BigDecimal firstTier = new BigDecimal("10000");
			BigDecimal secondTier = new BigDecimal("41865");
			BigDecimal thirdTier = new BigDecimal("150000");
			BigDecimal finalTier = new BigDecimal("200000");
			
			if (grossAmount.compareTo(firstTier) == -1) {
				finalAmount = grossAmount;
			} else if ( grossAmount.compareTo(firstTier) == 1 && 
						(grossAmount.compareTo(secondTier) == 0 ||
						grossAmount.compareTo(secondTier) == -1) ) {
				
				BigDecimal taxableAmount = grossAmount.subtract(firstTier);
				
				// Calculating tax if amount is less than 41,865
				
				BigDecimal tax =  taxableAmount.multiply(PERCENTAGE_TIER_ONE);
				
				finalAmount = grossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( grossAmount.compareTo(secondTier) == 1 &&
						(grossAmount.compareTo(thirdTier) == 0 ||
						grossAmount.compareTo(thirdTier) == -1) ) {
	
				BigDecimal firstTaxableAmount = new BigDecimal("31865");
				BigDecimal secondTaxableAmount = grossAmount.subtract(secondTier);
				
				
				// Calculating tax if amount is between 41,865 and 150,000
				
				BigDecimal tax = ((firstTaxableAmount.multiply(
									PERCENTAGE_TIER_ONE)).add(
									secondTaxableAmount.multiply(
									PERCENTAGE_TIER_TWO)));
				
				finalAmount = grossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( grossAmount.compareTo(thirdTier) == 1 ) {
				
				BigDecimal firstTaxableAmount = new BigDecimal("31865");
				BigDecimal secondTaxableAmount = thirdTier.subtract(secondTier);
				BigDecimal thirdTaxableAmount = finalTier.subtract(grossAmount);
				
				// Calculating tax if amount is between 150,000 and 200,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								   PERCENTAGE_TIER_ONE).add(
								   secondTaxableAmount.multiply(
								   PERCENTAGE_TIER_TWO).add(
								   thirdTaxableAmount.multiply(
								   PERCENTAGE_TIER_THREE))));
				
				finalAmount = grossAmount.subtract(tax);
			}
			
		} else if (yearEnd.equals("2015/2016")) {
			
			BigDecimal firstTier = new BigDecimal("10600");
			BigDecimal secondTier = new BigDecimal("42385");
			BigDecimal thirdTier = new BigDecimal("150000");
			BigDecimal finalTier = new BigDecimal("200000");
			
			if (grossAmount.compareTo(firstTier) == -1) {
				finalAmount = grossAmount;
			} else if ( grossAmount.compareTo(firstTier) == 1 && 
						(grossAmount.compareTo(secondTier) == 0 ||
						grossAmount.compareTo(secondTier) == -1) ) {
				
				BigDecimal taxableAmount = grossAmount.subtract(firstTier);
				
				// Calculating tax if amount is less than 42,385
				
				BigDecimal tax =  taxableAmount.multiply(PERCENTAGE_TIER_ONE);
				
				finalAmount = grossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( grossAmount.compareTo(secondTier) == 1 &&
						(grossAmount.compareTo(thirdTier) == 0 ||
						grossAmount.compareTo(thirdTier) == -1) ) {
	
				BigDecimal firstTaxableAmount = new BigDecimal("31785");
				BigDecimal secondTaxableAmount = grossAmount.subtract(secondTier);
				
				// Calculating tax if amount is between 42,385 and 150,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								  PERCENTAGE_TIER_ONE)).add(
								  secondTaxableAmount.multiply(
								  PERCENTAGE_TIER_TWO));
				
				finalAmount = grossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
				
			} else if ( grossAmount.compareTo(thirdTier) == 1 ) {
				
				BigDecimal firstTaxableAmount = new BigDecimal("31785");
				BigDecimal secondTaxableAmount = thirdTier.subtract(secondTier);
				BigDecimal thirdTaxableAmount = finalTier.subtract(grossAmount);
				
				// Calculating tax if amount is between 150,000 and 200,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								  PERCENTAGE_TIER_ONE).add(
								  secondTaxableAmount.multiply(
								  PERCENTAGE_TIER_TWO)).add(
								  thirdTaxableAmount.multiply(
								  PERCENTAGE_TIER_THREE)));
				
				finalAmount = grossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			}
		}
		return finalAmount;
	}
}
