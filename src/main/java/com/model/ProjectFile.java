package com.model;

public class ProjectFile {
	private int id;
	private String filename;
	private String dateTime;
	public ProjectFile(int id, String filename, String dateTime) {
		super();
		this.id = id;
		this.filename = filename;
		this.dateTime = dateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
