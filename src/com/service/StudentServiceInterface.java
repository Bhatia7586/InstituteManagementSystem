package com.service;

import com.bean.StudentBean;

public interface StudentServiceInterface<T> {

	//Insert
	public T save(T obj);

	public T login(T obj);
	
	public T getStudentById(int id);

	public T update(T obj);
	
}
