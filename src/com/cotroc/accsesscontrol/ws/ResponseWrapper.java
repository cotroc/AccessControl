package com.cotroc.accsesscontrol.ws;

public class ResponseWrapper {
	
	private boolean success;
	private String message;
	private Object response;
	
	public ResponseWrapper(boolean succsess, String message, Object response) {
		this.success = succsess;
		this.message = message;
		this.response = response;
	}
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getResponse() {
		return response;
	}
	
	@Override
	public String toString() {
		return "{\"success\":\"" + this.success + "\","
				+ "\"message\":\"" + this.message + "\","
				+ "\"response\":{\"" + this.response.toString() + "\"}";	
	}
}
