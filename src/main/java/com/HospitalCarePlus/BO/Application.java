package com.HospitalCarePlus.BO;

import com.HospitalCarePlus.modules.Patient_details;

public class Application {

	public static void main(String[] args) {
		Patient_details_BOimp pboimp = new Patient_details_BOimp();
		
		Patient_details pd = new Patient_details("Maruti", "Maruti@123", "9349861252", "maruti@gmail.com","5th main BTM layout", "BTM layout","201022224444","Karnataka","India");
		
		int i = pboimp.delete(pd);
		
		 Patient_details_BOimp  pdboimp   = new Patient_details_BOimp();
		    
	     Patient_details patient_details = pdboimp.get(pd.getAdhar_Number());
		
		System.out.println(patient_details.getPatient_Name());
		
	}

}
