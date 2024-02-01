package com.HospitalCarePlus.modules;

public class Patient_Appointment_Details {

	private int Id ;
	private String Treatment;
	private String Doctor_Name;
	private String Patient_Name;
	private String Appointment_On_Date;
	private String Appointment_On_Time;
	private String Registered_Date;
	private String Registered_Time;
	
	
	public Patient_Appointment_Details() {
		
	}


	


	 public Patient_Appointment_Details(int id, String treatment, String doctor_Name, String patient_Name,
			String appointment_On_Date, String appointment_On_Time, String registered_Date, String registered_Time) {
		super();
		Id = id;
		Treatment = treatment;
		Doctor_Name = doctor_Name;
		Patient_Name = patient_Name;
		Appointment_On_Date = appointment_On_Date;
		Appointment_On_Time = appointment_On_Time;
		Registered_Date = registered_Date;
		Registered_Time = registered_Time;
	}





	public int getId() {
		 return Id;
		 
	 }
	 
	public String getTreatment() {
		return Treatment;
	}


	public void setTreatment(String treatment) {
		Treatment = treatment;
	}


	public String getDoctor_Name() {
		return Doctor_Name;
	}


	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}


	public String getPatient_Name() {
		return Patient_Name;
	}


	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}


	public String getAppointment_On_Date() {
		return Appointment_On_Date;
	}


	public void setAppointment_On_Date(String appointment_On_Date) {
		Appointment_On_Date = appointment_On_Date;
	}


	public String getAppointment_On_Time() {
		return Appointment_On_Time;
	}


	public void setAppointment_On_Time(String appointment_On_Time) {
		Appointment_On_Time = appointment_On_Time;
	}


	public String getRegistered_Date() {
		return Registered_Date;
	}


	public void setRegistered_Date(String registered_Date) {
		Registered_Date = registered_Date;
	}


	public String getRegistered_Time() {
		return Registered_Time;
	}


	public void setRegistered_Time(String registered_Time) {
		Registered_Time = registered_Time;
	}





	@Override
	public String toString() {
		return "Patient_Appointment_Details [Id=" + Id + ", Treatment=" + Treatment + ", Doctor_Name=" + Doctor_Name
				+ ", Patient_Name=" + Patient_Name + ", Appointment_On_Date=" + Appointment_On_Date
				+ ", Appointment_On_Time=" + Appointment_On_Time + ", Registered_Date=" + Registered_Date
				+ ", Registered_Time=" + Registered_Time + "]";
	}


	
	
	
}
