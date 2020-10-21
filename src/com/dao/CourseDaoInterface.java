package com.dao;

import java.util.ArrayList;

public interface CourseDaoInterface<T> {

	public T save(T obj);
	
	public ArrayList<T> getAllCourses();

	
}
