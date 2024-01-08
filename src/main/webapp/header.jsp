<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>

<nav>
        <div class="nav-top">
            <div class="container first flex">
                <div class="left flex">
                    <img src="./assets/asset99.png" alt="logo">
                    <input type="search" placeholder=" Search for Movies,Events,Plays,Sport and Activities">

                </div>
                <div class="right flex">
                    <select class="right-select">
                        <option value="">Bengaluru</option>
                        <option value="">Mumbai</option>
                        <option value="">Pune</option>
                        <option value="">Dehli-NCR</option>
                        <option value="">Surat</option>
                    </select>
                    <% if (session.getAttribute("uname") != null) {%>
                    <a style="color:#fff;"><i class="fa-solid fa-circle-user" style="padding:5px;"></i><%=session.getAttribute("uname")%></a>
                    <%}else { %>
                    <a href="signin.jsp" class="primary-button">Sign in</a>
                    <a href="#"><i class="fa-solid fa-bars fa-xl" style="color: #f0f2f4;"></i></a>
                    <%} %>
                </div>
            </div>
        </div>
        <div class="nav-bottom">
            <div class="second-nav-section flex container ">
                <div class="sec-left flex">
                    <a href="" class="left-menu">Movies</a>
                    <a href="" class="left-menu">Stream</a>
                    <a href="" class="left-menu">Events</a>
                    <a href="" class="left-menu">Plays</a>
                    <a href="" class="left-menu">Sport</a>
                    <a href="" class="left-menu">Activities</a>
                </div>
                <div class="sec-right flex">
                    <a href="#" class="right-menu">ListYourShow</a>
                    <a href="#" class="right-menu">Corportes</a>
                    <a href="#" class="right-menu">Offers</a>
                    <a href="#" class="right-menu">Gift Cards</a>
                </div>
            </div>
        </div>

    </nav>


</body>
</html>