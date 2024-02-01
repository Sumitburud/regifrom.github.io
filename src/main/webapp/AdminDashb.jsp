<%@page import="com.HospitalCarePlus.BO.Doctors_Database_BOimp"%>
<%@page import="com.HospitalCarePlus.BO.Patient_details_BOimp"%>
<%@page import="com.HospitalCarePlus.BO.Patient_Appointment_Details_BOimp"%>
<%@page import="com.HospitalCarePlus.modules.Patient_Appointment_Details" %>>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   
   <%
      Patient_Appointment_Details_BOimp pad = new Patient_Appointment_Details_BOimp();
                           int count1 = pad.count();
                                                                   
                           
      Patient_details_BOimp pd = new Patient_details_BOimp();
        int count2 = pd.count();
        
        Doctors_Database_BOimp db = new Doctors_Database_BOimp();
        int count3 = db.count();
   
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Admin DarshBoard - Care Plus</title>
 <link rel="stylesheet" href="AdminDashb.css" />
</head>
<body>

 <h1 class="dash">ADMIN | DASHBOARD</h1>
	  
    <form action="">
      <div class="dashboard">
        <div class="Myprofile">
          <img src="smile.svg" alt="" />
          <h1>Manage Patients</h1>
          <button class="button1">Total Patients : <%= count2 %> </button>
        </div>
    </form>
    
     <form action="">
        <div class="Myappointments">
          <img src="user-md.svg" alt="" />
          <h1>Manage Doctors</h1>

          <button class="button2">Total Doctors : <%= count3%></button>
        </div>
      </form>
      
       <form action="">
        <div class="BookAppoint">
          <img src="meeting-alt.svg" alt="" />
          <h1>Appointments</h1>
          <button class="button3">Total Appointments : <%= count1 %></button>
        </div>
      </form>
    </div>
    
   
    
    

</body>
</html>