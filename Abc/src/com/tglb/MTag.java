package com.tglb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<p>Today date is: " + new java.util.Date() + "</p>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			
			Statement stmt = conn.createStatement();
			String sql = "select * from p11";
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<table><tr><td>Id</td><td>Name</td></tr>");
			while(rs.next()) {
				out.println("<tr>");
				
				out.println("<td>"+rs.getInt("id")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>"); 
				out.println("</tr>");
				
			}
			out.println("</table>");
			
		} catch (Exception e) {
			System.out.println(" ---> " + e);
		}
	}   

}
