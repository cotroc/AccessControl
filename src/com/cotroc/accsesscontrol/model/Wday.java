package com.cotroc.accsesscontrol.model;

import java.util.Date;

import org.json.JSONObject;

public class Wday {

	private int id;
	private int id_emp;
	private int id_place;
	private Date punch_in;
	private Date punch_out;
	/*
	 * V2
	 *private Date h_in;
	 *private Date h_out;
	 */

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

	public void setId_place(int id_place) {
		this.id_place = id_place;
	}

	public Date getPunch_in() {
		return punch_in;
	}

	public void setPunch_in(Date punch_in) {
		this.punch_in = punch_in;
	}

	public Date getPunch_out() {
		return punch_out;
	}

	public void setPunch_out(Date punch_out) {
		this.punch_out = punch_out;
	}

	@Override
	public String toString() {
		JSONObject wday = new JSONObject();
		wday.put("id", this.id);
		wday.put("id_emp", this.id_emp);
		wday.put("id_place", this.id_place);
		wday.put("punch_in", this.punch_in);
		wday.put("punch_out", this.punch_out);
		return wday.toString();
	}
}