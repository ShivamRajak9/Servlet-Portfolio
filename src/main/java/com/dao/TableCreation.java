package com.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.factory.ConnectionFactory;

public class TableCreation {
	
	public void contact() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql ="create table contacts ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "name varchar(30),"
					+ "email varchar(50),"
					+ "massage varchar(500),"
					+ "dateTime varchar(50))";
			Statement createStatement = connection.createStatement();
			createStatement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void adminlogin() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql ="create table adminlogin ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "username varchar(30),"
					+ "password varchar(30))";
			Statement createStatement = connection.createStatement();
			createStatement.execute(sql);
			createStatement.close();
			
			sql = "insert into adminlogin (username , password) values ('shivam@123' , 'shivam123')";
			createStatement=connection.createStatement();
			createStatement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void educations() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql ="create table educations ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "year varchar(4),"
					+ "title varchar(30),"
					+ "subtitle varchar(30),"
					+ "description varchar(100),"
					+ "dateTime varchar(50))";
			Statement createStatement = connection.createStatement();
			createStatement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myproject() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql ="create table myproject("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "filename varchar(100),"
					+ "dateTime varchar(50))";
			Statement createStatement = connection.createStatement();
			createStatement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
