<%@page import="java.util.*"%>
<%@page import="model.User"%>
<%@page import="model.Registration"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete|Page</title>
</head>


<style>

body{
color:#ffffff;
background:#000000;
}
.table{

margin:8rem auto 0 auto;
	border:2px solid #333333;
	background:#969696;
    
}

th {
padding:25px;
}

</style>

<body>

<%if(session.getAttribute("uname")!= null && session.getAttribute("id").equals("1") && request.getAttribute("status")!=null){%>

<div class="msg"><%=request.getAttribute("status")%></div>

<%} %>


<table class="table">

<thead>
<tr>
<th> slno </th>
<th> Full Name</th>
<th> UserName</th>
<th> Phone </th>
<th> Email</th>
</tr>
</thead>
<tbody>
<%if(session.getAttribute("uname")!= null && session.getAttribute("id").equals("1")){
	Registration reg = new Registration(session);
	ArrayList<User> udata = reg.userList();
	
	Iterator<User> itr = udata.iterator();
	
	while(itr.hasNext()){
		User u =itr.next();%>
		<tr style="color:red;">
		<td><%=u.getId()%></td>
		<td><%=u.getFname()%></td>
		<td><%=u.getUname()%></td>
		<td><%=u.getPhone()%></td>
		<td><%=u.getEmail()%></td>
		<td>
		<form action="delete" method="post">
		<input type="text" name="uid" value="<%=u.getId()%>" style="display:none;" />
		<input type="submit" value="Delete" name="delete"/>
		</form>
		</td>
		</tr>
		
	<%}}%>
</tbody>
</table>
</body>
</html>