package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.AdminBean;
import com.util.InstituteUtil;

public class AdminDao implements AdminDaoInterface<AdminBean>{

	private static final String table="admin";
	
	Connection con = null;
	
	public AdminBean adminLogin(AdminBean a) {
	
		AdminBean ba = null;
		try {
			
			con = InstituteUtil.getConnection();
			
			String qur = "SELECT *from "+table+" where a_uname=? AND a_password=?";
			
			PreparedStatement ps = con.prepareStatement(qur);
			ps.setString(1, a.getA_uname());
			ps.setString(2, a.getA_password());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ba = new AdminBean();
				
				ba.setAdminId(rs.getInt(1));
				ba.setA_name(rs.getString(2));
				ba.setA_uname(rs.getString(3));
				ba.setA_email(rs.getString(4));
				ba.setA_password(rs.getString(5));
			}
			
			InstituteUtil.closeConnection();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ba;
	}

	


}
