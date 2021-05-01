package com.listener;

import com.entities.Todo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Context Created");
			//This method will be called when a context is created
			//When the server is started the context will be created
		
		List<Todo> list = new ArrayList<Todo>();
		ServletContext context = sce.getServletContext();
				//This ServletContext object is a singletone and only one is created througout the project
		context.setAttribute("list", list);
	}

}
