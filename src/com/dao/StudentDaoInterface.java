package com.dao;

import com.bean.StudentBean;

public interface StudentDaoInterface<T> {

	public T save(T obj);

	public T login(T obj);

	public T getStudentById(int id);

	public T update(T obj);
	
}
