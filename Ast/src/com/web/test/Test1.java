package com.web.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.util.DbConnection;

public class Test1 {

	public static void main(String[] args) {
		Connection conn = DbConnection.getInstance().getConnection();
		String sql = "select * from p11";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));  
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		

	}

}
