package com.itgd.dto;

public class HomeDto {
	private int id,created_by,catid;
	private String small_image,author_name,datetime,title,short_desc,auth_image,cattitle,auth_img,auth_scren_name;
	
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCattitle() {
		return cattitle;
	}
	public void setCattitle(String cattitle) {
		this.cattitle = cattitle;
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
	public String getSmall_image() {
		return small_image;
	}
	public void setSmall_image(String small_image) {
		this.small_image = small_image;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getAuth_image() {
		return auth_image;
	}
	public void setAuth_image(String auth_image) {
		this.auth_image = auth_image;
	}

	
	public HomeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HomeDto [id=" + id + ", created_by=" + created_by + ", catid=" + catid + ", small_image=" + small_image
				+ ", author_name=" + author_name + ", datetime=" + datetime + ", title=" + title + ", short_desc="
				+ short_desc + ", auth_image=" + auth_image + ", cattitle=" + cattitle + ", auth_img=" + auth_img + "]";
	}
	public String getAuth_img() {
		return auth_img;
	}
	public void setAuth_img(String auth_img) {
		this.auth_img = auth_img;
	}
	public String getAuth_scren_name() {
		return auth_scren_name;
	}
	public void setAuth_scren_name(String auth_scren_name) {
		this.auth_scren_name = auth_scren_name;
	}

}
