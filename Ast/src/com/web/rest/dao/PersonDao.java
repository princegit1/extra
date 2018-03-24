package com.web.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.rest.dto.Person;
import com.web.util.DbConnection;

public class PersonDao {

	public List<Person> getList() {
		List<Person> list = new ArrayList<Person>();
		try {
			Connection conn = DbConnection.getInstance().getConnection();
			//String sql = "select * from t";
			String sql = "SELECT * FROM `jos_content` ORDER BY id  DESC LIMIT 50";   
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Person p = null;
			while (rs.next()) {
				p = new Person();
				p.setId(rs.getInt("id"));   
				p.setName(replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));                   
				p.setIntrotext(replaceSpChrs(new String(rs.getString("introtext").getBytes("ISO-8859-1"), "UTF-8")));    
				p.setKickerimage(rs.getString("kicker_image"));
				p.setModified(rs.getString("modified"));           
				list.add(p);    
			}          

		} catch (Exception e) {
			System.out.println("Exception E: " + e);  
		}
		return list;

	}   
	
	
	public List<Person> getListbyId(int id) {
		List<Person> list = new ArrayList<Person>();
		try {
			Connection conn = DbConnection.getInstance().getConnection();
			//String sql = "select * from t";
			String sql = "SELECT * FROM `jos_content` where id=? LIMIT 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);      
			ResultSet rs = ps.executeQuery();
			Person p = null;
			while (rs.next()) {
				p = new Person();
				p.setId(rs.getInt("id"));   
				p.setName(replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));                   
				p.setIntrotext(replaceSpChrs(new String(rs.getString("introtext").getBytes("ISO-8859-1"), "UTF-8")));    
				p.setKickerimage(rs.getString("kicker_image"));
				p.setFulltext(replaceSpChrs(new String(rs.getString("fulltext").getBytes("ISO-8859-1"), "UTF-8")));      
				p.setModified(rs.getString("modified"));           
				list.add(p);    
			}          

		} catch (Exception e) {
			System.out.println("Exception E: " + e);  
		}
		return list;

	}   
	
	
	
	
	public static String replaceSpChrs(String str)
	  {
	    String data = str;
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢", "'");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã…â€œ")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã…â€œ", "\"");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬?")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬?", "\"");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã‚?")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã‚?", "\"");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬?")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬?", "-");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬Å“")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬Å“", "'");
	    }
	    if (data.contains("&amp;quot;")) {
	      data = data.replaceAll("&amp;quot;", "\"");
	    }
	    if (data.contains("&amp;iuml;")) {
	      data = data.replaceAll("&amp;iuml;", "i");
	    }
	    if (data.contains("&amp;eacute;")) {
	      data = data.replaceAll("&amp;eacute;", "e");
	    }
	    if (data.contains("&amp;#39;")) {
	      data = data.replaceAll("&amp;#39;", "'");
	    }
	    if (data.contains("&amp;quot;")) {
	      data = data.replaceAll("&amp;quot;", "\"");
	    }
	    if (data.contains("&amp;hellip;")) {
	      data = data.replaceAll("&amp;hellip;", "Ã¢â‚¬Â¦");
	    }
	    if (data.contains("&ecirc;")) {
	      data = data.replaceAll("&ecirc;", "e");
	    }
	    if (data.contains("&agrave;")) {
	      data = data.replaceAll("&agrave;", "a");
	    }
	    if (data.contains("&amp;egrave;")) {
	      data = data.replaceAll("&amp;egrave;", "e");
	    }
	    if (data.contains("&ndash;")) {
	      data = data.replaceAll("&ndash;", "-");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¦")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¦", "Ã¢â‚¬Â¦");
	    }
	    if (data.contains("ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“")) {
	      data = data.replaceAll("ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“", "'");
	    }
	    if (data.contains("&frac12;")) {
	      data = data.replaceAll("&frac12;", "Ã‚Â½");
	    }
	    if (data.contains("&ordm;")) {
	      data = data.replaceAll("&ordm;", "Ã‚Â°");
	    }
	    if (data.contains("&frac34;")) {
	      data = data.replaceAll("&frac34;", "Ã‚Â¾");
	    }
	    if (data.contains("&frac14;")) {
	      data = data.replaceAll("&frac14;", "Ã‚Â¼");
	    }
	    return data;
	  }
	

}
