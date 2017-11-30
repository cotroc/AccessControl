package com.cotroc.accsesscontrol.model;

import java.util.Date;

public class WorkingDay {

	private int id;
	private int id_emp;
	private int id_place;
	private String punch_in;
	private Date punch_hin;
	private Date punch_hout;
	private String punch_out;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public int getId_place() {
		return id_place;
	}
	public void setId_pace(int id_pace) {
		this.id_place = id_pace;
	}
	public String getPunch_in() {
		return punch_in;
	}
	public void setPunch_in(String punch_in) {
		this.punch_in = punch_in;
	}
	public Date getPunch_hin() {
		return punch_hin;
	}
	public void setPunch_hin(Date punch_hin) {
		this.punch_hin = punch_hin;
	}
	public Date getPunch_hout() {
		return punch_hout;
	}
	public void setPunch_hout(Date punch_hout) {
		this.punch_hout = punch_hout;
	}
	public String getPunch_out() {
		return punch_out;
	}
	public void setPunch_out(String punch_out) {
		this.punch_out = punch_out;
	}
	
}
