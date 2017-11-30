package com.cotroc.accsesscontrol.blogic;

import java.util.List;

public class DbResult {
	
	private boolean succsess;
	private List<Object> objects;
	private String message;
	
	public boolean isSuccsess() {
		return succsess;
	}
	
	public void setSuccsess(boolean succsess) {
		this.succsess = succsess;
	}
	
	public List<Object> getObjects() {
		return objects;
	}
	public void setObject(List<Object> objs) {
		this.objects = objs;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public DbResult (boolean succsess, List<Object> ob, String msg) {
		this.succsess = succsess;
		this.objects = ob;
		this.message = msg;
	}
}
