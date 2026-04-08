package com.service;

import java.util.ArrayList;

import com.dto.EducationDTO;

public interface EducationService {
	String addEducationService1(String year, String title, String subtitle, String description);
	String addEducationService2(String year, String title, String subtitle, String description);
	String deleteEducation(String id);
	ArrayList<EducationDTO> readEducation();
	String updateEducationService(String id, String year, String title, String subtitle, String description);
}
