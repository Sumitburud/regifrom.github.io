package com.HospitalCarePlus;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class DoctorLogin extends HttpServlet{
	
	static private Connection connection;
	
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url ="jdbc:mysql://localhost:3306/hospital_management";
		String username ="root";
		String password ="Sumit@123";
		
		try {
			  connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String DocName = req.getParameter("docname");
		String Password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		ResultSet res;
		
		
		String SQL = "SELECT * from `doctors_database`";
		
		
		ArrayList<String> Docnames = new ArrayList<>();
		ArrayList<String> passes = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
		          res = statement.executeQuery(SQL);
		          
		          while(res.next()) {
		        	  
		        	  String AdminName = res.getString("Doc_Name");
		        	  String AdminPass = res.getString("Doc_Password");
		        	  
		        	  Docnames.add(AdminName);
		        	  passes.add(AdminPass);
		          }
		          
		          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((Docnames.contains(DocName))&&(passes.contains(Password))) {
			
			RequestDispatcher rd = req.getRequestDispatcher("DoctorDashb.html");
			rd.include(req, resp);
		}
		else if((Docnames.contains(DocName))&&(!passes.contains(Password))) {
			
			out.print("<p style='color:red;  margin-top:-45px; margin-left: 35%;  position: absolute;'>"
					
					+ "*You Have Entered The Wrong Password! Please Try Again...</p> ");
			
			RequestDispatcher rd1 = req.getRequestDispatcher("DoctorLogin.html");
			rd1.include(req, resp);
		}
		
		
		
		
		
		
		
		
		
	}

}
