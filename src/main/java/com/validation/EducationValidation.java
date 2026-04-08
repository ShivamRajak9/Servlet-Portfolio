package com.validation;

public class EducationValidation {
	private String result;
	public  String validateEducation(String year, String title, String subtitle, String description) {
		if(year.length()<2||year.length()>5) {
			result = "Invalid Year";
		}
		else if(title.length()<5 || title.length()>30){
			result = "Invalid Title";
		}else if(subtitle.length()<5 || subtitle.length()>30) {
			result = "Invalid Subtitle";
		}else if(description.length()<5 || description.length()>100){
			result ="Invalid Description";
		}else {
			result = "Valid";
		}
		return result ;
	}
}
