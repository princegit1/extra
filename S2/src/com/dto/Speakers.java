package com.dto;

public class Speakers {
	private String name,designation,image;
	private int sid,pid;
	
	@Override
	public String toString() {
		return "Speakers [name=" + name + ", designation=" + designation + ", image=" + image + ", sid=" + sid
				+ ", pid=" + pid + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public Speakers(String name, String designation, String image, int sid, int pid) {
		super();
		this.name = name;
		this.designation = designation;
		this.image = image;
		this.sid = sid;
		this.pid = pid;
	}
	public Speakers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
