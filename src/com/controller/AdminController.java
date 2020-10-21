package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.bean.CoursesBean;
import com.bean.TechBean;
import com.service.AdminService;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		if(action.equals("Login"))
		{
			AdminBean a = new AdminBean();
			
			a.setA_uname(request.getParameter("a_uname"));
			a.setA_password(request.getParameter("a_password"));
		
			AdminService as = new AdminService();
			
			AdminBean ab = as.adminLogin(a);
			
				session.setAttribute("adminUser", ab);
				//request.getRequestDispatcher("admin/adminIndex.jsp").forward(request, response);
				response.sendRedirect("admin/adminIndex.jsp");
			
//			else
//			{
//				request.setAttribute("msg", "Wrong username or password");
//				request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
//			}
						
		}
		
		
		

	}

}
