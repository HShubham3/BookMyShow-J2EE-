package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;

@WebServlet(name="submit", urlPatterns="/search")
public class Search extends HttpServlet{
	
	private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		 HttpSession session = req.getSession();
	        Registration u = new Registration(session);
	        try {
	            if(session.getAttribute("id") != null && session.getAttribute("id").equals("1")){
	            String id = req.getParameter("id");
	            req.getRequestDispatcher("search.jsp?id=" + id).forward(req, resp);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		proccessRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		proccessRequest(req,resp);
		
	}

		
	

}
