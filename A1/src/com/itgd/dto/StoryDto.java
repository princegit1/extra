package com.itgd.dto;

public class StoryDto {
	private int id,created_by,catid;
	private String author_name,datetime,auth_image,title,full_description,header_image,catname;
	public StoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAuth_image() {
		return auth_image;
	}
	public void setAuth_image(String auth_image) {
		this.auth_image = auth_image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFull_description() {
		return full_description;
	}
	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}
	public String getHeader_image() {
		return header_image;
	}
	public void setHeader_image(String header_image) {
		this.header_image = header_image;
	}
	@Override
	public String toString() {
		return "StoryDto [id=" + id + ", created_by=" + created_by + ", catid=" + catid + ", author_name=" + author_name
				+ ", datetime=" + datetime + ", auth_image=" + auth_image + ", title=" + title + ", full_description="
				+ full_description + ", header_image=" + header_image + ", catname=" + catname + "]";
	}
	

}
