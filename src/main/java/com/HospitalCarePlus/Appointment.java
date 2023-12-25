package com.HospitalCarePlus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Appointment extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
		
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String treatement = req.getParameter("Treatement");
		String Doctor = req.getParameter("doctors");
		String Date = req.getParameter("date");
		String Time = req.getParameter("time");
		PrintWriter out = resp.getWriter();
		
		out.print(treatement);
		out.print(Doctor);
		out.print(Date);
		out.print(Time);
		
		
		
	}
	
	@Override
	public void destroy() {
		
		
		
	}
	

}
