package com.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadProjectIO {
	private String result;
	public String write(Part part, String formatedFileName, String realPath) {
		try {
			InputStream inputStream = part.getInputStream();
			byte[] readAllBytes = inputStream.readAllBytes();
			String path= realPath +File.separator+formatedFileName;
			//2025-09-23T18:30:49.784061
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(readAllBytes);
			return "UPLOADED";
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
	}

}
