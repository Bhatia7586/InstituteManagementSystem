package com.service;

import java.util.ArrayList;

import com.bean.AdminBean;
import com.bean.CoursesBean;
import com.bean.TechBean;
import com.dao.AdminDao;

public class AdminService implements AdminServiceInterface<AdminService>{

	AdminDao ad = null;
	
	public AdminService() {
		ad = new AdminDao();
	}
	
	public AdminBean adminLogin(AdminBean a)
	{
		return ad.adminLogin(a);
	}

	
}
