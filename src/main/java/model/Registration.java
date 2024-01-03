package model;

import java.sql.*;

import javax.servlet.http.HttpSession;

public class Registration {
	
	HttpSession se=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;

	public Registration(HttpSession session) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/showbooking", "root", "root");
			se=session;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String Registration(String fname, String uname, String phone, String email, String pw) throws SQLException {
		
		String status="";
		
		
		stmt=con.createStatement();
		rs = stmt.executeQuery("select * from user where phone='" + phone + "' or email='" + email + "';");
		boolean b=rs.next();
		
		if(b) {
			status="exist";
		}
		else {
			 
			pstmt=con.prepareStatement("insert into user values(0,?,?,?,?,?,now())");
			pstmt.setString(1, fname);
			pstmt.setString(2, uname);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, pw);
			int x=pstmt.executeUpdate();
			
			if(x>0) {
				status="success";
			}
			else {
				status="failure";
			}
		}
		
		return status;
	}

	public String login(String username, String password) throws SQLException {
		String status="",fname="",phone="",email="",date="";
		int id=0;
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from user where username ='"+username+"'and password='"+password+"'");
		
		boolean b=rs.next();
		if(b) {
			id=rs.getInt(1);
			fname=rs.getString(2);
			email=rs.getString(4);
			phone=rs.getString(5);	
			date=rs.getString(7);	
			
            se.setAttribute("fname", fname);
            se.setAttribute("uname", username);
            se.setAttribute("id", id);
            se.setAttribute("date", date);
            se.setAttribute("email", email);
            se.setAttribute("phone", phone);
			
			status="suceess";
			
		}
		else {
			status="failed";
		}
		
		
		return status;
	}
	

}
