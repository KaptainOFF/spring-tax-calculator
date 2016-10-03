package com.kapitanov.springTaxCalculator.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "userData")
public class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Email
	private String email;
	@DecimalMin("0")
	@DecimalMax("200000")
	private BigDecimal amount;
	@NotNull
	@Pattern(regexp = "^[0-9]{4}/[0-9]{4}")
	private String taxYear;
	@NotNull
	private String ip;
	
	public UserData() {
		
	}
	
	public UserData(long id) {
		this.id = id;
	}
	
	public UserData(String email, BigDecimal amount, String taxYear, String ip) {
		this.email = email;
		this.amount = amount;
		this.taxYear = taxYear;
		this.ip = ip;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	
}
