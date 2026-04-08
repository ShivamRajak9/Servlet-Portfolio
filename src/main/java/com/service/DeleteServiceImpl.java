package com.service;

import java.sql.Connection;

import com.dao.DeleteDao;
import com.dao.DeleteDaoImpl;
import com.factory.ConnectionFactory;
import com.fileio.DeleteProjectIO;
import com.fileio.UploadProjectIO;

public class DeleteServiceImpl implements DeleteService {
	private String result;

	@Override
	public String contactdeleteService(String id) {
		// int parseInt = Integer.parseInt(id);
		// DeleteDao deleteDao = new DeleteDaoImpl();
		return new DeleteDaoImpl().deleteContactDao(Integer.parseInt(id));
	}

	@Override
	public String projectfileDeleteService(String filename) {
		// dao -> Delete
		// Success -> delete from folder
		// Exception -> rollback();
		// del -> commit();
		try {
			Connection connection = ConnectionFactory.getConnection(); // rollback krna hai isliye connection krna hai
			connection.setAutoCommit(false);
			DeleteDao deleteDaoImpl = new DeleteDaoImpl();
			result = deleteDaoImpl.deleteProjectFileDao(filename, connection);
			if (result.equalsIgnoreCase("Success")) {
				// Delete From Folder
				DeleteProjectIO deleteProjectIO = new DeleteProjectIO();
				result = deleteProjectIO.deleteProjectFile(filename);
				if(result.equalsIgnoreCase("DELETED")) {
					connection.commit();
					result="PROJECT DELETED SUCCESSFULLY";
				}

			} else {
				connection.rollback();
				result ="SOMETHING WENT WRONG:IO";
			}
		 }
		catch (Exception e) {
			e.printStackTrace();
			result ="SOMETHING WENT WRONG:SERVICE";
		}
		return result;
	}

}
