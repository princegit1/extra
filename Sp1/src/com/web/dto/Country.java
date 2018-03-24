package com.web.dto;

public class Country {
	private int country_id;
	private String country_name;
	private int cont_id;
	private String country_flag;
	private int zone_id;
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(int country_id, String country_name, int cont_id, String country_flag, int zone_id) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.cont_id = cont_id;
		this.country_flag = country_flag;
		this.zone_id = zone_id;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public int getCont_id() {
		return cont_id;
	}
	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}
	public String getCountry_flag() {
		return country_flag;
	}
	public void setCountry_flag(String country_flag) {
		this.country_flag = country_flag;
	}
	public int getZone_id() {
		return zone_id;
	}
	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}
	
	
	

}
