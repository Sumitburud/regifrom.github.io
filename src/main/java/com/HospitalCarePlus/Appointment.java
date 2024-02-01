package com.HospitalCarePlus;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HospitalCarePlus.BO.Patient_Appointment_Details_BOimp;
import com.HospitalCarePlus.modules.Doctors_Database;
import com.HospitalCarePlus.modules.Patient_Appointment_Details;

public class Appointment extends HttpServlet {
		
	static int count = 1;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String treatement = req.getParameter("Treatement");
		String Doctor = req.getParameter("doctors");
		String Date = req.getParameter("date");
		String Time = req.getParameter("Atptime");
	
		LocalDate AptDate = LocalDate.now();
		LocalTime AptTime = LocalTime.now();
		count++;
		 Patient_Appointment_Details_BOimp pd = new Patient_Appointment_Details_BOimp();  
		 Patient_Appointment_Details p = new Patient_Appointment_Details(count, treatement, Doctor, Doctor, Date, Time, Date, Time);
		 int i = pd.save(p);
		
		 
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("Success.jsp");
			 requestDispatcher.include(req, resp);
			 
			 
			  
			  
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
		 
		 
		 }
	
	
	
	
	
	
	
	
			
			 
		
		
		
		
		
	
		
		
		
	
	
	@Override
	public void destroy() {
		
		
		
	}
	

}
