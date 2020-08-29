package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class Result implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean isSuccess = true;
	private List<Error> errors = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	private String message = "";
	private String messageCode = "";
	private String error = "";
	private String errorCode = "";
	private String transId;

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

}
