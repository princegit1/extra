package com.test;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://10.10.25.242:3306/ichowk";
	private static final String USER="itgd";
	private static final String PASSWORD="itgd@nd@123";	
	
	
	public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
	   
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="select * from ichowk_content limit 10";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(" --> " + new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	}

}
