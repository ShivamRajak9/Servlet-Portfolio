package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.factory.ConnectionFactory;
import com.model.ReadAdminLoginModel;

public class ReadAdminLoginDaoImpl implements ReadAdminLoginDao {
	private String result;
	@Override
	public ReadAdminLoginModel readAdminLoginData() {
		ReadAdminLoginModel readAdminLoginModel = null;
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "select * from  adminlogin";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();  
			readAdminLoginModel = new ReadAdminLoginModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
		} catch (Exception e) {
			e.printStackTrace();
			result="Something Went Wrong";
		}
		return  readAdminLoginModel ;
	}
	@Override
	public String changeAdminLoginData(int id, String username, String password) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "update adminlogin set username=? , password=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, id);
			int row = ps.executeUpdate();
			if(row==1) {
				result="CHANGE CREDENTIAL";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="Failed";
		}
		return  result ;
	}
}
