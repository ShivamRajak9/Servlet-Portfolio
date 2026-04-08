package com.dto;

public class EducationDTO {
	private int id;
	private String year;
	private String title;
	private String subtitle;
	private String description;
	private String datetime;
	public EducationDTO(int id, String year, String title, String subtitle, String description, String datetime) {
		super();
		this.id = id;
		this.year = year;
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		this.datetime = datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
}
