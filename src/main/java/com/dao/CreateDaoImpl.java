package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.dto.ContactDTO;
import com.factory.ConnectionFactory;

public class CreateDaoImpl implements CreateDao{
	private String result;
	@Override
	public String insertContact(ContactDTO contactDTO) {
		//Connection
       try {
    	   Connection connection = ConnectionFactory.getConnection();
           String sql ="insert into contacts (name,email,massage,dateTime) values (?,?,?,?)";
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, contactDTO.getName());
           ps.setString(2, contactDTO.getEmail());
           ps.setString(3, contactDTO.getMessage());
           ps.setString(4, LocalDateTime.now().toString());
           int row = ps.executeUpdate();
           if(row==1) {
        	   result="CONTACT INSERTED SUCESSFULLY";
           }
		} catch (Exception e) {
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		return result;
	}
	
	@Override
	public String insertProjectFile(String formatedFileName ,Connection connection) {
		 try {
	           String sql ="insert into myProject (filename,dateTime) values (?,?)";
	           PreparedStatement ps = connection.prepareStatement(sql);
	           ps.setString(1, formatedFileName);
	           ps.setString(2, LocalDateTime.now().toString());
	           int row = ps.executeUpdate();
	           if(row==1) {
	        	   result="SUCESS";
	           }
			} catch (Exception e) {
				e.printStackTrace();
				result="FAILED";
			}
			return result;
	}
}
