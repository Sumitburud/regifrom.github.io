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

public class Function1 extends HttpServlet {
	
	private static Connection connection;
	
	
	
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
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultSet res ;
		String Name = req.getParameter("adminname");
		String Password = req.getParameter("adminpassword");
		resp.setContentType("text/html");
		
		String SQL = "SELECT * from `admins_details`";
		
		PrintWriter out = resp.getWriter();
		
		ArrayList<String> List1 = new ArrayList<>();
		ArrayList<String> List2 = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
		          res = statement.executeQuery(SQL);
		          
		          while(res.next()) {
		        	  
		        	  String AdminName = res.getString("Name");
		        	  String AdminPass = res.getString("Password");
		        	  
		        	  List1.add(AdminName);
		        	  List2.add(AdminPass);
		          }
		          
		          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((Name.equalsIgnoreCase((String) List1.get(0))|| Name.equalsIgnoreCase((String) List1.get(1))
			)&& (Password.equals((String) List2.get(0))|| Password.equals((String) List2.get(1)))	) {
			
			
			RequestDispatcher rd = req.getRequestDispatcher("AdminDashb.jsp");
        	rd.include(req, resp);
		}
		
		else if((!Name.equalsIgnoreCase((String) List1.get(0)))||(! Name.equals((String) List1.get(1)))){
			
			out.print("<p style='color:red;  margin-top:-80px; margin-left: 30%;  position: absolute;'>"
					
					+ "*Please Check if Your Entered Password/Username is incorrect. and Try Again!..</p> ");
			
			RequestDispatcher rd1 = req.getRequestDispatcher("adminLogin.html");
        	rd1.include(req, resp);
		}
        else if((!Password.equals((String) List1.get(0)))||(! Password.equals((String) List1.get(1)))){
			
                out.print("<p style='color:red;  margin-top:-80px; margin-left: 30%;  position: absolute;'>"
					
					+ "*Please Check if Your Entered Password/Username is incorrect. and Try Again!..</p> ");
			
			RequestDispatcher rd2 = req.getRequestDispatcher("adminLogin.html");
        	rd2.include(req, resp);
		}
      	
		
		
	}
	
      public void destroy() {
    	  
    	  try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
