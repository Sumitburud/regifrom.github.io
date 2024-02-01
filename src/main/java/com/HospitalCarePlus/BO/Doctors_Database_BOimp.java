package com.HospitalCarePlus.BO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.HospitalCarePlus.modules.Doctors_Database;
import com.HospitalCarePlus.modules.Patient_Appointment_Details;

public class Doctors_Database_BOimp implements Doctors_Database_BO{
	
	private static Connection connection = null;
	private static PreparedStatement prepareStatement = null;
	private static Statement createStatement = null;
	private static ResultSet res =null;
	static int i =0;
	
	private static final String INSERT_QUERY = "INSERT into `doctors_database`"
	+"(`Doc_Id`, `Doc_Name`, `Doc_Age`, `Doc_Speciality`, `Doc_Password`)"
	+"values(?,?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE from `doctors_database` where `Doc_Id`=?";
	
	private static final String UPDATE_QUERY = "UPDATE `doctors_database` SET `Doc_Name`=?, `Doc_Age`=?, "
			+ "`Doc_Speciality`=?, `Doc_Password`=? where `Doc_Id`=?";
	     
	
	private static final String SELECT_QUERY ="SELECT * from `doctors_database` where `Doc_Id`=?";
	
	private static final String SELECT_ALL_QUERY ="SELECT * from `doctors_database` ";
	
	private static final String COUNT_QUERY = "SELECT COUNT(*) AS row_count FROM `doctors_database`";
	

	public Doctors_Database_BOimp() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","Sumit@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int save(Doctors_Database db) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 
			 prepareStatement.setString(1, db.getDoc_Id());
			 prepareStatement.setString(2, db.getDoc_Name());
			 prepareStatement.setInt   (3, db.getDoc_Age());
			 prepareStatement.setString(4, db.getDoc_Speciality());
			 prepareStatement.setString(5, db.getDoc_Password());
			
						 
			 
			  i = prepareStatement.executeUpdate();	 
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int delete(String Doc_Id) {
		
		 try {
				prepareStatement = connection.prepareStatement(DELETE_QUERY);
				prepareStatement.setString(1, Doc_Id);
				
			      i = prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				return i;
	}

	@Override
	public int delete(Doctors_Database db) {
		return delete(db.getDoc_Id());
	}

	@Override
	public int update(Doctors_Database db) {
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			 
			
			 prepareStatement.setString(1,db.getDoc_Name());
			 prepareStatement.setInt   (2,db.getDoc_Age());
			 prepareStatement.setString(3,db.getDoc_Speciality());
			 prepareStatement.setString(4,db.getDoc_Password());
			 prepareStatement.setString(5,db.getDoc_Id());
			
						 
			 
			    i = prepareStatement.executeUpdate();
			 
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}

	@Override
	public Doctors_Database get(String Doc_Id) {
		
        try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setString(1, Doc_Id);
			 res = prepareStatement.executeQuery();
			 	
			
			while (res.next()) {
				
				 String Doc_id = res.getString("Doc_Id");
				String Doc_Name = res.getString("Doc_Name");
				int Doc_Age = res.getInt("Doc_Age");
				String Doc_Speciality = res.getString("Doc_Speciality");
				String Doc_Password = res.getString("Doc_Password");
				
				Doctors_Database db = new Doctors_Database(Doc_Id, Doc_Name, Doc_Age, Doc_Speciality, Doc_Password);
				
				
					
				return db ;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Doctors_Database> getAll() {
		
  ArrayList<Doctors_Database> patients_Details = new ArrayList<Doctors_Database>();
	      
	      try {
				createStatement = connection.createStatement();
				ResultSet res = createStatement.executeQuery(SELECT_ALL_QUERY);
				

				
				
				while (res.next()) {
					   String Doc_id = res.getString("Doc_Id");
						String Doc_Name = res.getString("Doc_Name");
						int Doc_Age = res.getInt("Doc_Age");
						String Doc_Speciality = res.getString("Doc_Speciality");
						String Doc_Password = res.getString("Doc_Password");
						
						
						Doctors_Database db = new Doctors_Database(Doc_id, Doc_Name, Doc_Age, Doc_Speciality, Doc_Password);
					
				
			
					
					 patients_Details.add(db);
					
					
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
