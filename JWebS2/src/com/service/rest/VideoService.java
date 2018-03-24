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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/video")
public class VideoService {



	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1(@PathParam("id") int id) {
		List st = null;
		try {
			st = (List) videoDetail(id,1);
			for (int i = 0; i < st.size(); i++) {
				VideoDTO sd = (VideoDTO) st.get(i);
				// System.out.println(sd.getByline());
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);    
		}
		return st;
	}

	
	
	public static ArrayList videoDetail(int videoId, int publishedStatus)
		    throws Exception
		  {
		    Connection connection = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    PreparedStatement pstmt1 = null;
		    ResultSet rs1 = null;
		    VideoDTO vDTO = null;
		    ArrayList videoList = new ArrayList();
		    String videoStatus = "";
		    if (publishedStatus == 1) {
		      videoStatus = " and c.published=1 ";
		    }
		    int primaryCategoryLength = 0;
		    String primaryCategory = "161";
		    String[] primaryCategoryId = (String[])null;
		    try
		    {
		    	Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");

		      String sql = "SELECT c.id, c.primary_category, c.title, c.title_alias, c.sef_url, c.byline, c.city, c.courtesy, c.introtext, c.sectionid, c.catid, date_format(c.created,'%M %e, %Y' ) AS crt, c.strap_headline, c.metakey,c.metadesc, c.video_url, c.video_foldername, c.mp4_flag, c.large_kicker_image FROM jos_content c, jos_article_section a where c.id=? and a.section_id='161' and c.id=a.article_id " + 
		      


		        videoStatus + " group by c.id";
		      
		      pstmt = connection.prepareStatement(sql);
		      pstmt.setInt(1, videoId);
		      rs = pstmt.executeQuery();
		      while (rs.next()) {
		        vDTO = new VideoDTO();
		        vDTO.setVideoId(rs.getInt("id"));
		        vDTO.setVideoTitle(rs.getString("title"));
		        vDTO.setSef_url(rs.getString("sef_url"));
		        vDTO.setVideoTitleAlias(rs.getString("title_alias"));
		        vDTO.setVideoByline(rs.getString("byline"));
		        vDTO.setVideoCity(rs.getString("city"));
		        vDTO.setVideoDescription(rs.getString("introtext"));
		        vDTO.setVideoStrapHeadline(rs.getString("strap_headline"));
		        vDTO.setVideoSefTitle(rs.getString("sef_url"));
		        vDTO.setVideoCreatedDate(rs.getString("crt") == null ? "" : rs.getString("crt"));
		        vDTO.setMetaKeywords(rs.getString("metakey"));
		        vDTO.setMetaDescription(rs.getString("metadesc"));
		        vDTO.setVideoCourtesy(rs.getString("courtesy") == null ? "" : rs.getString("courtesy"));
		        vDTO.setPrimaryCategory(rs.getString("primary_category") == null ? "0" : rs.getString("primary_category"));
		        primaryCategory = rs.getString("primary_category");
		        vDTO.setExternalVideoUrl(rs.getString("video_url") == null ? "" : rs.getString("video_url"));
		        vDTO.setVideoFolder(rs.getString("video_foldername") == null ? "" : rs.getString("video_foldername"));
		        vDTO.setMp4VideoFlag(rs.getInt("mp4_flag"));
		        vDTO.setVideoLargeKickerImage(rs.getString("large_kicker_image") == null ? "" : rs.getString("large_kicker_image"));
		        


		        try
		        {
		          if ((primaryCategory != null) && (primaryCategory.trim().length() > 0)) {
		            if ((primaryCategory.indexOf("#") > 0) && (primaryCategory.lastIndexOf("#") < primaryCategory.trim().length())) {
		              primaryCategoryId = primaryCategory.split("#");
		              primaryCategoryLength = primaryCategoryId.length;
		            } else {
		              primaryCategoryId = new String[1];
		              primaryCategoryId[0] = primaryCategory;
		            }
		            primaryCategoryLength = primaryCategoryId.length;
		            String sql1 = "select js.id as jsid, js.title as jstitle, js.sef_url as jssefurl ";
		            if (primaryCategoryLength == 1) {
		              sql1 = sql1 + "from jos_sections js where js.id=" + primaryCategoryId[0];
		            }
		            if (primaryCategoryLength >= 2) {
		              sql1 = sql1 + ", jc.title as jctitle, jc.id as jcid, jc.sef_url as jcsefurl from jos_categories jc, jos_sections js where jc.id=" + primaryCategoryId[1] + " and jc.section=js.id";
		            }
		            



		            pstmt1 = connection.prepareStatement(sql1);
		            rs1 = pstmt1.executeQuery();
		            while (rs1.next())
		            {
		              vDTO.setVideoSectionId(rs1.getInt("jsid"));
		              vDTO.setVideoSectionTitle(rs1.getString("jstitle"));
		              vDTO.setVideoSectionSefTitle(rs1.getString("jssefurl"));
		              
		              if (primaryCategoryLength >= 2) {
		                vDTO.setVideoCategoryId(rs1.getInt("jcid"));
		                vDTO.setVideoCategoryTitle(rs1.getString("jctitle"));
		                vDTO.setVideoCategorySefTitle(rs1.getString("jcsefurl"));
		              }
		              
		            }
		          }
		        }
		        catch (Exception e)
		        {
		          System.out.println("VideoHelper videoDetail Primary Category Detail Exception is :" + e.toString());
		        }
		        
		        vDTO.setPrimaryCategoryLength(primaryCategoryLength);
		        videoList.add(vDTO);
		      }
		    } catch (Exception e) {
		      System.out.println("VideoHelper videoDetail Exception is :" + e);
		    } finally {
		      if (rs != null)
		        rs.close();
		      if (pstmt != null)
		        pstmt.close();
		      if (rs1 != null)
		        rs1.close();
		      if (pstmt1 != null)
		        pstmt1.close();
		      if (connection != null)
		        connection.close();
		    }
		    return videoList;
		  }
		  



	
	
	
	

	
	
}