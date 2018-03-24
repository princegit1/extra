package com.dto;

public class Person {
	private String name;
	private String email;
	private String password;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person(String name, String email, String password, int id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

}
