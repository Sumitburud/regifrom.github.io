package com.HospitalCarePlus.modules;

public class Doctors_Database {
	
	
	
	
	private String Doc_Id;
	private String Doc_Name;
	private int Doc_Age;
	private String Doc_Speciality;
	private String Doc_Password;
	
	
	public Doctors_Database() {
		
	}


	public Doctors_Database(String doc_Id, String doc_Name, int doc_Age, String doc_Speciality, String doc_Password) {
		super();
		Doc_Id = doc_Id;
		Doc_Name = doc_Name;
		Doc_Age = doc_Age;
		Doc_Speciality = doc_Speciality;
		Doc_Password = doc_Password;
	}


	public String getDoc_Name() {
		return Doc_Name;
	}


	public void setDoc_Name(String doc_Name) {
		Doc_Name = doc_Name;
	}


	public int getDoc_Age() {
		return Doc_Age;
	}


	public void setDoc_Age(int doc_Age) {
		Doc_Age = doc_Age;
	}


	public String getDoc_Speciality() {
		return Doc_Speciality;
	}


	public void setDoc_Speciality(String doc_Speciality) {
		Doc_Speciality = doc_Speciality;
	}


	public String getDoc_Password() {
		return Doc_Password;
	}


	public void setDoc_Password(String doc_Password) {
		Doc_Password = doc_Password;
	}


	public String getDoc_Id() {
		return Doc_Id;
	}


	@Override
	public String toString() {
		return "Doctors_Database [Doc_Id=" + Doc_Id + ", Doc_Name=" + Doc_Name + ", Doc_Age=" + Doc_Age
				+ ", Doc_Speciality=" + Doc_Speciality + ", Doc_Password=" + Doc_Password + "]";
	}
	
	
	


}
