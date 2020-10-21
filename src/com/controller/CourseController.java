package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CoursesBean;
import com.bean.TechBean;
import com.service.AdminService;
import com.service.CourseService;
import com.service.TechService;


@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("Add Course"))
		{
			CoursesBean cb = new CoursesBean();
			
			cb.setC_name(request.getParameter("c_name"));
			cb.setDuration(Integer.parseInt(request.getParameter("duration")));
			cb.setFees(Float.parseFloat(request.getParameter("fees")));
			cb.setDescription(request.getParameter("description"));
			cb.setT_id(Integer.parseInt(request.getParameter("technology")));
			
			CourseService cs = new CourseService();
			
			cs.save(cb);
			
			cb = cs.getCourseByCourseName(cb.getC_name());
			
			ArrayList<Integer> tb = new ArrayList<Integer>();
			tb.add(cb.getCourseId());
			
			TechService tech = new TechService();
			tech.saveTrainerByTech(tb, cb.getT_id());
			
			response.sendRedirect("admin/adminIndex.jsp");
			
		}
		
	}

}
