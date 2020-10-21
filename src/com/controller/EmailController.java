package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmailBean;
import com.service.PlainTextEmailSender;


@WebServlet("/EmailController")
public class EmailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("Send"))
		{
			EmailBean eb = new EmailBean();
			
			eb.setMailto(request.getParameter("to"));
			eb.setMailcc(request.getParameter("cc"));
			eb.setSubject(request.getParameter("subject"));
			eb.setMessage(request.getParameter("message"));
			
			String host = "smtp.gmail.com";
			String port = "587";
			String mailFrom = "cheq123test1@gmail.com";
			String password = "Back@space1";
			
			PlainTextEmailSender mailer = new PlainTextEmailSender();
			
			try {
				
				mailer.sendPlainTextEmail(host,port,mailFrom,password,eb.getMailto(),eb.getMailcc(),eb.getSubject(),eb.getMessage());
				
				response.sendRedirect("admin/adminIndex.jsp");
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}

}
