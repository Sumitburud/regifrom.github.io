package com.HospitalCarePlus;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HospitalCarePlus.BO.Patient_details_BOimp;
import com.HospitalCarePlus.modules.Patient_details;

public class PatientDetails extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Name = req.getParameter("fullname");
		String Password = req.getParameter("password");
		String Number = req.getParameter("Number");
		String Email = req.getParameter("email");
		String Address = req.getParameter("address");
		String Area = req.getParameter("area");
		String Adhar = req.getParameter("adhar");
		String State = req.getParameter("state");
		String Country = req.getParameter("country");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		Patient_details_BOimp pdboimp = new Patient_details_BOimp();
		
	    Patient_details patient_details = new Patient_details(Name, Password, Area, Email, Address, Adhar, Number, State, Country);
		 
	    Patient_details pd = pdboimp.get(Adhar);
		 
		 if(pd != null) {
			 
			 out.print(" <p\r\n"
						+ "      style=\"\r\n"
						+ "        color: red;\r\n"
						+ "        position: absolute;\r\n"
						+ "        margin-top: 20px;\r\n"
						+ "        margin-left: 35%;\r\n"
						+ "        font-size: 20px;\r\n"
						+ "      \"\r\n"
						+ "    >\r\n"
						+ "      *You Already have an Account ! Please try to<a\r\n"
						+ "        href=\"PatientLogin.html\"\r\n"
						+ "        style=\"text-decoration: none; font-size: 22px; font-weight: bold\"\r\n"
						+ "        >Login</a\r\n"
						+ "      >....\r\n"
						+ "    </p>");
				RequestDispatcher rd = req.getRequestDispatcher("NewAccount.html");
				rd.include(req, resp);
		 }
		 
		 else if(pd == null) {
			 
			 int i = pdboimp.insert(patient_details);
			 
			 RequestDispatcher rd = req.getRequestDispatcher("greenback.html");
				rd.include(req, resp);
		 }
		 
		 
		 
		 
	}
	
	
	
        
}
