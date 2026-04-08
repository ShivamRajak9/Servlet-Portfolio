package com.fileio;

import java.io.File;

public class DeleteProjectIO {
	private String result;
	public String deleteProjectFile(String filename) {
		try {
			String path= "C:\\Users\\shiva\\eclipse-workspace\\AdvanceJavaProjects\\PortFolio\\src\\main\\webapp\\myproject" +File.separator+filename;
			File file = new File(path);
			file.delete();
			result = "DELETED";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Failed";
		}
		return result;
	}
}
