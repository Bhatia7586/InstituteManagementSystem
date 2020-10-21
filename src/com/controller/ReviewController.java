package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ReviewBean;
import com.service.ReviewService;


@WebServlet("/ReviewController")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if(action.equals("Submit Review"))
		{
			ReviewBean rb = new ReviewBean();
			
			rb.setStudentCourse((request.getParameter("studentCourse")));
			rb.setStudentName(request.getParameter("studentName"));
			rb.setStudentEmail(request.getParameter("studentEmail"));
			rb.setReview(request.getParameter("review"));
			
			ReviewService rs = new ReviewService();
			
			rs.saveReview(rb);
			
			response.sendRedirect("studentIndex.jsp");
			
		}
		
	}

}
