<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.HospitalCarePlus.modules.*" %>
    <%@ page import="com.HospitalCarePlus.BO.*"%>
    <%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
  <% 
  
  Doctors_Database_BOimp db = new Doctors_Database_BOimp();
  List<Doctors_Database> AllDocs = db.getAll();

 
  
  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="ClickDoctorsDetails.css" />
</head>
<body>
  <% 
     List<Doctors_Database> docs =(List)session.getAttribute("Doctors");
     
               
   %>
 
 <div class="table">
      <table>
        <tr>
          <th>Doctor Name</th>
          <th>Specialization</th>
          <th>Contact</th>
          <th>Email</th>
        </tr>
        
        
     <c:forEach var="doc" items="${docs}"></c:forEach>
          <tr>
              <td>${docs.getDoc_Name()}</td>
              <td>$</td>
              <td>$</td>
              <td>$</td>       
           </tr>
       
      </table>
    </div>
 

</body>
</html>