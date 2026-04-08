package com.dao;

import java.sql.Connection;

public interface DeleteDao {
	public String deleteContactDao(int id);
	public String deleteProjectFileDao(String filename,Connection connection);
}
