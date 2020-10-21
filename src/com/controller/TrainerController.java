package com.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TrainerBean;
import com.dao.TechDao;
import com.service.TechService;
import com.service.TrainerService;


@WebServlet("/TrainerController")
public class TrainerController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("Add Teacher"))
		{
			TrainerBean tb = new TrainerBean();
			
			tb.setT_fname(request.getParameter("t_fname"));
			tb.setT_lname(request.getParameter("t_lname"));
			tb.setT_email(request.getParameter("t_email"));
			tb.setT_quali(request.getParameter("t_quali"));
			tb.setT_exp(request.getParameter("t_exp"));
		
			String technologies[] = request.getParameterValues("t_technology");
			
			
			HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
			ArrayList<Integer> values = new ArrayList<Integer>();
			
			for(String tech : technologies)
			{
				System.out.println(tech);
				tb.setT_technology(Integer.parseInt(tech));
				values.add(Integer.parseInt(tech));
				
			}
			
			hm.put(tb.getT_fname(), values);
			//System.out.println(hm.get(tb.getT_fname()));
			TrainerService ts = new TrainerService();
			
			
			
			ts.save(tb);
			int id = ts.getIdByEmail(tb.getT_email());
			ts.saveHashmap(hm,id);
			
			TechService tech = new TechService();
			tech.saveTrainerByTech(values,id);
			
			response.sendRedirect("admin/adminIndex.jsp");
		}
		
	}

}
