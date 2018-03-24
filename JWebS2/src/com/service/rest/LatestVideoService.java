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
    
@Path("/videolist")
public class LatestVideoService {

@GET
@Path("/json")   
@Produces(MediaType.APPLICATION_JSON)
public List getjson1() throws Exception {
                               
	List st = null;
	try {    
	st = (List) latestVideo(634, 1, 10, "0");
	for(int i=0;i<st.size();i++){
		ContentTemplateDTO sd = (ContentTemplateDTO) st.get(i);
      
	}    
	}catch(Exception e){
		System.out.println("Exception E: " + e);
	}
	return st;
	
	
}                    
	                  
/*public static void main(String ss[]) throws Exception
{
	System.out.println(latestVideo(634, 1, 10, "0"));    
}
*/
	public static ArrayList latestVideo(int categoryId, int currentPageNum, int contentCount, String contentIdToAvoid)
			throws Exception {
	/*	System.out.println("ContentTemplateHelper.latestVideo() id->" + categoryId + " - page->" + currentPageNum
				+ " - count->" + contentCount + " - idToAvoid->" + contentIdToAvoid);*/
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContentTemplateDTO ccDTO = null;
		ArrayList contentAL = new ArrayList();
		int cutoffDays = 200;   
		String cutoffCheck = "";
		String contentCheck = "";
		String sql = "";
		int vStartLimit = 0;
		int vEndLimit = 0;
		try {
			if (currentPageNum > 0) {
				vStartLimit = (currentPageNum - 1) * contentCount;
			}
			vEndLimit = contentCount;
			if (!contentIdToAvoid.equals("0")) {
				if (contentIdToAvoid.indexOf(",") > 0)
					contentCheck = " and c.id not in (" + contentIdToAvoid + ") ";
				else
					contentCheck = " and c.id != " + contentIdToAvoid + " ";
			}

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");

			if (categoryId > 0) {
				sql = "SELECT c.id, c.title, c.sef_url, c.introtext, c.mobile_image, c.kicker_image, c.kicker_image_alt_text, c.large_kicker_image, c.extra_large_kicker_image, "
						+ "date_format(c.created,'%M %e, %Y' ) AS createddate,  "
						+ "cat.id as catid, cat.title as cattitle, cat.metatitle, cat.metakey, cat.metadesc, cat.sef_url as catsefurl,  "
						+ "s.id as secid, s.title as sectitle, s.sef_url as secsefurl "
						+ "FROM jos_content c, jos_article_section a, jos_categories cat, jos_sections s "
						+ "where c.id=a.article_id  and a.cat_id=" + categoryId
						+ " and c.published=1 and a.cat_id=cat.id "
						+ "and s.published=1 and cat.published=1 and cat.section=s.id " + contentCheck + cutoffCheck
						+ " group by c.id " + "order by a.ordering desc, a.article_id desc limit " + contentCount;
			} else {
				sql = "SELECT c.id, c.title, c.sef_url, c.introtext, c.mobile_image, c.kicker_image, c.kicker_image_alt_text, c.large_kicker_image, c.extra_large_kicker_image, "
						+ "date_format(c.created,'%M %e, %Y' ) AS createddate,  "
						+ "s.id as secid, s.title as sectitle, s.sef_url as secsefurl  "
						+ "  FROM jos_content c, jos_article_section a, jos_sections s "
						+ "where c.id=a.article_id  and a.section_id=161 and c.published=1 and a.section_id=s.id and "
						+ "s.published=1 " + contentCheck + cutoffCheck
						+ " group by c.id order by a.ordering desc, a.article_id desc limit " + contentCount;
			}

			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//System.out.print("IT WAP ContentTemplateHelper.latestVideo() ContentFetch Query->" + sql);

			while (rs.next()) {

				ccDTO = new ContentTemplateDTO();
				ccDTO.setId(rs.getInt("id"));
				ccDTO.setTitle(rs.getString("title") == null ? "" : rs.getString("title"));

				if (rs.getString("sef_url").trim().length() > 0) {
					ccDTO.setContentURL("video/" + rs.getString("sef_url").replaceAll(".html", "") + "/1/"
							+ rs.getInt("id") + ".html");
				}
				             
				ccDTO.setSef_url(rs.getString("sef_url") == null ? "" : rs.getString("sef_url"));
				ccDTO.setMetaTitle(rs.getString("metatitle") == null ? "" : rs.getString("metatitle"));
				ccDTO.setMetaKeyword(rs.getString("metakey") == null ? "" : rs.getString("metakey"));
				ccDTO.setMetaDescription(rs.getString("metadesc") == null ? "" : rs.getString("metadesc"));
				ccDTO.setShortDescription(rs.getString("introtext") == null ? "" : rs.getString("introtext"));
				ccDTO.setCreatedDate(rs.getString("createddate") == null ? "" : rs.getString("createddate"));
				ccDTO.setSmallImage(rs.getString("mobile_image") == null ? "" : rs.getString("mobile_image"));
				ccDTO.setKickerImage(rs.getString("kicker_image") == null ? "" : rs.getString("kicker_image"));
				ccDTO.setLargeImage(
						rs.getString("large_kicker_image") == null ? "" : rs.getString("large_kicker_image"));
				ccDTO.setExtraLargeImage(rs.getString("extra_large_kicker_image") == null ? ""
						: rs.getString("extra_large_kicker_image"));
				ccDTO.setKickerImageAltText(
						rs.getString("kicker_image_alt_text") == null ? "" : rs.getString("kicker_image_alt_text"));

				ccDTO.setSectionId(rs.getInt("secid"));
				ccDTO.setSectionTitle(rs.getString("sectitle") == null ? "" : rs.getString("sectitle"));

				ccDTO.setSectionURL("videos");

				if (categoryId > 0) {
					ccDTO.setCategoryId(rs.getInt("catid"));
					ccDTO.setCategoryTitle(rs.getString("cattitle") == null ? "" : rs.getString("cattitle"));

					if (rs.getString("catsefurl").trim().length() > 0) {
						ccDTO.setCategoryURL("videolist/" + rs.getString("catsefurl").replaceAll(".html", "") + "/1/"
								+ rs.getInt("id") + ".html");
					} else {
						ccDTO.setCategoryURL(
								"videolist/" + rs.getString("catsefurl") + "/1/" + rs.getInt("id") + ".html");
					}

				}
				// ccDTO.setContentDisplayColor(rs.getString("content_display_color")==null?"":rs.getString("content_display_color"));
				contentAL.add(ccDTO);

			}
		} catch (Exception e) {
			System.out.print("IT WAP ContentTemplateHelper.latestVideo() Exception->" + e.toString());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (connection != null)
				connection.close();
		}
		return contentAL;
	}

}
