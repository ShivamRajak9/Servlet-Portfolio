package com.service;

import java.sql.Connection;
import java.time.LocalDateTime;

import javax.servlet.http.Part;

import com.dao.CreateDao;
import com.dao.CreateDaoImpl;
import com.dto.ContactDTO;
import com.factory.ConnectionFactory;
import com.fileio.UploadProjectIO;
import com.fileio.UploadResumeIO;
import com.validation.ContactValidation;

public class CreateServiceImpl implements CreateService {
	private String result;
	private CreateDao createDao;
	
	public CreateServiceImpl() {
		createDao = new CreateDaoImpl();
	}

	@Override
	public String insertContactService(ContactDTO contactDTO) {
		// ok//wrong=Validation same as a service
		ContactValidation contactValidation = new ContactValidation();
		result = contactValidation.validateContact(contactDTO);
		if (result.equalsIgnoreCase("Valid")) {
			// Dao
			result = createDao.insertContact(contactDTO);
			return result;
		} else {
			return result;
		}

	}

	@Override
	public String validateProjectFile(String filename,String contentType, long size) {
		if(!contentType.startsWith("image")){
			result ="INVALID IMAGE TYPE";
		} else if(size>1048576) {
			result="INVALID IMAGE SIZE";
		} else if(filename.length()<5||filename.length()>100){
			result="INVALID IMAGE NAME";
		}
		else {
			result="VALID";
		}
		return result;
	}

	@Override
	public String insertProjectFile(Part part ,String realPath) {
		//2025-09-23T18:30:49.784061
		try {
			String dateTime = LocalDateTime.now().toString();
			String[] split = dateTime.split(":");
			String orginalFileName = part.getSubmittedFileName();
			String formatedFileName;
			formatedFileName=split[0]+split[1]+split[2]+orginalFileName;
			
			Connection connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			//Insert  image data inside db
			CreateDao createDaoImpl = new CreateDaoImpl();
			result  = createDaoImpl.insertProjectFile(formatedFileName, connection);
			if(result.equalsIgnoreCase("SUCESS")) {
				//Insert Actual File In A Folder
				//Fail
				//con.rollback
				UploadProjectIO uploadProjectIO = new UploadProjectIO();
				result =uploadProjectIO.write(part,formatedFileName,realPath);
				if(result.equalsIgnoreCase("UPLOADED")) {
					connection.commit();
					result= "FILE UPLOADED SUCCESSFULLY";
				} else {
					connection.rollback();
					result= "SOMETHING WENT WRONG:FILEIO";
				}
			} else {
				result="SOMETHING WENT WRONG:DB";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="SOMETHING WENT WRONG:SERVICE";
		}
		
		
		return result;
	}

	@Override
	public String insertResumeFile(Part part, String realPath) {
		System.out.println(realPath);
		String contentType = part.getContentType();
		System.out.println(contentType);   
		String orginalFileName = part.getSubmittedFileName();
		long size = part.getSize();
		String result = validateResume(contentType, orginalFileName,size);
		if(result.equalsIgnoreCase("VALID")) {
			//FILEIO
			UploadResumeIO uploadResume = new UploadResumeIO();
			result = uploadResume.write(part, realPath);
			return result;
			
		} else {
			return result;
		}
	}
	
	public String validateResume(String contentType, String orginalFileName,long size) {
		if(!contentType.startsWith("application/pdf")){
			result ="INVALID FILE TYPE(ONLY PDF IS ALLOWED)";
		} else if(size>1048576) {
			result="INVALID FILE SIZE(LESS THAN 1MB)";
		} else if(orginalFileName.length()<5||orginalFileName.length()>100){
			result="INVALID FILE NAME (2 TO 100 CHARACTER)";
		}
		else {
			result="VALID";
		}
		return result;
	}

	

}
