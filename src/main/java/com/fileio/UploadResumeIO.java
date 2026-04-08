package com.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadResumeIO {
	private String result;
	public String write(Part part ,String realPath) {
		try {
			InputStream inputStream = part.getInputStream();
			byte[] readAllBytes = inputStream.readAllBytes();
			String fixedFileName = "Shivamresume.pdf";
			FileOutputStream fileOutputStream = new FileOutputStream(realPath+File.separator+fixedFileName);  
			fileOutputStream.write(readAllBytes);
			fileOutputStream.close();
			result ="UPLOADED";
		} catch (Exception e) {   
			e.printStackTrace();
			result = "FAILED";
		}
		return result;
	}
}
