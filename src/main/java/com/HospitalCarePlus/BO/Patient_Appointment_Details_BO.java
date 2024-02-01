package com.HospitalCarePlus.BO;

import java.util.List;

import com.HospitalCarePlus.modules.Patient_Appointment_Details;


public interface Patient_Appointment_Details_BO {
	
	int save(Patient_Appointment_Details p);
	
	int delete(int Id);
	
    int delete(Patient_Appointment_Details p);
	
	int update(Patient_Appointment_Details p);
	
	Patient_Appointment_Details get(int Id);
	
	List<Patient_Appointment_Details>getAll();
	
	int count();

}
