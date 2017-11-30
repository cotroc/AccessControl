package com.cotroc.accsesscontrol.ws;

public class ResponseWrapper {
	
	private boolean succsess;
	private String message;
	private Object response;
	
	public ResponseWrapper() {
		
	}
	public ResponseWrapper(boolean succsess, String message, Object response) {
		this.succsess = succsess;
		this.message = message;
		this.response = response;
	}
	public boolean isSuccesStatus() {
		return succsess;
	}
	public void setSuccesStatus(boolean succsesStatus) {
		this.succsess = succsesStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return "{\"succsesStatus\":\"" + this.succsess + "\","
				+ "\"message\":\"" + this.message + "\","
				+ "\"response\":{\"" + this.response.toString() + "\"}";	
	}

}
