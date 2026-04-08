package com.dao;

import java.util.ArrayList;

import com.dto.EducationDTO;

public interface EducationDao {
	String insertEducation(String year, String title, String subtitle, String description ,String datetime);
	String deleteEducation(int id);
	ArrayList<EducationDTO> readEducation();
	String updateEducationService(int id, String year,String title, String subtitle, String description, String datetime);
}
