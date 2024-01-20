<%@page import="java.util.*"%>
<%@page import="model.User"%>
<%@page import="model.Registration"%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit|Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    <style>
        td input{
            display:block;
        }
        .jumbotron{
            background-color: #FFFFFF;
        }
    </style>
</head>
<body>
        <%@include file="header.jsp"%>
    <center>
        <% if (session.getAttribute("uname") != null) {
                Registration reg = new Registration(session);
                User u = reg.getUserInfo();%>
        <form action='register' method='POST'>
            <div class="container ">
               
                <div class="jumbotron">
                <h1> EDITE PROFILE</h1>
                <div class="form-group col-md-4">
                        <label>UserName</label>
                        <input type="text" class="form-control"  name="uname" value="<%=u.getUname()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label >Full Name</label>
                        <input type="text" class="form-control"  name="fname" value="<%=u.getFname()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label >Phone Number</label>
                        <input type="number" class="form-control"  name="pno" value="<%=u.getPhone()%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label >Email</label>
                        <input type="email" class="form-control"  name="email" value="<%=u.getEmail()%>">
                    </div>
                    <button type="submit" class="btn btn-primary" name="submit">Update</button>
                </div>
            </div>
        </form>
        <%}%> 
    </center>
    <%@include file="footer1.jsp"%>
s

</body>
</html>