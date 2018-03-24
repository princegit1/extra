package com.itgd.helper;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.itgd.dto.HomeDto;
import com.itgd.utils.DbConnection;
import com.itgd.utils.StringUtil;

public class HomeHelper {

	
	public List<HomeDto> listStory(){
		List<HomeDto> list = null;
		Connection connection=null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeDto hdto = null;

		String sql ="";
		try {
			
			DbConnection dbConn = DbConnection.getInstance("ichowk");
			connection = dbConn.getConnection("ichowk");
	
			list = new ArrayList<>();
			sql = "SELECT c.small_image,c.title,c.id,c.short_description,c.created_by,DATE_FORMAT(c.created_datetime,'%M %e, %Y') AS created,u.id,u.email,u.name FROM ichowk_content c,ichowk_user_profile u WHERE c.created_by=u.id ORDER BY c.id DESC LIMIT 600,2";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				hdto = new HomeDto();
				hdto.setId(rs.getInt("id"));  
				hdto.setTitle(StringUtil.replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setAuthor_name(StringUtil.replaceSpChrs(new String(rs.getString("name").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setShort_desc(StringUtil.replaceSpChrs(new String(rs.getString("short_description").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setDatetime(rs.getString("created"));
			    // hdto.setAuth_image(rs.getString("auth_image"));
			    hdto.setSmall_image(rs.getString("small_image"));
			    list.add(hdto);
			          
			}
			
		}catch(Exception e) {
       // System.out.println("Exception E: " + e);
			e.printStackTrace();
		}
		
		return list;
	}   
	public List<HomeDto> listCat(){
		List<HomeDto> list = null;
		Connection connection=null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeDto hdto = null;

		String sql ="";
		try {
			
			DbConnection dbConn = DbConnection.getInstance("ichowk");
			connection = dbConn.getConnection("ichowk");
	
			list = new ArrayList<>();
			sql = "select * from ichowk_category";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				hdto = new HomeDto();
				hdto.setId(rs.getInt("id"));  
				//hdto.setTitle(StringUtil.replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setCattitle(StringUtil.replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));
			    list.add(hdto);
			          
			}
			
		}catch(Exception e) {
       // System.out.println("Exception E: " + e);
			e.printStackTrace();
		}
		
		return list;
	}   
	public List<HomeDto> listStoryBycatid(int catid){
		List<HomeDto> list = null;
		Connection connection=null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeDto hdto = null;
		int cutOffDays=2100;                     

		String sql ="";
		try {
			
			DbConnection dbConn = DbConnection.getInstance("ichowk");
			connection = dbConn.getConnection("ichowk");
	
			list = new ArrayList<>();
			/*sql = "SELECT c.small_image,c.category_id,c.title,c.id,c.short_description,c.created_by,DATE_FORMAT(c.created_datetime,'%M %e, %Y') AS \r\n" + 
					"created,u.id,u.email,u.name,s.id AS catid,s.title AS cattitle FROM ichowk_content c,ichowk_user_profile u,ichowk_category s WHERE \r\n" + 
					"c.category_id=s.id AND s.id="+catid+" ORDER BY c.id DESC LIMIT 500,5";  */
			/*sql = "SELECT c.id,c.small_image,c.category_id,c.title,c.short_description,c.created_by,DATE_FORMAT(c.created_datetime,'%M %e, %Y') AS \r\n" + 
					"created,s.id AS catid,s.title AS cattitle FROM ichowk_content c,ichowk_category s WHERE \r\n" + 
					"c.published=1 AND s.published=1 AND c.category_id=s.id AND s.id="+catid+" AND c.created_datetime >= DATE_SUB(CURRENT_DATE,INTERVAL "+cutOffDays+" DAY) ORDER BY c.id DESC LIMIT 4";          
			*/
			
			sql="SELECT c.id,c.site_id,c.created_by,c.small_image,c.category_id,c.title,c.short_description,c.created_by,DATE_FORMAT(c.created_datetime,'%M %e, %Y') AS " +
			"created,s.id AS catid,s.title AS cattitle,s.site_id,u.id,u.name,u.site_id,u.email,u.social_screen_name,u.profile_image_url FROM ichowk_content c,ichowk_category s,ichowk_user_profile u WHERE " +
			"c.created_by=u.id AND c.published=1 AND s.published=1 AND c.category_id=s.id AND s.id="+catid+" AND c.created_datetime >= DATE_SUB(CURRENT_DATE,INTERVAL "+cutOffDays+" DAY) ORDER BY c.id DESC LIMIT 4";

			System.out.println("sql: " + sql);        
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);                                   
			while(rs.next()) {     
				hdto = new HomeDto();
				hdto.setId(rs.getInt("id"));  
				hdto.setTitle(StringUtil.replaceSpChrs(new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setAuthor_name(StringUtil.replaceSpChrs(new String(rs.getString("name").getBytes("ISO-8859-1"), "UTF-8")));
			    hdto.setAuth_scren_name(rs.getString("social_screen_name"));   
			    hdto.setAuth_img(rs.getString("profile_image_url"));
			    hdto.setShort_desc(StringUtil.replaceSpChrs(new String(rs.getString("short_description").getBytes("ISO-8859-1"), "UTF-8")));   
			    hdto.setDatetime(rs.getString("created"));
			   // hdto.setAuth_image(rs.getString("auth_image"));
			    hdto.setSmall_image(rs.getString("small_image"));
			    list.add(hdto);   
			             
			}  
			
		}catch(Exception e) {
       // System.out.println("Exception E: " + e);
			e.printStackTrace();
		}
		    
		return list;  
	}   
	
	
	/*public static void main(String ss[]) throws Exception
	{
		HomeHelper h11 = new HomeHelper();
		List<HomeDto> list = h11.listCat();
		//System.out.println("--> " + list);
		
		for(HomeDto h: list) {
			System.out.println(h.getId() + " - " + h.getCattitle());
		}
		
	}*/
}
