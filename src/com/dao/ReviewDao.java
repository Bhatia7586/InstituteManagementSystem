package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ReviewBean;
import com.util.InstituteUtil;

public class ReviewDao {

	private static final String table="review";
	
	Connection con = null;
	
	public void saveReview(ReviewBean rb) {

		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "INSERT into "+table+" (studentCourse,studentName,studentEmail,review)VALUES(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(qur);
			
			ps.setString(1, rb.getStudentCourse());
			ps.setString(2, rb.getStudentName());
			ps.setString(3, rb.getStudentEmail());
			ps.setString(4, rb.getReview());
			
			ps.executeUpdate();
			
			InstituteUtil.closeConnection();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public ArrayList<ReviewBean> getReview() {
		
		ArrayList<ReviewBean> rlist = new ArrayList<ReviewBean>();
		
		ReviewBean rb = null;
		
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT * from "+table;
			
			PreparedStatement ps = con.prepareStatement(qur);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				rb = new ReviewBean();
				
				rb.setReviewId(rs.getInt(1));
				rb.setStudentCourse(rs.getString(2));
				rb.setStudentName(rs.getString(3));
				rb.setStudentEmail(rs.getString(4));
				rb.setReview(rs.getString(5));
				
				rlist.add(rb);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return rlist;
	}

}
