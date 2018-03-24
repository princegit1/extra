/**
 * 
 */
package com.service.rest;

import java.sql.*;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/home")
public class HomeService {

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1() throws Exception {
		List<ContentListDTO> listD0 = latestStories("125", 5, "0");
		List<ContentListDTO> listD1 = latestStories("111", 5, "0");
		List<ContentListDTO> listD2 = latestStories("103", 5, "0");
		List<ContentListDTO> listD3 = latestStories("110", 5, "0");
		List<ContentListDTO> listD4 = latestStories("102", 5, "0");
		List<ContentListDTO> listD5 = latestStories("105", 5, "0");
		List<ContentListDTO> listD6 = latestStories("99", 5, "0");
		List<ContentListDTO> listD7 = latestGalleries(0, 5, "0");
		List<ContentListDTO> listD8 = alllatestVideo(5, "0");
		
		
		List list = new ArrayList();
		list.add(listD0);            
		//list.add(listD1);
		//list.add(listD2);
		//list.add(listD3);
		//list.add(listD4);
		//list.add(listD5);
		//list.add(listD6);   
		///list.add(listD7);   
		//list.add(listD8);   
		 return list;
		 
/*		0 mag chunk        125
		1 markets chunk    111
		2 management chunk 103
		3 technology chunk 110
		4 opinion chunk    102
		5 top news         105
		6 Big stories       99
		7 photos       
		8 videos       
*/    
		
		
	}    
	

/*	public static void main(String ss[]) throws Exception
	{
		System.out.println(latestStories("99", 5, "0")); //bigstory
		System.out.println(latestStories("105", 5, "0")); //latest content
	}
	*/
	

	
	 public static ArrayList latestStories(String primaryCatId, int contentCount, String contentIdToAvoid) throws Exception {
	        ArrayList<ContentListDTO> cAL;
	        Connection connection = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        ContentListDTO cDTO = null;
	        cAL = new ArrayList<ContentListDTO>();
	        String contentIdsToCheck = "";
	        if (!contentIdToAvoid.equals("0")) {
	            contentIdsToCheck = !contentIdToAvoid.equals("0") && contentIdToAvoid.indexOf(",") < 0 ? " and c.id != " + contentIdToAvoid + " " : " and c.id not in (" + contentIdToAvoid + ") ";
	        }
	        int pcatlength = 0;
	        String[] pcatids = null;
	        pcatids = primaryCatId.indexOf("#") > 0 ? primaryCatId.split("#") : new String[]{primaryCatId};
	        pcatlength = pcatids.length;
	        int ctr = 0;
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
	            String sql = "select c.id, c.title,c.introtext,c.sef_url,c.byline,c.medium_image as medium_image, c.mobile_image as kicker_image, c.kicker_image_alt_text, ";
	            if (pcatlength == 1) {
	                sql = String.valueOf(sql) + "js.title as curcatname, js.id as curcatid, js.sef_url as curcatsefurl from jos_content c, jos_article_section jas, jos_sections js where jas.section_id=" + pcatids[0] + " and c.id=jas.article_id and c.published=1 and jas.section_id=js.id and js.published=1 ";
	            } else if (pcatlength == 2) {
	                sql = String.valueOf(sql) + "jc.title as curcatname, jc.id as curcatid, jc.sef_url as curcatsefurl from jos_categories jc, jos_content c, jos_article_section jas, jos_sections js where jas.cat_id=" + pcatids[1] + " and c.id=jas.article_id and c.published=1 and jc.id=jas.cat_id  and jc.section=js.id and jc.published=1 and js.published=1 ";
	            } else if (pcatlength == 3) {
	                sql = String.valueOf(sql) + "jsc.title as curcatname, jsc.id as curcatid, jsc.sef_url as curcatsefurl from jos_subcategories jsc, jos_content c, jos_article_section jas, jos_sections js, jos_categories jc where jas.subcat_id=" + pcatids[2] + " and c.published=1 and c.id=jas.article_id and jsc.id=jas.subcat_id and jsc.category=jc.id and jsc.section=js.id and jsc.published=1 and jc.published=1 and js.published=1 ";
	            } else if (pcatlength == 4) {
	                sql = String.valueOf(sql) + "jssc.title as curcatname, jssc.id as curcatid, jssc.sef_url as curcatsefurl from jos_sub_subcategories jssc, jos_content c, jos_article_section jas, jos_sections js, jos_categories jc, jos_subcategories jsc where jas.sub_subcat_id=" + pcatids[3] + " and c.published=1 and c.id=jas.article_id and jssc.id=jas.sub_subcat_id and jsc.id=jas.subcat_id and jc.id=jas.cat_id and js.id=jas.section_id and jssc.published=1 and js.published=1 and jsc.published=1 and jc.published=1 ";
	            }
	            sql = String.valueOf(sql) + " " + contentIdsToCheck + " and c.title not like '%href=%' and c.created>=DATE_SUB(CURDATE(),INTERVAL 400 DAY) group by c.id order by jas.ordering desc limit " + contentCount;
	            pstmt = connection.prepareStatement(sql);
	           // System.out.println("Home Page Data: --- " + sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	                cDTO = new ContentListDTO();
	                cDTO.setId(rs.getInt("id"));
	                cDTO.setTitle(rs.getString("title") == null ? "" : rs.getString("title"));
	                cDTO.setSef_url(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));          
	                cDTO.setByLine(rs.getString("byline") == null ? "" : rs.getString("byline"));
	                cDTO.setFullDescription(rs.getString("introtext") == null ? "" : rs.getString("introtext"));
	                cDTO.setSefTitle(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
	                cDTO.setImage(rs.getString("kicker_image") == null ? "" : rs.getString("kicker_image"));
	                cDTO.setImageAltText(rs.getString("kicker_image_alt_text") == null ? "" : rs.getString("kicker_image_alt_text"));
	                cDTO.setCurrentCategoryId(rs.getInt("curcatid"));
	                cDTO.setCurrentCategoryTitle(rs.getString("curcatname") == null ? "" : rs.getString("curcatname"));
	                cDTO.setCurrentCategorySefTitle(rs.getString("curcatsefurl") == null ? "" : rs.getString("curcatsefurl"));
	                cDTO.setLargeImage(rs.getString("medium_image") == null ? "" : rs.getString("medium_image"));
	                cAL.add(cDTO);
	                ++ctr;
	            }
	        } catch (Exception e) {
	           // System.out.println("global_include.jsp (latestContent for " + primaryCatId + ") Exception is :" + e);
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return cAL;
	    }

	   

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
	                sql = "SELECT g.id,g.Gallery_name, g.mobile_image as mobileImage , g.small_image as smallImage, g.large_image as thumb_image, g.sef_url,s.id AS photo_category, s.name AS photo_catname FROM jos_gallerynames g,jos_sections s WHERE g.section_id ='" + categoryId + "' AND g.published=1 AND g.section_id=s.id AND s.published=1 AND s.section_type='photo' AND s.magazineid=1 ORDER BY g.ordering DESC LIMIT " + countToFetch;
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
	                lcDTO.setSef_url(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
	                lcDTO.setSefTitle(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
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
	        return latestGalleries;
	    }

	 
	 
	 public static ArrayList alllatestVideo(int contentCount, String contentIdToAvoid) throws Exception {
			//	System.out.println("ContentChunkHelper latestVideo() id->"+categoryId+" - count->"+contentCount+" - idToAvoid->"+contentIdToAvoid);
		        ArrayList contentAL = new ArrayList();
		        Connection connection = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        ContentChunkDTO ccDTO = null;
				String contentCheck = "";
				String sql = "";
				int cutoffDays = 0;
				String cutoffCheck = "";

				try {
		    		if(contentIdToAvoid.trim().length() > 0 && !contentIdToAvoid.trim().equals("0")) {
		    			if(contentIdToAvoid.indexOf(",") > 0)
		    				contentCheck = " and c.id not in ("+contentIdToAvoid+") ";
		    			else
		    				contentCheck = " and c.id != "+contentIdToAvoid + " ";
		    		}
		    		Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
		           
		            try {
						/* TEMP COMMENT 
		            	if(categoryId > 0) {
							sql = "SELECT content_fetch_time FROM jos_categories where id="+categoryId;
						} else {
							sql = "SELECT content_fetch_time FROM jos_sections where id=86";
						}
						//System.out.println("IT WAP ContentChunkHelper.latestVideo() ContentInterval Query->" + sql);
						pstmt = connection.prepareStatement(sql);
						rs = pstmt.executeQuery();
						while (rs.next()) {
							cutoffDays = rs.getInt("content_fetch_time");
						}
						*/
		            	cutoffDays=200;
		            	
						if(cutoffDays > 0) {
							cutoffCheck = " and c.created >= DATE_SUB(CURRENT_DATE,INTERVAL "+cutoffDays+" DAY) ";
						}
						sql="";
						pstmt=null;
						rs=null;
		            } catch (Exception ex) {
						System.out.println("IT WAP ContentChunkHelper.latestVideo() ContentInterval Exception->" + ex.toString());
		            }
		            
						/////////// BT QUERY //////////// 
						/*sql = "SELECT c.id, c.title, c.sef_url, c.introtext, c.mobile_image, c.kicker_image, c.kicker_image_alt_text, c.large_kicker_image, c.extra_large_kicker_image, " +
						"date_format(c.created,'%M %e, %Y' ) AS createddate, c.sef_url as content_url, " +
						"cat.id as catid, cat.title as cattitle, cat.sef_url as catsefurl,  " +
						"s.id as secid, s.title as sectitle, s.sef_url as secsefurl,c.sef_url as catcontenturl " +
						"FROM jos_content c, jos_article_section a, jos_categories cat, jos_sections s " +
		    		"where c.id=a.article_id  and a.cat_id="+categoryId+" and c.published=1 and a.cat_id=cat.id " +
		    		"and s.published=1 and cat.published=1 and cat.section=s.id "+contentCheck+cutoffCheck+" group by c.id " +
		    				"order by a.ordering desc, a.article_id desc limit "+contentCount;*/
						
						sql = "SELECT c.publish_up,c.id, c.title, c.sef_url, c.introtext, c.mobile_image, c.kicker_image, c.kicker_image_alt_text, c.large_kicker_image, c.extra_large_kicker_image, " +
						"date_format(c.created,'%M %e, %Y' ) AS createddate, c.sef_url as content_url, " +
						"cat.id as catid, cat.title as cattitle, cat.sef_url as catsefurl,  " +
						"s.id as secid, s.title as sectitle, s.sef_url as secsefurl,c.sef_url as catcontenturl " +
						"FROM jos_content c, jos_article_section a, jos_categories cat, jos_sections s " +
		    		"where c.id=a.article_id  and c.published=1 and a.cat_id=cat.id " +
		    		"and a.section_id=161 and s.published=1 and cat.published=1 and cat.section=s.id "+contentCheck+cutoffCheck+" group by c.id " +
		    				"order by c.publish_up desc limit "+contentCount;
											
					/*	sql = "SELECT c.publish_up,c.id, c.title, c.sef_url, c.introtext, c.mobile_image, c.kicker_image, c.kicker_image_alt_text, c.large_kicker_image, c.extra_large_kicker_image, " +
						"date_format(c.created,'%M %e, %Y' ) AS createddate,  " +
						"s.id as secid, s.title as sectitle, s.sef_url as secsefurl  " +
						"  FROM jos_content c, jos_article_section a, jos_sections s " +
						"where c.id=a.article_id  and a.section_id=161 and c.published=1 and a.section_id=s.id and " +
							"s.published=1 "+contentCheck+cutoffCheck+" group by c.id order by c.publish_up desc limit "+contentCount; */
									
		            pstmt = connection.prepareStatement(sql);
		            rs = pstmt.executeQuery();
					System.out.println("IT WAP ContentChunkHelper.latestVideo() ContentFetch Query->" + sql);

		            while (rs.next()) {
		            	ccDTO = new ContentChunkDTO();
		            	ccDTO.setId(rs.getInt("id"));
		            	ccDTO.setTitle(rs.getString("title") == null ? "" : rs.getString("title"));
		                
		                	if(rs.getString("sef_url").trim().length() > 0) {
		                		ccDTO.setContentURL("video/" + rs.getString("sef_url").replaceAll(".html", "") + "/1/" + rs.getInt("id") + ".html");
		                	}
		                
		            	ccDTO.setShortDescription(rs.getString("introtext") == null ? "" : rs.getString("introtext"));
				        ccDTO.setCreatedDate(rs.getString("createddate") == null ? "" : rs.getString("createddate"));
				        ccDTO.setSef_url(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));  
		            	ccDTO.setSmallImage(rs.getString("mobile_image")==null?"":rs.getString("mobile_image"));
		            	ccDTO.setKickerImage(rs.getString("kicker_image")==null?"":rs.getString("kicker_image"));
		            	ccDTO.setLargeImage(rs.getString("large_kicker_image")==null?"":rs.getString("large_kicker_image"));
		            	ccDTO.setExtraLargeImage(rs.getString("extra_large_kicker_image")==null?"":rs.getString("extra_large_kicker_image"));
		            	ccDTO.setKickerImageAltText(rs.getString("kicker_image_alt_text")==null?"":rs.getString("kicker_image_alt_text"));
		            	//ccDTO.setIsExternalURL(rs.getInt("is_external"));
		            	ccDTO.setIsExternalURL(0);
		            	ccDTO.setSectionId(rs.getInt("secid"));
		                ccDTO.setSectionTitle(rs.getString("sectitle") == null ? "" : rs.getString("sectitle"));
		               	ccDTO.setSectionURL("videos");
		               	ccDTO.setCategoryId(rs.getInt("catid"));
		                ccDTO.setCategoryTitle(rs.getString("cattitle") == null ? "" : rs.getString("cattitle"));
		                
		                if(rs.getString("catsefurl").trim().length() > 0) {
	                		ccDTO.setCategoryURL("videolist/" + rs.getString("catsefurl").replaceAll(".html", "") + "/1/" + rs.getInt("catid") + ".html");
	                	} else {
	                		ccDTO.setCategoryURL("videolist/" + rs.getString("catsefurl") + "/1/" + rs.getInt("catid") + ".html");
	                	}
		                
		            /*    
		    			if(categoryId > 0) {
			                ccDTO.setCategoryId(rs.getInt("catid"));
			                ccDTO.setCategoryTitle(rs.getString("cattitle") == null ? "" : rs.getString("cattitle"));
			                if(rs.getString("catcontenturl") != null && rs.getString("catcontenturl").trim().length() > 0) {
			                	ccDTO.setCategoryURL(rs.getString("catcontenturl"));
			                } else {
			                	if(rs.getString("catsefurl").trim().length() > 0) {
			                		ccDTO.setCategoryURL("videolist/" + rs.getString("catsefurl").replaceAll(".html", "") + "/1/" + rs.getInt("id") + ".html");
			                	} else {
			                		ccDTO.setCategoryURL("videolist/" + rs.getString("catsefurl") + "/1/" + rs.getInt("id") + ".html");
			                	}
			                }
		    			}
		    			*/
		               		
		            	//ccDTO.setContentDisplayColor(rs.getString("content_display_color")==null?"":rs.getString("content_display_color"));
		    			ccDTO.setContentDisplayColor(null);
		                contentAL.add(ccDTO);
		            }
		        } catch (Exception e) {
					System.out.println("IT WAP ContentChunkHelper.latestVideo() Exception->" + e.toString());
		        } finally {
					if(rs!=null)
						rs.close();
					if(pstmt!=null)
						pstmt.close();
					if(connection!=null)
						connection.close();
		        }
		        return contentAL;
		    }

	 
	 
	 
	
}
