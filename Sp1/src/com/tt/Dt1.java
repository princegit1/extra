package com.tt;

public class Dt1 {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dt1(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Dt1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
	}

}
