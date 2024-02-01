package com.HospitalCarePlus.BO;

import java.util.ArrayList;
import java.util.List;

import com.HospitalCarePlus.modules.Doctors_Database;
import com.HospitalCarePlus.modules.Patient_Appointment_Details;
import com.HospitalCarePlus.modules.Patient_details;



public class Application {

	public static void main(String[] args) {
		Patient_details_BOimp pboimp = new Patient_details_BOimp();
		
		
////		
//		Patient_details pd = new Patient_details("Marutiii", "Maruti@123", "9349861252", "maruti@gmail.com","5th main BTM layout", "BTM layout","201022224444","Karnataka","India");
////		
//		int update = pboimp.update(pd);
////		int i = pboimp.delete(pd);
////		
////		 Patient_details_BOimp  pdboimp   = new Patient_details_BOimp();
////		    
////	     Patient_details patient_details = pdboimp.get(pd.getAdhar_Number());
////		
////		System.out.println(patient_details.getPatient_Name());
		
		
		ArrayList<Patient_details> all = pboimp.getAll();
		for (Patient_details patient_details : all) {
			
			System.out.print(patient_details.getPatient_Name());
			System.out.print(patient_details.getPatient_Password());
			System.out.print(patient_details.getContact());
			System.out.print(patient_details.getContact());
			System.out.print(patient_details.getEmail());
			System.out.print(patient_details.getAddress());
			System.out.print(patient_details.getLocality());
			System.out.print(patient_details.getAdhar_Number());
			System.out.println(patient_details.getState());
			System.out.println(patient_details.getCountry());
			System.out.println();
			
		}
		
		
		
		
		
//		Patient_Appointment_Details_BOimp pdboimp = new Patient_Appointment_Details_BOimp();
//		Patient_Appointment_Details pAD = new Patient_Appointment_Details(1, "abc", "abc", "abc", "abc", "abc", "AbC", "ABC");
//		int save = pdboimp.save(pAD);
//		int delete = pdboimp.delete(2);
		
//		int delete = pdboimp.delete(pAD.getId());
		
		
//		  Patient_Appointment_Details pda = new Patient_Appointment_Details(1, null, null, null, null, null, null, null);
//		Patient_Appointment_Details pda = pdboimp.get(1);
		
//		List<Patient_Appointment_Details> all = pdboimp.getAll();
//		
//		for (Patient_Appointment_Details patient_Appointment_Details : all) {
//			System.out.println(patient_Appointment_Details);
//			
//		}
//		
//		int count = pdboimp.count();
//		System.out.println(count);
		
		
		
		
//		Doctors_Database_BOimp db_imp = new Doctors_Database_BOimp();
		
//		Doctors_Database db = new Doctors_Database("Doc5", "Sandeep Ihole", 24, "Basic Treatment", "Sandy@123");
		
//		int save = db_imp.save(db);
		
//		int delete = db_imp.delete("abc");
		
//		int update = db_imp.update(db);
		
//		Doctors_Database doctors_Database = db_imp.get("Doc4");
		
//		int count = db_imp.count();
		
//		System.out.println(count);
		
		
		
		
		

		
		
		
		
//		
		
		
	}

}
