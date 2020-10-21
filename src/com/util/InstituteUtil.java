package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class InstituteUtil {

	private static Connection con = null;
	
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/instmgt";
	private static final String USER="root";
	private static final String PASSWORD="";
	
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			try {
				
				Class.forName(DRIVER_NAME);
				con = DriverManager.getConnection(URL,USER,PASSWORD);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return con;
	}
	
	
	
	public static void closeConnection()
	{
		try {
			if(con != null && !con.isClosed())
			{
				con.close();
			}
			
			con=null;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
