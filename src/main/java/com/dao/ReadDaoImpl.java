package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.factory.ConnectionFactory;
import com.model.EmployeeModel;
import com.model.ProjectFile;

public class ReadDaoImpl implements ReadDao{
	private String result;
	@Override
	public List<EmployeeModel> readContact() {
		List<EmployeeModel> list = new ArrayList<EmployeeModel>(); 

		try {
			 Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement prepareStatement = conn.prepareStatement( "Select * from contacts");
			 ResultSet rs = prepareStatement.executeQuery();
			 while(rs.next()) {
				 	list.add(new EmployeeModel(rs.getInt("id"),rs.getString("name"),rs.getString("email"), rs.getString("massage"),rs.getString("dateTime")));				
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String readAdminLoginCredential(String username, String password) {
		try {
			String sql = "Select * from adminlogin where username=? and password=?";
			 Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement prepareStatement = conn.prepareStatement(sql);
			 prepareStatement.setString(1, username);
			 prepareStatement.setString(2, password);
			 ResultSet rs = prepareStatement.executeQuery();
			 boolean isExit = rs.next();
			 if(isExit) {
				 result="Exist";
			 }else {
				 result="Not Exist";
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			result = "Something Went Wrong";
		}
		return result;
	}

	@Override
	public List<ProjectFile> readProjectFileData() {
		List<ProjectFile> list = new ArrayList<ProjectFile>(); 

		try {
			 Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement prepareStatement = conn.prepareStatement( "Select * from myProject");
			 ResultSet rs = prepareStatement.executeQuery();
			 while(rs.next()) {
				 	list.add(new ProjectFile(rs.getInt("id"),rs.getString("filename"),rs.getString("dateTime")));				
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
