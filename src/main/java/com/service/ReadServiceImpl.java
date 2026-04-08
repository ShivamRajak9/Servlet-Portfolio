package com.service;

import com.dao.ReadAdminLoginDao;
import com.dao.ReadAdminLoginDaoImpl;
import com.dao.ReadDao;
import com.dao.ReadDaoImpl;
import com.model.ReadAdminLoginModel;
import com.validation.AdminLoginCredential;

public class ReadServiceImpl implements ReadService{
	private String result;
	@Override
	public String checkAdminLoginCreadential(String username, String password) {
		AdminLoginCredential ad = new AdminLoginCredential();
		 result = ad.validateCredential(username, password);
		if(result.equalsIgnoreCase("valid")) {
			//Dao
			ReadDao readDao = new ReadDaoImpl();
			return readDao.readAdminLoginCredential(username, password);
		} else {
			return result;
		}
	}
	
	
	//AUTO FILL LOGIC
	@Override
	public ReadAdminLoginModel readAdminLoginService() {
		ReadAdminLoginModel readAdminLoginData = null;
		try {
			ReadAdminLoginDaoImpl readAdminLoginDaoImpl = new ReadAdminLoginDaoImpl();
			readAdminLoginData = readAdminLoginDaoImpl.readAdminLoginData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 	readAdminLoginData ;
	}

	
	//Only Password Username Validation With Servlate Collebration
	@Override
	public String changeAdminLoginService1( String username, String password) {
		try {
			AdminLoginCredential adminLoginCredential = new AdminLoginCredential();
			result = adminLoginCredential.validateCredential(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	//Change Username Password
	@Override
	public String changeAdminLoginService2(int id, String username, String password) {
		try {
			result =  new ReadAdminLoginDaoImpl().changeAdminLoginData(id, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			result="Something Went Wrong";
		}
		return result;
	}

}
