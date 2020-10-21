package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bean.TrainerBean;
import com.dao.TrainerDao;

public class TrainerService {

	TrainerDao td = null;
	
	public TrainerService() {
	
		td = new TrainerDao();
	}
	
	public void save(TrainerBean tb) {
		
		td.save(tb);
		
	}
	
	public ArrayList<TrainerBean> getAllTrainers()
	{
		return td.getAllTrainers();
	}

	public void saveHashmap(HashMap<String, ArrayList<Integer>> hm, int id) throws IOException {
		
		td.saveHashmap(hm,id);
		
	}
	
	public HashMap<String, ArrayList<Integer>> getTechnology(int id)
	{
		return td.getTechnology(id);
	}

	public int getIdByEmail(String t_email) {
		return td.getIdByEmail(t_email);
	}
	
	
}
