<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patients Details - CarePlus</title>
    <link rel="stylesheet" href="ClickPatientDetails.css" />
</head>
<body> 

        
         
    <div class="table">
    
        <table>
            <thead>
                <tr>
                    <th>Patient Name</th>
                    <th>Patient Password</th>
                    <th>Contact</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Locality</th>
                    <th>Adhar Number</th>
                    <th>State</th>
                    <th>Country</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="patient" items="${AllPatients}">
                    <tr>
                        <td>${patient.getPatient_Name()}</td>
                        <td>${patient.getPatient_Password()}</td>
                        <td>${patient.getContact()}</td>
                        <td>${patient.getEmail()}</td>
                        <td>${patient.getAddress()}</td>
                        <td>${patient.getLocality()}</td>
                        <td>${patient.getAdhar_Number()}</td>
                        <td>${patient.getState()}</td>
                        <td>${patient.getCountry()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
