package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Registration;

 

@WebServlet(name="register" , urlPatterns="/register")

public class register extends HttpServlet {
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		Registration reg = new Registration(session);
		
		
		if(request.getParameter("register")!=null) {
			String fname=request.getParameter("fname");
			String uname=request.getParameter("uname");
			String phone=request.getParameter("pno");
			String email=request.getParameter("email");
			String pw=request.getParameter("pw");
			String cp=request.getParameter("cp");
			
			if(pw.equals(cp)) {
				
				String status="";
				try {
					status = reg.Registration(fname,uname,phone,email,pw);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(status.equals("exist")) {
					request.setAttribute("status", "Existed record");
					RequestDispatcher rd1 = request.getRequestDispatcher("/signup.jsp");
					rd1.forward(request, response);
				}
				else if(status.equals("success")) {
					request.setAttribute("status", "Successfully Registered");
					RequestDispatcher rd1 = request.getRequestDispatcher("/signin.jsp");
					rd1.forward(request, response);
					
				}
				else if(status.equals("failure")) {
					request.setAttribute("status", " Registration Failed");
					RequestDispatcher rd1 = request.getRequestDispatcher("/signup.jsp");
					rd1.forward(request, response);
				}
				
			}
			
		}
		else if(request.getParameter("login")!=null) {
			
			String username=request.getParameter("username");
			String password=request.getParameter("pw");
			
			String status="";
			try {
				status = reg.login(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			if(status.equals("suceess")) {
				request.setAttribute("status", "Successfully Registered");
				RequestDispatcher rd1 = request.getRequestDispatcher("/home.jsp");
				rd1.forward(request, response);
			}
			else if(status.equals("failed")){
				request.setAttribute("status", " Registration Failed");
				RequestDispatcher rd1 = request.getRequestDispatcher("/signin.jsp");
				rd1.forward(request, response);
			}
		}
		else if(request.getParameter("logout")!=null) {
			session.invalidate();
			request.setAttribute("status", " Registration Failed");
			RequestDispatcher rd1 = request.getRequestDispatcher("/home.jsp");
			rd1.forward(request, response);
			
		}
		else if(request.getParameter("submit")!=null){
			
			String fname = request.getParameter("fname");
			String uname=request.getParameter("uname");
			String email = request.getParameter("email");
			String phone =request.getParameter("pno");
			
			String status=reg.updateUserData(fname,uname,email,phone);
			
			if(status.equals("success")) {
				request.setAttribute("status", "Updated successfully");
				RequestDispatcher rd1 = request.getRequestDispatcher("/home.jsp");
				rd1.forward(request, response);
			}
			else {
				request.setAttribute("status", "Failed to update");
				RequestDispatcher rd1 = request.getRequestDispatcher("/edit.jsp");
				rd1.forward(request, response);
			}
			
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
			try {
				processRequest(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
			try {
				processRequest(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	}
	
}
