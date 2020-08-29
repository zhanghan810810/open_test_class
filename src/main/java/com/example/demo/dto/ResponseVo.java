package com.example.demo.dto;

public final class ResponseVo<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final ResponseVo<Boolean> SUCCESS = new ResponseVo<Boolean>();

	private Result result = new Result();
	private T data;

	public ResponseVo(T data) {
		this.data = data;
	}

	public ResponseVo() {

	}

	public Result getResult() {
		return result;
	}

	public T getData() {
		return data;
	}

	public static ResponseVo toResponseVo(Object data) {
		return new ResponseVo(data);
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public void setData(T data) {
		this.data = data;
	}
}
