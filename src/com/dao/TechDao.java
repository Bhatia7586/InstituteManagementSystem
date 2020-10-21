package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.bean.TechBean;
import com.bean.TrainerBean;
import com.util.InstituteUtil;

public class TechDao implements TechDaoInterface<TechBean>{

	private static final String table="technology";
	Connection con = null;
	
	
	@Override
	public TechBean save(TechBean tb) {
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into "+table+" (t_name,description)VALUES(?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, tb.getT_name());
			ps.setString(2, tb.getDescription());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ArrayList<TechBean> getAllTech() {
		
		ArrayList<TechBean> tlist = new ArrayList<TechBean>();
		
		TechBean tb = null;
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table;
			
			PreparedStatement ps = con.prepareStatement(qur);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				tb = new TechBean();
				
				tb.setTechId(rs.getInt(1));
				tb.setT_name(rs.getString(2));
				tb.setDescription(rs.getString(3));
				
				tlist.add(tb);
			}
			
			InstituteUtil.closeConnection();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return tlist;
	}

	public String getTechById(int a) {
		
		TechBean tb = null;
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" where techId=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setInt(1, a);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				tb = new TechBean();
				
				tb.setT_name(rs.getString(2));
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return tb.getT_name();
	}

	public ArrayList<TrainerBean> getTrainerByTechId(int t)
	{
		TrainerBean tb = null;
		
		ArrayList<TrainerBean> list = new ArrayList<TrainerBean>();
		
		try {
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from trainertech where technologyId=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setInt(1, t);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				tb = new TrainerBean();
				
				tb.setTrainerid(rs.getInt(3));
				
				list.add(tb);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return list;
		
	}

	@Override
	public void saveTrainerByTech(ArrayList<Integer> values, int id) {
		
		System.out.println(values);
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into trainertech(technologyId,trainerId)values(?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			Iterator<Integer> it = values.iterator();

			while(it.hasNext())
			{
				ps.setInt(1, it.next());
				ps.setInt(2, id);
				ps.addBatch();
			}
			int[] numUpdates = ps.executeBatch();
			
			for(int i =0 ;i< numUpdates.length;i++)
			{
				if (numUpdates[i] == -2)
				      System.out.println("Execution " + i + 
				        ": unknown number of rows updated");
				    else
				      System.out.println("Execution " + i + 
				        "successful: " + numUpdates[i] + " rows updated");
				  
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}
