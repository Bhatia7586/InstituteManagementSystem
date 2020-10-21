package com.service;

import java.util.ArrayList;

import com.bean.TechBean;
import com.dao.TechDao;

public class TechService implements TechServiceInterface<TechBean>{

	TechDao td = null;
	
	public TechService() {
		td = new TechDao();
	}
	
	
	@Override
	public TechBean save(TechBean tb) {
		return td.save(tb);
	}
	
	@Override
	public ArrayList<TechBean> getAllTech() {
		return td.getAllTech();
	}
	
	public String getTechById(int a)
	{
		return td.getTechById(a);
	}

	@Override
	public void saveTrainerByTech(ArrayList<Integer> values, int id) {

		td.saveTrainerByTech(values,id);
	}


}
