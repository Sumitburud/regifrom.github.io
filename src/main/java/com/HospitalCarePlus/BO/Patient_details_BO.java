package com.HospitalCarePlus.BO;

import java.util.List;

import com.HospitalCarePlus.modules.Patient_details;

public interface Patient_details_BO {

	
	int insert(Patient_details p);
	
	int delete(String Adhar_Number);
	
	int delete(Patient_details p);
	
	int update(Patient_details p);
	
	Patient_details get(String Adhar_Number);
	
	List<Patient_details>getAll();
	
}
