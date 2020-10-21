package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.bean.CoursesBean;
import com.bean.TechBean;
import com.util.InstituteUtil;

public class CourseDao implements CourseDaoInterface<CoursesBean> {

	private static final String table="courses";
	private static final String table_t="technology";
	Connection con = null;
	
	
	@Override
	public CoursesBean save(CoursesBean obj) {
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into "+table+" (c_name,duration,fees,description,t_id)VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, obj.getC_name());
			ps.setInt(2, obj.getDuration());
			ps.setFloat(3, obj.getFees());
			ps.setString(4, obj.getDescription());
			ps.setInt(5, obj.getT_id());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return null;
	}


	@Override
	public ArrayList<CoursesBean> getAllCourses() {
		
		ArrayList clist = new ArrayList();
		
		CoursesBean cb = null;
		
		
		try {
			
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" LEFT JOIN "+table_t+" on courses.T_ID=technology.TECHID";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cb = new CoursesBean();
				
				
//				System.out.println(cb);
//				cb.setC_name(rs.getString(2));
//				System.out.println(cb.getC_name());
				cb.setCourseId(rs.getInt(1));
				cb.setC_name(rs.getString(2));
				cb.setDuration(rs.getInt(3));
				cb.setFees(rs.getFloat(4));
				cb.setDescription(rs.getString(5));
				cb.setT_id(rs.getInt(6));
				cb.setT_id(rs.getInt(7));
				cb.setT_name(rs.getString(8));
				cb.setT_description(rs.getString(9));
				
				clist.add(cb);
				
			}
			
			
			InstituteUtil.closeConnection();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return clist;
	}


	public CoursesBean getCourseByCourseName(String c_name) {

		CoursesBean cb = null;
		
		
		try {
			
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" where c_name=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setString(1, c_name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cb = new CoursesBean();
				
				cb.setCourseId(rs.getInt(1));
				cb.setC_name(rs.getString(2));
				cb.setDuration(rs.getInt(3));
				cb.setFees(rs.getFloat(4));
				cb.setDescription(rs.getString(5));
				cb.setT_id(rs.getInt(6));
				cb.setT_id(rs.getInt(7));
				cb.setT_name(rs.getString(8));
				cb.setT_description(rs.getString(9));		
			}
			
			
			InstituteUtil.closeConnection();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return cb;
	}

}
