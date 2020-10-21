package com.service;

import java.util.ArrayList;

import com.bean.TechBean;

public interface TechServiceInterface<T> {
	
	
	public T save(T obj);

	public ArrayList<T> getAllTech();

	void saveTrainerByTech(ArrayList<Integer> values, int id);

}
