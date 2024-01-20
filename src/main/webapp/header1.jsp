<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
 <link rel="stylesheet" href="style.css">
 <style>
 
 .option a{
    text-decoration: none;
    display: inline-block;
    color:#fff;
}
 
 </style>
</head>
<body>

	<nav>
        <div class="nav-top">
            <div class="container first flex">
                <div class="left flex">
                    <img src="./assets/asset99.png" alt="logo">
                    <input type="search" placeholder="Search for Movies,Events,Plays,Sport and Activities">

                </div>
                <div class="right flex">
                    <select class="right-select">
                        <option value="">Bengaluru</option>
                        <option value="">Mumbai</option>
                        <option value="">Pune</option>
                        <option value="">Dehli-NCR</option>
                        <option value="">Surat</option>
                    </select>
                    <% if (session.getAttribute("uname") != null) {
                     if (session.getAttribute("id").equals("1")){%>
                    <div class="option"><a href="delete.jsp">Delete</a></div>
                    <div class="option"><a href="search.jsp">Search</a></div>
                    <%}%>
                    <div class="option"><a href="edit.jsp" >Edit</a></div>
                    <div class="option" ><a href="register?logout=yes" class="primary-button">Logout</a></div>
                    <div style="color:#fff;"><i class="fa-solid fa-circle-user" style="padding:5px;"></i><%=session.getAttribute("uname")%></div>
                    <%}else { %>
                    <a href="signin.jsp" class="primary-button">Sign in</a>
                    <a href="#"><i class="fa-solid fa-bars fa-xl" style="color: #f0f2f4;"></i></a>
                    <%}%>
                </div>
            </div>
        </div>

    </nav>


</body>
</html>