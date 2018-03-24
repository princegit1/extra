/**
 * 
 */
package com.service.rest;

import java.sql.*;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/h2")
public class H2 {       
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Abc> getXml1() throws SQLException, ClassNotFoundException {   
		//Abc abc = new Abc();
		List<Abc> list = new ArrayList<Abc>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/elections","root","");
		Statement stmt = conn.createStatement();
		String sql = "select * from vip_master";
		ResultSet rs = stmt.executeQuery(sql);    
		while(rs.next()){
			list.add(new Abc(rs.getInt("SLNO"), rs.getString("Candidate_Name"), rs.getString("Party")));
		}
		
		
		return list;
}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Abc> getJSON1() throws SQLException, ClassNotFoundException {   
		//Abc abc = new Abc();
		List<Abc> list = new ArrayList<Abc>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/elections","root","");
		Statement stmt = conn.createStatement();
		String sql = "select * from vip_master";
		ResultSet rs = stmt.executeQuery(sql);    
		while(rs.next()){
			list.add(new Abc(rs.getInt("SLNO"), rs.getString("Candidate_Name"), rs.getString("Party")));
		}
		
		
		return list;
}
}
