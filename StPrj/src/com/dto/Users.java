package com.dto;

import com.opensymphony.xwork2.ActionSupport;

public class Users extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String execute() {
		return "success";
	}
	
/*	public void validate() {
		if(name.length()<6) {
			 addActionError("Fields can't be blank");  
		}
	}*/
}
