package com.eventhandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.TableCreation;

@WebListener
public class Start implements ServletContextListener{
	//Automatic table creation
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		TableCreation tableCreation = new TableCreation();
//		tableCreation.adminlogin();
//		tableCreation.contact();
//		tableCreation.educations();
//		tableCreation.myproject();
		System.out.println("*****************");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("################");
	}
}
