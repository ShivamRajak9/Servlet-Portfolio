package com.validation;

import com.dto.ContactDTO;

public class ContactValidation {
	
	private String result;
	public  String validateContact(ContactDTO contactDTO) {
		if(contactDTO.getName().length()<2||contactDTO.getName().length()>30) {
			result = "Invalid Name";
		}
		else if(contactDTO.getEmail().length()<5 || contactDTO.getEmail().length()>30){
			result = "Invalid Email";
		} else if(contactDTO.getMessage().length()<2 || contactDTO.getMessage().length()>300) {
			result = "Invalid Message";
		} else {
			result ="Valid";
		}
		return result ;
	}

}
