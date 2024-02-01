package com.HospitalCarePlus.BO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.HospitalCarePlus.modules.Patient_Appointment_Details;
import com.HospitalCarePlus.modules.Patient_details;

public class Patient_Appointment_Details_BOimp implements Patient_Appointment_Details_BO {
	

	private static Connection connection = null;
	private static PreparedStatement prepareStatement = null;
	private static Statement createStatement = null;
	private static ResultSet res =null;
	static int i =0;
	
	private static final String INSERT_QUERY = "INSERT into `patient_appointment_details`"
	+"(`Id`, `Treatment`, `Doctor_Name`, `Patient_Name`, `Appointment_On_Date`, `Appointment_On_Time`, `Registered_Date`, `Registered_Time`)"
	+"values(?,?,?,?,?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE from `patient_appointment_details` where `id`=?";
	
	private static final String UPDATE_QUERY = "UPDATE `patient_appointment_details` SET "
	        + "`Treatment`=?,"
	        + "`Doctor_Name`=?,"
	        + "`Patient_Name`=?,"
	        + "`Appointment_On_Date`=?,"
	        + "`Appointment_On_Time`=?,"
	        + "`Registered_Date`=?,"
	        + "`Registered_Time`=? "
	        + "WHERE `id`=?";
	
	private static final String SELECT_QUERY ="SELECT * from `patient_appointment_details` where `id`=?";
	
	private static final String SELECT_ALL_QUERY ="SELECT * from `patient_appointment_details` ";
	
	private static final String COUNT_QUERY = "SELECT COUNT(*) AS row_count FROM `patient_appointment_details`";


	
	
	
	public Patient_Appointment_Details_BOimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","Sumit@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int save(Patient_Appointment_Details p) {
		
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 
			 prepareStatement.setInt(1, p.getId());
			 prepareStatement.setString(2, p.getTreatment());
			 prepareStatement.setString(3, p.getDoctor_Name());
			 prepareStatement.setString(4, p.getPatient_Name());
			 prepareStatement.setString(5,p.getAppointment_On_Date());
			 prepareStatement.setString(6,p.getAppointment_On_Time());
			 prepareStatement.setString(7,p.getRegistered_Date());
			 prepareStatement.setString(8, p.getRegistered_Time());
						 
			 
			  i = prepareStatement.executeUpdate();	 
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return i;
		
	}

	@Override
	public int delete(int Id) {
		
		 try {
				prepareStatement = connection.prepareStatement(DELETE_QUERY);
				prepareStatement.setInt(1, Id);
				
			      i = prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				return i;
	
	}

	@Override
	public int delete(Patient_Appointment_Details p) {
		
		return delete(p.getId());
		
	}

	@Override
	public int update(Patient_Appointment_Details p) {
		
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			 
			
			 prepareStatement.setString(1,p.getTreatment());
			 prepareStatement.setString(2,p.getDoctor_Name());
			 prepareStatement.setString(3,p.getPatient_Name());
			 prepareStatement.setString(4,p.getAppointment_On_Date());
			 prepareStatement.setString(5,p.getAppointment_On_Time());
			 prepareStatement.setString(6,p.getRegistered_Date());
			 prepareStatement.setString(7,p.getRegistered_Time());
			 prepareStatement.setInt(8,p.getId());
						 
			 
			    i = prepareStatement.executeUpdate();
			 
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}

	@Override
	public Patient_Appointment_Details get(int Id) {
		
           try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, Id);
			 res = prepareStatement.executeQuery();
			 	
			
			while (res.next()) {
				
				 int id = res.getInt("Id");
				String treatment = res.getString("Treatment");
				String Doctor_Name = res.getString("Doctor_Name");
				String Patient_Name = res.getString("Patient_Name");
				String Appointment_On_Date = res.getString("Appointment_On_Date");
				String Appointment_On_Time = res.getString("Appointment_On_Time");
				String Registered_Date = res.getString("Registered_Date");
				String Registered_Time = res.getString("Registered_Time");
				
				
				Patient_Appointment_Details pda = new Patient_Appointment_Details(id, treatment, Doctor_Name, Patient_Name, Appointment_On_Date, Appointment_On_Time, Registered_Date, Registered_Time);
				
				
					
				return pda ;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Patient_Appointment_Details> getAll() {
		
	      ArrayList<Patient_Appointment_Details> patients_Details = new ArrayList<Patient_Appointment_Details>();
	      
	      try {
				createStatement = connection.createStatement();
				ResultSet res = createStatement.executeQuery(SELECT_ALL_QUERY);
				

				
				
				while (res.next()) {
					int id = res.getInt("Id");
					String treatment = res.getString("Treatment");
					String Doctor_Name = res.getString("Doctor_Name");
					String Patient_Name = res.getString("Patient_Name");
					String Appointment_On_Date = res.getString("Appointment_On_Date");
					String Appointment_On_Time = res.getString("Appointment_On_Time");
					String Registered_Date = res.getString("Registered_Date");
					String Registered_Time = res.getString("Registered_Time");
					
				
					Patient_Appointment_Details pda = new Patient_Appointment_Details(id, treatment, Doctor_Name, Patient_Name, Appointment_On_Date, Appointment_On_Time, Registered_Date, Registered_Time);
					
					 patients_Details.add(pda);
					
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return patients_Details ;
		

	}

	@Override
	public int count() {
		int rowCount = 0;
		
		 try {
			createStatement = connection.createStatement();
			
			res = createStatement.executeQuery(COUNT_QUERY);
			
			if(res.next()) {
				   rowCount = res.getInt("row_count");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
