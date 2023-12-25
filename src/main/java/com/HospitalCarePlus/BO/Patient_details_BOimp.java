package com.HospitalCarePlus.BO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.HospitalCarePlus.modules.Patient_details;


public class Patient_details_BOimp implements Patient_details_BO {
	
	private static Connection connection = null;
	private static PreparedStatement prepareStatement = null;
	private static Statement createStatement = null;
	private static ResultSet res =null;
	
	static int i =0;
	
	private static final String INSERT_QUERY = "INSERT into `patient_details`"
			+ "(`Patient_Name`,`Patient_Password`,`Contact`,`Email`,`Address`,`Locality`,`Adhar_Number`,`State`,`Country`)"
			+ " values(?,?,?,?,?,?,?,?,?)";	
	private static final String DELETE_QUERY = "DELETE from `patient_details` where `id`=?";
	private static final String UPDATE_QUERY ="UPDATE `patient_details` set `Patient_Name`=?,"
			+ "`Patient_Password`=?,`Contact`=?,`Email`=?,`Address`=?,`Locality`=?,`State`=?,`Country`=?"
			+ "where `Adhar_Number`=?";
	private static final String SELECT_QUERY ="SELECT * from `patient_details` where `Adhar_Number`=?";
	private static final String SELECT_ALL_QUERY ="SELECT * from `patient_details` ";
	
	
	
	public Patient_details_BOimp() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","Sumit@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(Patient_details p) {
		
		
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setString(1, p.getPatient_Name());
			 prepareStatement.setString(2, p.getPatient_Password());
			 prepareStatement.setString(3, p.getContact());
			 prepareStatement.setString(4, p.getEmail());
			 prepareStatement.setString(5,p.getAddress());
			 prepareStatement.setString(6,p.getLocality());
			 prepareStatement.setString(7,p.getAdhar_Number());
			 prepareStatement.setString(8, p.getState());
			 prepareStatement.setString(9, p.getCountry());
			 
			 
			  i = prepareStatement.executeUpdate();
			 
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return i;
	}


	@Override
	public int delete(String Adhar_Number) {
		
		 try {
				prepareStatement = connection.prepareStatement(DELETE_QUERY);
				prepareStatement.setString(1, Adhar_Number);
				
			      i = prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				return i;
	}

	@Override
	public int delete(Patient_details p) {
		delete(p.getAdhar_Number());
		return delete(p.getAdhar_Number());
	}

	@Override
	public int update(Patient_details p) {
		
		 try {
				prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				
				 prepareStatement.setString(1, p.getPatient_Name());
				 prepareStatement.setString(2, p.getPatient_Password());
				 prepareStatement.setString(3, p.getContact());
				 prepareStatement.setString(4, p.getEmail());
				 prepareStatement.setString(5,p.getAddress());
				 prepareStatement.setString(6,p.getLocality());
				 prepareStatement.setString(7, p.getState());
				 prepareStatement.setString(8, p.getCountry());
				 prepareStatement.setString(9,p.getAdhar_Number());
				 
				  i = prepareStatement.executeUpdate();
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return i;	
	
	}

	@Override
	public Patient_details get(String Adhar_Number) {

		
		try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setString(1, Adhar_Number);
			 res = prepareStatement.executeQuery();
			 	
			
			while (res.next()) {
				
				String Name = res.getString("Patient_Name");
				String Password = res.getString("Patient_Password");
				String Contact = res.getString("Contact");
				String Email = res.getString("Email");
				String Address = res.getString("Address");
				String Locality = res.getString("Locality");
				String Adhar_Number2 = res.getString("Adhar_Number");
				String State = res.getString("State");
				String Country = res.getString("Country");
				
				Patient_details patient_details = new Patient_details(Name, Password, Contact, Email, Address, Locality, Adhar_Number2, State, Country);
					
				return patient_details;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Patient_details> getAll() {
		
       ArrayList<Patient_details> patients = new ArrayList<Patient_details>();
		
		try {
			createStatement = connection.createStatement();
			ResultSet res = createStatement.executeQuery(SELECT_ALL_QUERY);
			

			
			
			while (res.next()) {
				
				String Name = res.getString("Patient_Name");
				String Password = res.getString("Patient_Password");
				String Contact = res.getString("Contact");
				String Email = res.getString("Email");
				String Address = res.getString("Address");
				String Locality = res.getString("Locality");
				String Adhar_Number = res.getString("Adhar_Number");
				String State = res.getString("State");
				String Country = res.getString("Country");
				
				Patient_details patient_details = new Patient_details(Name, Password, Contact, Email, Address, Locality, Adhar_Number, State, Country);
					
				
				patients.add(patient_details);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patients;
		
	}

}
