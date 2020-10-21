package com.service;

import java.util.ArrayList;

public interface CourseServiceInterface<T> {

public T save(T obj);
	
	public ArrayList<T> getAllCourses();
	
}
