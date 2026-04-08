package com.service;

import javax.servlet.http.Part;

import com.dto.ContactDTO;
import com.dto.EducationDTO;

public interface CreateService {
	String insertContactService(ContactDTO contactDTO);
	String validateProjectFile(String filename,String  contentType, long size);
	String insertProjectFile(Part part, String realPath);
	String insertResumeFile(Part part, String realPath);
}
