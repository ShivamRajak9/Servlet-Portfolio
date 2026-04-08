package com.dao;

import java.util.List;

import com.model.EmployeeModel;
import com.model.ProjectFile;

public interface ReadDao {
	public List<EmployeeModel> readContact();
	public String readAdminLoginCredential(String username, String password);
	
	public List<ProjectFile> readProjectFileData();
		
}
