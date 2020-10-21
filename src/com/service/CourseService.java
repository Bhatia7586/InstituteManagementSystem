package com.service;

import java.util.ArrayList;

import com.bean.CoursesBean;
import com.dao.CourseDao;


public class CourseService implements CourseServiceInterface<CoursesBean> {

	CourseDao cd = new CourseDao();
	
	@Override
	public CoursesBean save(CoursesBean obj) {
		// TODO Auto-generated method stub
		return cd.save(obj);
	}

	@Override
	public ArrayList<CoursesBean> getAllCourses() {
		// TODO Auto-generated method stub
		return cd.getAllCourses();
	}

	public CoursesBean getCourseByCourseName(String c_name) {
		// TODO Auto-generated method stub
		return cd.getCourseByCourseName(c_name);
	}



}
