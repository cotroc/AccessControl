package com.cotroc.accsesscontrol.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean 
@RequestScoped
public class Place {
	
	private int id;
	private int id_cli;
	private String name;
	private double lat;
	private double lon;
	
	public Place() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
}
