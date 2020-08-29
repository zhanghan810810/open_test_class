package com.example.demo.dto;

public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String messageCode;
	private String message;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
