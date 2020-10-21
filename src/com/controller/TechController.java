package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TechBean;
import com.service.AdminService;
import com.service.TechService;


@WebServlet("/TechController")
public class TechController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("Add Technology"))
		{
			
				TechBean tb = new TechBean();
				
				tb.setT_name(request.getParameter("t_name"));
				tb.setDescription(request.getParameter("description"));
				
				TechService ts = new TechService();
				
				tb = ts.save(tb);
				
				response.sendRedirect("admin/adminIndex.jsp");		
			
		}
		
		
	}

}
