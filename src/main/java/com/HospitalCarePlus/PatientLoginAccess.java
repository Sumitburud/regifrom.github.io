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

import org.apache.catalina.connector.Response;

import com.mysql.cj.protocol.Resultset;

public class PatientLoginAccess extends HttpServlet {
	
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    String Adhar = req.getParameter("patientadhar");
		String Password = req.getParameter("patientpassword");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		ResultSet res;
		
		 
		String SQL1 ="SELECT `Adhar_Number`,`Patient_Password`,`Patient_Name` from `patient_details`";
		try {
			Statement statement = connection.createStatement();
			
		          res = statement.executeQuery(SQL1);
		          
		  		ArrayList<String> passes = new ArrayList<>();
		  		ArrayList<String> AdharNos = new ArrayList<>();
		          
		          
		          while(res.next()) {
		        	  
		        	String AdharNo = res.getString("Adhar_Number");
		        	  String Pass = res.getString("Patient_Password");
		        	  
		        	  AdharNos.add(AdharNo);
		        	  passes.add(Pass);
		        	  
		        	 	  
		          }
		          
		          if((AdharNos.contains(Adhar))&&(passes.contains(Password))) {
	        		   
	        		  RequestDispatcher rd = req.getRequestDispatcher("UserDashb.html");
	        		  rd.include(req, resp);
	        		  
	        		  
	
	        		 
	        		
	       		}
		          else {
	        		   
	        		   out.print("<p\r\n"
		        		   		+ "      style=\"\r\n"
		        		   		+ "        color: red;\r\n"
		        		   		+ "        position: absolute;\r\n"
		        		   		+ "        margin-top: -100px;\r\n"
		        		   		+ "        margin-left: 27%;\r\n"
		        		   		+ "        font-size: 20px;\r\n"
		        		   		+ "        font-weight: 500\r\n"
		        		   		+ "      \"\r\n"
		        		   		+ "    >\r\n"
		        		   		+ "      *Please Check with Your Entered Adhar Number/Password and Try Again!"
		        		   		+ ""+"...</p>");
	        		
	        		 
	        		   RequestDispatcher rd2 = req.getRequestDispatcher("PatientLogin.html");
		        		  rd2.include(req, resp);
	        		   
	        	   }
		          
		          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
   @Override
	public void destroy() {

       try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
