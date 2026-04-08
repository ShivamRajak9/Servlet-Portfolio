package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.factory.ConnectionFactory;

public class DeleteDaoImpl implements DeleteDao{
		
	private String result;
	@Override
	public String deleteContactDao(int id) {
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "delete from contacts where id=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			int row = prepareStatement.executeUpdate();
			if(row==1) {
				result = "Contact Deleted Success Full";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result= "Something Went Wrong";
		} 
		return result;
	}
	
	@Override
	public String deleteProjectFileDao(String filename,Connection connection) {
		try {
			String sql = "delete from myproject where filename=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, filename);
			int row = prepareStatement.executeUpdate();
			if(row==1) {
				result = "SUCCESS";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			result ="SOMETHING WENT WRONG:DAO";
		} 
		return result;
	}
}
