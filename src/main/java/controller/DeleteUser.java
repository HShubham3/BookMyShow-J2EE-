package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;

@WebServlet(name="delete",urlPatterns="/delete")
public class DeleteUser extends HttpServlet {
	
	protected void proccessReuest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		if(req.getParameter("delete")!=null) {
			
			String id = req.getParameter("uid");
			
			String status=new Registration(session).deleteUser(id); 
			
			if(status.equals("success")) {
				req.setAttribute("status", "Successfully user removed.");
				req.getRequestDispatcher("DeleteUser.jsp").forward(req, resp);
			}
			else if(status.equals("failed")) {
				req.setAttribute("status", "Failed to remove user");
				req.getRequestDispatcher("DeleteUser.jsp").forward(req, resp);
			}
			
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			proccessReuest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			proccessReuest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
