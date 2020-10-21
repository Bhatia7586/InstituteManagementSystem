package com.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.bean.TrainerBean;
import com.util.InstituteUtil;

public class TrainerDao {

	private static final String table="trainer";
	private static final String table_t="technology";
	Connection con = null;
	
	public void save(TrainerBean tb) {
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into "+table+" (t_fname,t_lname,t_email,t_quali,t_exp,t_technology)VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, tb.getT_fname());
			ps.setString(2, tb.getT_lname());
			ps.setString(3, tb.getT_email());
			ps.setString(4, tb.getT_quali());
			ps.setString(5, tb.getT_exp());
			ps.setInt(6, tb.getT_technology());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public ArrayList<TrainerBean> getAllTrainers() {
		
		ArrayList<TrainerBean> tlist = new ArrayList<TrainerBean>();
		
		TrainerBean tb = null;
		
		try {
con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" LEFT JOIN "+table_t+" on trainer.T_TECHNOLOGY=technology.TECHID";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				tb = new TrainerBean();
				
				tb.setTrainerid(rs.getInt(1));
				tb.setT_fname(rs.getString(2));
				tb.setT_lname(rs.getString(3));
				tb.setT_email(rs.getString(4));
				tb.setT_quali(rs.getString(5));
				tb.setT_exp(rs.getString(6));
				tb.setT_technology(rs.getInt(8));
				tb.setTech_name(rs.getString(9));
				
				tlist.add(tb);
				
			}
			InstituteUtil.closeConnection();
			
		}catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		
		return tlist;
	}

	public void saveHashmap(HashMap<String, ArrayList<Integer>> hm, int id) throws IOException {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		int key1 = id;
		System.out.println("Fname for entry->"+key1);
		oos.writeObject(hm);
		oos.flush();
		oos.close();
		bos.close();
		
		byte[] data = bos.toByteArray();
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT INTO test(testobj,trainer_id)VALUES(?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			//ps.setInt(1, 1);
			
			ps.setObject(1, data);
			ps.setInt(2, id);
			
			System.out.println(ps.executeUpdate());
			
			InstituteUtil.closeConnection();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public HashMap<String, ArrayList<Integer>> getTechnology(int id) {
		
		HashMap<String, ArrayList<Integer>> me = null;
		System.out.println("int Id ->"+id);
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from test where trainer_id=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				ByteArrayInputStream bais;
				
				ObjectInputStream ins;
				
				bais = new ByteArrayInputStream(rs.getBytes("testobj"));
				
				ins = new ObjectInputStream(bais);
				
				 me = (HashMap<String, ArrayList<Integer>>)ins.readObject();
				
				ins.close();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(me);
		
		return me;
	}

	public int getIdByEmail(String t_email) {

		TrainerBean tb = null;
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" where t_email=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setString(1, t_email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				tb = new TrainerBean();
				
				tb.setTrainerid(rs.getInt(1));
			}
			InstituteUtil.closeConnection();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return tb.getTrainerid();
	}

}
