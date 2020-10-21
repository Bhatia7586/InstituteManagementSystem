package com.dao;

import java.util.ArrayList;

import com.bean.TechBean;

public interface TechDaoInterface<T> {

	public T save(T tb);

	public ArrayList<T> getAllTech();

	void saveTrainerByTech(ArrayList<Integer> values, int id);

}
