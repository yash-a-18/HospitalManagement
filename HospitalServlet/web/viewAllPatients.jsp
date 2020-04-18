<%-- 
    Document   : viewAllPatients
    Created on : Apr 18, 2020, 7:47:02 PM
    Author     : DC
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Doc_Signed In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
 <style>
        body{
  background-image: url("136949.jpg");
  background-repeat:no-repeat;
  background-attachment: fixed;
  background-position: center; 
       background-size:cover;
       }
    </style>
<body>
    
    <%
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet resultset=null;
        
    %>
    
    
    
    
	<div class="container-fluid">
  <br>
  <h2>Hospital Management System</h2>
  <p>Place where all your problems are cured.</p>
  </div>

<nav class="navbar navbar-expand-sm bg-dark navbar-white sticky-top justify-content-left">
    <a class="navbar-brand" href="#">
    <img src="logo.jpg" alt="logo" style="width:70px;">
  </a>
    
    <a class="nav-link" href="Doc_signedin.jsp">Appointments</a>
    
    <a class="nav-link" href="viewAllPatients.jsp">Consultations</a>
  
    <ul class="navbar-nav ml-auto">
    <li class="nav-item mr-sm-5">
        <a class="nav-brand" href="reg_patient.html">
            <img src="patient_admissoon.png" alt="Register Patient" style="width:40px">
        </a>
    </li>
  </ul>
    
    <form class="form-inline" action="# ">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
</nav>

    <div class="container table-responsive">
  <h2>Patient List</h2>         
  <table class="table table-hover table-light">
    <thead>
      <tr>
          <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Age</th>
        <th>Date of Admission</th>
        <!--<th>Status</th>-->
        <th>Bill Amount</th>
        <th>Profile</th>
      </tr>
    </thead>
    <tbody>
        <%try{
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","");
        pst=connection.prepareStatement("SELECT pat_id,pat_name,pat_gender,pat_age,pat_doa FROM patient");
        resultset=pst.executeQuery();
        while(resultset.next()){
%>
      <tr>
        <td><%=resultset.getString("pat_id")%></td>
        <td><%=resultset.getString("pat_name")%></td>
        <td><%=resultset.getString("pat_gender")%></td>
        <td><%=resultset.getString("pat_age")%></td>
        <td><%=resultset.getString("pat_doa")%></td>
        <td>00.00</td>
        <td><a href="viewPatient.jsp">view</a><td>
      </tr>
      <%
        }
        connection.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      %>
    </tbody>
  </table>
</div>
    
</body>
</html>
