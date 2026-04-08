package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.dao.EducationDao;
import com.dao.EducationDaoImpl;
import com.dto.EducationDTO;
import com.validation.EducationValidation;

public class EducationServiceImpl implements EducationService{
	@Override
	public String addEducationService1(String year, String title, String subtitle, String description) {
		return new EducationValidation().validateEducation(year, title, subtitle, description);
	}

	@Override
	public String addEducationService2(String year, String title, String subtitle, String description) {
		String datetime = LocalDateTime.now().toString();
		EducationDao educationDaoImpl = new EducationDaoImpl();
		return  educationDaoImpl.insertEducation(year, title, subtitle, description,datetime);
	}

	@Override
	public String deleteEducation(String id) {
		int idInt = Integer.parseInt(id);
		return new EducationDaoImpl().deleteEducation(idInt);     
	}

	@Override    
	public ArrayList<EducationDTO> readEducation() {
		return new EducationDaoImpl().readEducation();
	}

	@Override
	public String updateEducationService(String id ,String year, String title, String subtitle, String description) {
		int idInt = Integer.parseInt(id);
		String dateTime = LocalDateTime.now().toString();
		return new EducationDaoImpl().updateEducationService(idInt ,year, title, subtitle, description, dateTime);				 
	}
	
}
