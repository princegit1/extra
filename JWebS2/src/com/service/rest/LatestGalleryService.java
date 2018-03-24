/**
 * 
 */
package com.service.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/gallerylist")
public class LatestGalleryService {

   	
	@GET
	@Path("/json")   
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1() throws Exception {
	                               
		List st = null;
		try {    
		st = (List) latestGalleries(38, 15, "0");    
		for(int i=0;i<st.size();i++){
			ContentListDTO sd = (ContentListDTO) st.get(i);
	           
		}    
		}catch(Exception e){
			System.out.println("Exception E: " + e);
		}
		return st;
		
		                                     
	}                
	
/*	public static void main(String ss[]) throws Exception   
	{
		System.out.println(latestGalleries(38, 15, "0"));   
	}
	*/

	 public static ArrayList latestGalleries(int categoryId, int countToFetch, String galleryIdToAvoid) throws Exception {
	        ArrayList<ContentListDTO> latestGalleries;
	        latestGalleries = new ArrayList<ContentListDTO>();
	        Connection connection = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        ResultSet rs_pc = null;
	        ContentListDTO lcDTO = null;
	        String galleryCheck = "";
	        String sql = "";
	        if (!galleryIdToAvoid.equals("0")) {
	            galleryCheck = galleryIdToAvoid.indexOf(",") > 0 ? "and gn.id not in (" + galleryIdToAvoid + ")" : "and gn.id != " + galleryIdToAvoid;
	        }
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
	            if (categoryId == 0) {
	                sql = "SELECT g.id,g.Gallery_name,g.mobile_image as mobileImage , g.small_image as smallImage, g.large_image as thumb_image, g.sef_url,s.id AS photo_category, s.name AS photo_catname FROM jos_gallerynames g,jos_sections s WHERE g.section_id IN('38','39') AND g.published=1 AND g.section_id=s.id AND s.published=1 AND s.section_type='photo' AND s.magazineid=1 ORDER BY g.ordering DESC LIMIT " + countToFetch;
	            } else {
	                sql = "SELECT g.id,g.Gallery_name, g.mobile_image as mobileImage, g.small_image as smallImage, g.large_image as thumb_image, g.sef_url,s.id AS photo_category, s.name AS photo_catname FROM jos_gallerynames g,jos_sections s WHERE g.section_id ='" + categoryId + "' AND g.published=1 AND g.section_id=s.id AND s.published=1 AND s.section_type='photo' AND s.magazineid=1 ORDER BY g.ordering DESC LIMIT " + countToFetch;
	              System.out.println("sql---" + sql);
	            }
	            pstmt = connection.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            sql = "";
	            pstmt = null;
	            while (rs.next()) {    
	                lcDTO = new ContentListDTO();   
	                lcDTO.setId(rs.getInt("id"));
	                lcDTO.setTitle(rs.getString("Gallery_name") == null ? "" : rs.getString("Gallery_name"));
	                lcDTO.setSefTitle(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
	                lcDTO.setSef_url(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
	                lcDTO.setImage(rs.getString("thumb_image") == null ? "" : rs.getString("thumb_image"));
	                lcDTO.setImageAltText(rs.getString("Gallery_name") == null ? "" : rs.getString("Gallery_name"));
	                lcDTO.setImageAltText(rs.getString("Gallery_name") == null ? "" : rs.getString("Gallery_name"));
	                lcDTO.setSmallImage(rs.getString("smallImage") == null ? "" : rs.getString("smallImage"));
	                lcDTO.setMobileImage(rs.getString("mobileImage") == null ? "" : rs.getString("mobileImage"));
	                lcDTO.setCurrentCategoryTitle(StringUtil.isEmpty(rs.getString("photo_catname")).toLowerCase().replaceAll(" ", "-"));
	                latestGalleries.add(lcDTO);
	            }
	        } catch (Exception e) {
	            System.out.println("IT CommonFunctions.java-mustsee-Exception is :" + e);
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (rs_pc != null) {
	                rs_pc.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }   
	        try {                         
				Thread.sleep(3000);    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        return latestGalleries;      
	    }   

	 
	 
}
