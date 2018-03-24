/**
 * 
 */
package com.entity;

public class Test {
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

	public void displ() {
		System.out.println(" --- > " + id + " - " + name);     
	}
}
