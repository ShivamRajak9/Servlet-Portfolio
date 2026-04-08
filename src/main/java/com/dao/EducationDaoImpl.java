package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dto.EducationDTO;
import com.factory.ConnectionFactory;

public class EducationDaoImpl implements EducationDao{
	private String sql;
	private int row;
	private Connection connection;
	private  PreparedStatement ps ;
	private ResultSet rs;
	private String result;
	
	@Override
	public String insertEducation(String year, String title, String subtitle, String description ,String datetime) {
		  try {
	    	   connection = ConnectionFactory.getConnection();
	           sql ="insert into educations (year,title,subtitle,description,datetime) values (?,?,?,?,?)";
	           ps = connection.prepareStatement(sql);
	           ps.setString(1, year);
	           ps.setString(2, title);
	           ps.setString(3, subtitle);
	           ps.setString(4, description);  
	           ps.setString(5, datetime);
	           row = ps.executeUpdate();
	           if(row==1) {
	        	   result="Saved";
	           }
			} catch (Exception e) {
				e.printStackTrace();
				result="SOMETHING WENT WRONG";
			}
			return result;
	}

	@Override
	public String deleteEducation(int id) {
		try {
			 connection = ConnectionFactory.getConnection();
			 sql = "delete from educations where id=?";
			 ps = connection.prepareStatement(sql);
			 ps.setInt(1, id);
			 row = ps.executeUpdate();
			if(row==1) {
				result = "Deleted";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result= "Something Went Wrong";
		} 
		return result;
	}

	@Override
	public ArrayList<EducationDTO> readEducation() {
		ArrayList<EducationDTO> arrayList = new ArrayList<EducationDTO>(); 

		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement( "Select * from educations");
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 arrayList.add(new EducationDTO(rs.getInt("id"),rs.getString("year"),rs.getString("title"), rs.getString("subtitle"),rs.getString("description"),rs.getString("dateTime")));				
			 }
		} catch (Exception e) {
			e.printStackTrace();
			arrayList.clear();	
		}
		return arrayList;
	}

	@Override
	public String updateEducationService(int id, String year, String title, String subtitle, String description,String datetime) {
		try {
			 connection = ConnectionFactory.getConnection();
			 sql = "update educations set year=? , title=? ,subtitle=? , description=? , datetime=? where id=?";   
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, year);
			 ps.setString(2, title);
			 ps.setString(3, subtitle);
			 ps.setString(4, description);
			 ps.setString(5, datetime);
			 ps.setInt(6, id);
			row = ps.executeUpdate();
			if(row==1) {
				result="UPDATED";
			}
		} catch (Exception e) {
			e.printStackTrace();    
			result="Failed";
		}
		return  result ;
	}

}
