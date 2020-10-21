package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.StudentBean;
import com.util.InstituteUtil;

public class StudentDao implements StudentDaoInterface<StudentBean>{

	private static final String table="student";
	Connection con = null;
	
	
	@Override
	public StudentBean save(StudentBean obj) {
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into "+table+" (fname,lname,email,password)VALUES(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, obj.getFname());
			ps.setString(2, obj.getLname());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public StudentBean login(StudentBean obj) {

		StudentBean sb = null;
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setString(1, obj.getEmail());
			ps.setString(2, obj.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				sb = new StudentBean();
				
				sb.setStudentId(rs.getInt(1));
				sb.setFname(rs.getString(2));
				sb.setLname(rs.getString(3));
				sb.setEmail(rs.getString(4));
				sb.setPassword(rs.getString(5));
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return sb;
	}

	@Override
	public StudentBean getStudentById(int id) {
		
		StudentBean sb = null;
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table+" where studentId=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				sb = new StudentBean();
				
				sb.setStudentId(rs.getInt(1));
				sb.setFname(rs.getString(2));
				sb.setLname(rs.getString(3));
				sb.setEmail(rs.getString(4));
				sb.setPassword(rs.getString(5));
			}
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return sb;
	}

	@Override
	public StudentBean update(StudentBean obj) {
	
		
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "UPDATE "+table+" set fname=?,lname=?,email=?,password=? where studentid=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, obj.getFname());
			ps.setString(2, obj.getLname());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());
			ps.setInt(5, obj.getStudentId());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}

}
