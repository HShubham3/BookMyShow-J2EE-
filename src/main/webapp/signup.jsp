<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>

<style type="text/css">
*{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

body{
    /* background-color: burlywood; */
    background-image: url(/assets/loginback);
}

a{
    text-decoration: none;
    color: aliceblue;

}

h1{
    margin-bottom: 20px;
}

input{
    padding: 10px;
    margin-top:5px;
    width:300px;
}

.flex{
    display: flex;
}

.primary-button{
    background-color: rgb(113, 2, 125);
    border-radius: 6px;
    font-weight: 500;
    color: rgb(223, 213, 213) !important;
    padding: 6px 85px;
    transition: 0.25s ease-out;
    text-align: center;
    /* width: 90%; */
}

.primary-button:hover{
    cursor: pointer;
    background-color: rgb(210, 57, 30);
}

.signup-div{
    /* background-color: cadetblue; */
    width: 100%;
    /* align-items: center; */
    justify-content: center;
    gap: 40px;
   
}

.center{
    margin-top:13%;
    background-color: rgba(236, 238, 188, 0.7);
    padding: 30px;
    box-shadow: 10px 10px 5px rgb(236, 238, 188);
}

.name-div{
    gap: 20px;
    padding: 10px;
}

.contact-div{
    gap: 20px;
    padding: 10px;
}

.password-div{
    gap: 20px;
    padding: 10px;
}

.btn{
    /* width: 50%; */

    margin: 30px 6px 0 6px;
    padding: 10px;
}
</style>

</head>
<body>

<form action="register" method="post" class="signup-div flex">

  		<div class="center">
            <h1>Sign Up</h1>
            <div class="name-div flex">
                <div class="fullname">
                    <h4>Full Name</h4><input type="text" placeholder="Enter your name" name="fname">
                </div>
                <div class="username">
                    <h4>Username</h4>
                    <input type="text" placeholder="Enter your usernmae" name="uname">
                </div>
            </div>
            <div class="contact-div flex">
                <div class="emailid">
                    <h4>Email</h4>
                    <input type="email" placeholder="Enter your email" name="email">
                </div>
                <div class="phonenum">
                    <h4>Phone Number</h4>
                    <input type="number" placeholder="Enter your number" name="pno">
                </div>
            </div>
            <div class="password-div flex">
                <div class="emailid">
                    <h4>Password</h4>
                    <input type="password" placeholder="Enter your password" name="pw" id="pw">
                </div>
                <div class="confopassword">
                    <h4>Confirm Password</h4>
                    <input type="password" placeholder="Confirm your password">
                </div>
            </div>

            <input type="submit" class="primary-button btn" name="register" value="Sign Up">
        </div>

	</form>


</body>
</html>