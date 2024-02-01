package com.HospitalCarePlus.BO;

import java.util.List;

import com.HospitalCarePlus.modules.Doctors_Database;


public interface Doctors_Database_BO {

	
    int save(Doctors_Database db);
	
	int delete(String Doc_Id);
	
    int delete(Doctors_Database p);
	
	int update(Doctors_Database p);
	
	Doctors_Database get(String Doc_Id);
	
	List<Doctors_Database>getAll();
	
	int count();
}
