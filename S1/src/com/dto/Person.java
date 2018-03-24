package com.dto;

public class Person {
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
	
	public void display() {
		System.out.println(" Id: " + id + " Name: " + name);
	}

}
