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

@Path("/data1")
public class LatestContentService {

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LatestContent> getjson1() throws SQLException,
			ClassNotFoundException {
		Connection conn = null;
		List<LatestContent> list = new ArrayList<LatestContent>();
		Class.forName("com.mysql.jdbc.Driver");
		try {
			 conn = DriverManager.getConnection(
					"jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");

		} catch (Exception e) {
			e.printStackTrace();   
		}
		Statement stmt = conn.createStatement();
		String sql = "SELECT c.id, c.title,c.introtext,c.sef_url,c.byline,c.medium_image AS medium_image, "
				+ "c.mobile_image AS kicker_image, c.kicker_image_alt_text, js.title AS curcatname, js.id AS curcatid, "
				+ "js.sef_url AS curcatsefurl FROM jos_content c, jos_article_section jas, jos_sections js "
				+ "WHERE jas.section_id=99 AND c.id=jas.article_id AND c.published=1 AND jas.section_id=js.id AND "
				+ "js.published=1   AND c.title NOT LIKE '%href=%' AND c.created>=DATE_SUB(CURDATE(),INTERVAL 700 DAY) "
				+ "GROUP BY c.id ORDER BY jas.ordering DESC LIMIT 5";
		// String sql1 = "select * from jos_content limit 5";
		System.out.println("---> " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			LatestContent lst = new LatestContent(rs.getInt("id"),
					rs.getString("introtext"));
			list.add(lst);
		}

		return list;
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<LatestContent> getXml1() throws SQLException,
			ClassNotFoundException {

		List<LatestContent> list = new ArrayList<LatestContent>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
		Statement stmt = conn.createStatement();
		String sql = "SELECT c.id, c.title,c.introtext,c.sef_url,c.byline,c.medium_image AS medium_image, "
				+ "c.mobile_image AS kicker_image, c.kicker_image_alt_text, js.title AS curcatname, js.id AS curcatid, "
				+ "js.sef_url AS curcatsefurl FROM jos_content c, jos_article_section jas, jos_sections js "
				+ "WHERE jas.section_id=99 AND c.id=jas.article_id AND c.published=1 AND jas.section_id=js.id AND "
				+ "js.published=1   AND c.title NOT LIKE '%href=%' AND c.created>=DATE_SUB(CURDATE(),INTERVAL 700 DAY) "
				+ "GROUP BY c.id ORDER BY jas.ordering DESC LIMIT 2";
		String sql1 = "select * from jos_content limit 10";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			LatestContent lst = new LatestContent(rs.getInt("id"),
					rs.getString("introtext"));
			list.add(lst);
		}

		return list;
	}

}
