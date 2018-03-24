package com.itgd.helper;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.itgd.dto.StoryDto;
import com.itgd.utils.DbConnection;
import com.itgd.utils.StringUtil;

public class StoryHelper {

	
	public List<StoryDto> listStoryById(int id){
		List<StoryDto> list = null;
		Connection connection=null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		StoryDto hdto = null;

		String sql ="";
		try {
			
			DbConnection dbConn = DbConnection.getInstance("ichowk");
			connection = dbConn.getConnection("ichowk");
	
			list = new ArrayList<>();
		    sql = "SELECT c.header_image,c.title,c.id,c.full_description,c.created_by,DATE_FORMAT(c.created_datetime,'%M %e, %Y') AS created,u.id,"
					+ "u.email,u.name,s.id AS catid,s.title AS cattitle FROM ichowk_content c,ichowk_user_profile u,ichowk_category s WHERE "
					+ "c.created_by=u.id AND c.category_id=s.id AND c.id="+id+" ORDER BY c.id DESC LIMIT 1";
		
			
			ps = connection.prepareStatement(sql);
			System.out.println("Story : " + sql);
			//ps.setInt(1, id);   
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				hdto = new StoryDto();
				
				hdto.setTitle(StringUtil.replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));
				hdto.setCatname(StringUtil.replaceSpChrs(new String(rs.getString("cattitle").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setAuthor_name(StringUtil.replaceSpChrs(new String(rs.getString("name").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setFull_description(StringUtil.replaceSpChrs(new String(rs.getString("full_description").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setDatetime(rs.getString("created"));
			   // hdto.setAuth_image(rs.getString("auth_image"));
			    hdto.setHeader_image(rs.getString("header_image"));   
			    list.add(hdto);
			       
			}  
			
		}catch(Exception e) {
       // System.out.println("Exception E: " + e);
			e.printStackTrace();
		}
		
		return list;
	}
	
	
/*	public static void main(String ss[]) throws Exception
	{
		StoryHelper h11 = new StoryHelper();
		List<StoryDto> list = h11.listStoryById(1351);
		
		for(StoryDto h: list) {
			System.out.println(h.getTitle());
		}
		
	}*/
}
