package com.dto;

public class Test1 {
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
	
	public Test1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test1(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Test1 [name=" + name + ", id=" + id + "]";
	}
	
	public void display() {
		System.out.println(" Id: " + id + " Name: " + name);
	}

}
