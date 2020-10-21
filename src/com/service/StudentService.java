package com.service;

import com.bean.StudentBean;
import com.dao.StudentDao;

public class StudentService implements StudentServiceInterface<StudentBean>{

	StudentDao sd = null;
	
	public StudentService() {
		
		sd = new StudentDao();
		
	}
	
	@Override
	public StudentBean save(StudentBean obj) {
		
		return sd.save(obj);
	}
	
	
	
	@Override
	public StudentBean login(StudentBean obj) {
		
		return sd.login(obj);
	}

	@Override
	public StudentBean getStudentById(int id) {
		
		return sd.getStudentById(id);
	}

	@Override
	public StudentBean update(StudentBean obj) {
		// TODO Auto-generated method stub
		return sd.update(obj);
	}

}
