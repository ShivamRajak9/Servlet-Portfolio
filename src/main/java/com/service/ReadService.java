package com.service;

import com.model.ReadAdminLoginModel;

public interface ReadService {
	public String checkAdminLoginCreadential(String username, String password);
	public ReadAdminLoginModel readAdminLoginService();
	public String changeAdminLoginService1( String username, String password);
	public String changeAdminLoginService2(int id, String username, String password);
}
