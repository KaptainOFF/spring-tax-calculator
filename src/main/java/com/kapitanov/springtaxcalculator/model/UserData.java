package com.kapitanov.springtaxcalculator.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "userData")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "error.email.notnull")
	@Email(message = "error.email.format")
	private String email;

	@DecimalMin(value = "0", message = "error.grossamount.minimumvalue")
	@DecimalMax(value = "200000", message = "error.grossamount.maximumvalue")
	private BigDecimal takeHomePay;

	@NotNull(message = "error.grossamount.notnull")
	@DecimalMin(value = "0", message = "error.grossamount.minimumvalue")
	@DecimalMax(value = "200000", message = "error.grossamount.maximumvalue")
	@Digits(fraction = 2, integer = 6, message = "error.grossamount.value")
	private BigDecimal grossAmount;

	private BigDecimal tax;

	@NotNull(message = "error.taxyear.notnull")
	@Pattern(regexp = "^[0-9]{4}/[0-9]{4}", message = "error.taxyear.format")
	private String taxYear;

	private String ip;

	public UserData() {

	}

	public UserData(long id) {
		this.id = id;
	}

	public UserData(String email, BigDecimal grossAmount, String taxYear) {
		this.email = email;
		this.grossAmount = grossAmount;
		this.taxYear = taxYear;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getTakeHomePay() {
		return takeHomePay;
	}

	public void setTakeHomePay(BigDecimal takeHomePay) {
		this.takeHomePay = takeHomePay;
	}

}
