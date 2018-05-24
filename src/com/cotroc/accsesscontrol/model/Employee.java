package com.cotroc.accsesscontrol.model;

import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONObject;

@XmlRootElement()
public class Employee {
	
	private int id;
	private String ci;
	private String name;
	private String address;
	private String tel;
	private String u_id;
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCi() {
		return ci;
	}
	
	public void setCi(String ci) {
		this.ci = ci;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String addres) {
		this.address = addres;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAndroid_id() {
		return u_id;
	}

	public void setAndroid_id(String android_id) {
		this.u_id = android_id;
	}
	
	@Override
	public String toString() {
		JSONObject emp = new JSONObject();
		emp.put("id", this.id);
		emp.put("ci", this.ci);
		emp.put("name", this.name);
		emp.put("address", this.address);
		emp.put("tel", this.tel);
		emp.put("android_id", this.u_id);
		return emp.toString();
	}
}
