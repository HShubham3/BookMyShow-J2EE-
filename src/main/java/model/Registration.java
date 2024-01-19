package model;

import java.sql.*;
import java.util.ArrayList;

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
		String status="",fname="",phone="",email="",date="",id;
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from user where username ='"+username+"'and password='"+password+"'");
		
		boolean b=rs.next();
		if(b) {
			id=rs.getString(1);
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
	
	public ArrayList<User> getUserinfo(String id) throws SQLException{
		
		User u =new User();
		ArrayList<User> al=new ArrayList<User>();
		stmt=con.createStatement();
		String qury = "select * from user where slno='"+id+"'";
		
		rs=stmt.executeQuery(qury);
		
		if(rs.next()) {
			u.setFname(rs.getString("fullname"));
			u.setUname(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			u.setDate(rs.getString("date/time"));
			al.add(u);
		}
		
		return al;
		
	}
	
	public User getUserInfo() throws SQLException {
		
		User u = new User();
		
		stmt = con.createStatement();
		
		String qury="select * from User where slno='"+se.getAttribute("id")+"'";
		
		rs = stmt.executeQuery(qury);
		
		if(rs.next()) {
			u.setFname(rs.getString("fullname"));
			u.setUname(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			
		}
		
		return u;
	}

	public String updateUserData(String fname, String uname, String email, String phone) throws SQLException {
		int count=0;
		String status;
		stmt = con.createStatement();
		String qury="update User set fullname='"+fname+"' ,username='"+uname+"' , email='"+email+"',phone='"+phone+"' where slno='"+se.getAttribute("id")+"'";
		
		count = stmt.executeUpdate(qury);
		
		if(count>0)
			status="success";
		else
			status="failed";
		
		return status;
	}

}
