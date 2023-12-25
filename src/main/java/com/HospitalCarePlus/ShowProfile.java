package com.HospitalCarePlus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowProfile extends HttpServlet{

	private static Connection connection;
	
	@Override
	public void init() throws ServletException {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url ="jdbc:mysql://localhost:3306/hospital_management";
		String username ="root";
		String password ="Sumit@123";
		
		try {
			 connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getParameter(getServletName());
		
	}
	
	
   @Override
	public void destroy() {


	}
	
	
	
	
}
