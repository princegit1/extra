
package com.service.rest;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Abc {
	private int id;
	private String name;
	private String desc;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Abc(int id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Abc() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
