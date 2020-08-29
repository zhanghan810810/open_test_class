package com.example.demo.dto;

public class Error implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String error;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
