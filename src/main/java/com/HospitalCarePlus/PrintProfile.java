package com.HospitalCarePlus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class PrintProfile extends HttpServlet{
	
	private static Connection connection;

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
}
