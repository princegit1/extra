package com.dto;

public class Programme {
	private int pid;
	private String heading,time;
	private Speakers speakers;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Speakers getSpeakers() {
		return speakers;
	}
	public void setSpeakers(Speakers speakers) {
		this.speakers = speakers;
	}
	public Programme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Programme(int pid, String heading, String time, Speakers speakers) {
		super();
		this.pid = pid;
		this.heading = heading;
		this.time = time;
		this.speakers = speakers;
	}

	
	
	
}