package com.kapitanov.springtaxcalculator.errors;

public class ValidationErrorMessage {

	private String message;
	private MessageType type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public ValidationErrorMessage(String message, MessageType type) {
		super();
		this.message = message;
		this.type = type;
	}

	public ValidationErrorMessage() {

	}

}
