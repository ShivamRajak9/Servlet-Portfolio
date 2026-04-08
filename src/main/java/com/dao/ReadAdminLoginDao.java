package com.dao;

import com.model.ReadAdminLoginModel;

public interface ReadAdminLoginDao {
	ReadAdminLoginModel readAdminLoginData();
	String changeAdminLoginData(int id, String username, String password);
}
