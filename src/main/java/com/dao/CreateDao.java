package com.dao;

import java.sql.Connection;

import com.dto.ContactDTO;
import com.dto.EducationDTO;

public interface CreateDao {
	 String insertContact(ContactDTO contactDTO);
	 String insertProjectFile(String formatedFileName,Connection connection);

}
