package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(false);
		
	
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			String action = request.getParameter("action");
			
			if(action.equalsIgnoreCase("adminlogout"))
			{
				if(session!=null)
				{session.invalidate();}
				response.sendRedirect("loginAdmin.jsp");
			}
			else if(action.equalsIgnoreCase("studentlogout"))
			{
				if(session!=null)
				{session.invalidate();}
				
				response.sendRedirect("loginStudent.jsp");
			}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		

			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			String action = request.getParameter("action");
			
			if(action.equals("adminlogout"))
			{
				session.invalidate();
				response.sendRedirect("loginAdmin.jsp");
			}
			else if(action.equals("studentlogout"))
			{
				session.invalidate();
				response.sendRedirect("loginStudent.jsp");
			}
			
		}

}
