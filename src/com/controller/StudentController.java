package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.StudentBean;
import com.service.StudentService;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		
		if(action.equals("Sign Up"))
		{
			StudentBean sb = new StudentBean();
			
			sb.setFname(request.getParameter("dzFName"));
			sb.setLname(request.getParameter("dzLName"));
			sb.setEmail(request.getParameter("dzEmail"));
			sb.setPassword(request.getParameter("dzPassword"));
			
			StudentService ss = new StudentService();
			
			ss.save(sb);
			
			request.setAttribute("msg", "User Registered");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(action.equals("Login"))
		{
			StudentBean sb = new StudentBean();
			
			sb.setEmail(request.getParameter("dzEmail"));
			sb.setPassword(request.getParameter("dzPassword"));
			
			StudentService ss = new StudentService();
			
			sb = ss.login(sb);	
				
				session.setAttribute("studentUser", sb);
				request.getRequestDispatcher("studentIndex.jsp").forward(request, response);
			
		}
		else if(action.equals("Edit Page"))
		{
			response.sendRedirect("admin/editstudentProfile.jsp");
		}
		else if(action.equals("Update Page"))
		{
			StudentBean sb = new StudentBean();
			int id=0;
			
			sb.setStudentId(Integer.parseInt(request.getParameter("dzStudentId")));
			id = Integer.parseInt(request.getParameter("dzStudentId"));
			sb.setFname(request.getParameter("dzFName"));
			sb.setLname(request.getParameter("dzLName"));
			sb.setEmail(request.getParameter("dzEmail"));
			sb.setPassword(request.getParameter("dzPassword"));
			
			StudentService ss = new StudentService();
			
			ss.update(sb);
			StudentBean sb1 = new StudentBean();
			
			sb1 = ss.getStudentById(id);
			
			session.setAttribute("studentUser", sb);
			request.getRequestDispatcher("admin/editstudentProfile.jsp").forward(request, response);
			
		}
	}

}
