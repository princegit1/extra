package com.web.rest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="id")
	private int id;  
	@XmlElement(name="introtext")
	private String introtext;
	@XmlElement(name="modified")
	private String modified;
	@XmlElement(name="kickerimage")
	private String kickerimage;
	@XmlElement(name="fulltext")
	private String fulltext;
	         
	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;  
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getKickerimage() {
		return kickerimage;
	}

	public void setKickerimage(String kickerimage) {
		this.kickerimage = kickerimage;
	}

	public String getName() {
		return name;
	}
	
	public String getIntrotext() {
		return introtext;
	}

	public void setIntrotext(String introtext) {
		this.introtext = introtext;
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
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
