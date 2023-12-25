package com.HospitalCarePlus.modules;

public class Patient_details {

   private String Patient_Name;
   private String Patient_Password;
   private String Contact;
   private String Email;
   private String Address;
   private String Locality;
   private String Adhar_Number;
   private String State;
   private String Country;
   
   
   public Patient_details() {
	super();
}


public Patient_details(String patient_Name, String patient_Password, String contact, String email, String address,
		String locality, String adhar_Number, String state, String country) {
	super();
	Patient_Name = patient_Name;
	Patient_Password = patient_Password;
	Contact = contact;
	Email = email;
	Address = address;
	Locality = locality;
	Adhar_Number = adhar_Number;
	State = state;
	Country = country;
}


public String getPatient_Name() {
	return Patient_Name;
}


public void setPatient_Name(String patient_Name) {
	Patient_Name = patient_Name;
}


public String getPatient_Password() {
	return Patient_Password;
}


public void setPatient_Password(String patient_Password) {
	Patient_Password = patient_Password;
}


public String getContact() {
	return Contact;
}


public void setContact(String contact) {
	Contact = contact;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


public String getAddress() {
	return Address;
}


public void setAddress(String address) {
	Address = address;
}


public String getLocality() {
	return Locality;
}


public void setLocality(String locality) {
	Locality = locality;
}


public String getAdhar_Number() {
	return Adhar_Number;
}


public void setAdhar_Number(String adhar_Number) {
	Adhar_Number = adhar_Number;
}


public String getState() {
	return State;
}


public void setState(String state) {
	State = state;
}


public String getCountry() {
	return Country;
}


public void setCountry(String country) {
	Country = country;
}


@Override
public String toString() {
	return "Patient_details [Patient_Name=" + Patient_Name + ", Patient_Password=" + Patient_Password + ", Contact="
			+ Contact + ", Email=" + Email + ", Address=" + Address + ", Locality=" + Locality + ", Adhar_Number="
			+ Adhar_Number + ", State=" + State + ", Country=" + Country + "]";
}



   
   
   
   
   
   
   
   
   
	
}
