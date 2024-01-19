<%@page import="java.util.*"%>
<%@page import="model.User"%>
<%@page import="model.Registration"%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<style>
.jumbotron{
	 background-color: #333333;
	 margin:0;
}

body{
 
 color:White;
	background-color:#333333;
 
}

.errmsg{
	color:black;
	background-color:red;
	padding:10px;
}

.table{
	margin:0;
}


.fp{
   margin:35px auto;
   border: 5px solid #666666;
   padding:15px;
}

.fp h2{
	font-size:40px;
	color:#666666;
	padding:20px;
	
}
</style>
</head>
<body>

    <%@include file="header.jsp"%>
        
    <center>
        <% if (session.getAttribute("id") != null && session.getAttribute("id").equals("1")) {%>
        <font color="blue" size="4">
        </font>
        
       <div class="fp">
        <h2 style="color:white;"> Search module </h2>
        <form action="search" method="POST">
            <div class="form-group col-md-4">
                <label >Student id:</label>
                <input type="text" name="id" class="form-control" >
            </div>
            <button type="submit" class="btn btn-primary" name="submit">Search</button>
        </form>
        </div>
        <%  if (request.getParameter("id") != null) {%>
        <div class="container ">
            <div class="jumbotron">
            
                <table class="table">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Full Name</th>
                    <th>UserName</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Date</th>

                    </tr>
                    </thead>
                    <tbody id="table">
                        <% Registration reg = new Registration(session);
                            ArrayList<User> userdata = reg.getUserinfo(request.getParameter("id"));
                            Iterator<User> itr = userdata.iterator();
                            if(userdata.isEmpty()){%>
                          <tr>
                             <td style="color:red;">N/A</td>
                             <td style="color:red;">N/A</td>
                             <td style="color:red;">N/A</td>
                             <td style="color:red;">N/A</td>
                             <td style="color:red;">N/A</td>
                        </tr> 
                            	
                            <%}else{%>
                          <%while (itr.hasNext()) {
                                User u = itr.next();
                        %>
                        <tr>
                            <td style="color:white;"><%=u.getFname()%></td>
                            <td style="color:white;"><%=u.getUname()%></td>
                            <td style="color:white;"><%=u.getEmail()%></td>
                            <td style="color:white;"><%=u.getPhone()%></td>
                            <td style="color:white;"><%=u.getDate()%></td>
                        </tr> 
                        <%}}%> 
                    </tbody>
                </table>
            </div>
        </div>
        
<%}}%>
    </center>
    
    
    <%@include file="footer1.jsp"%>


</body>
</html>