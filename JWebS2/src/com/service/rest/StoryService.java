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

import com.service.rest.StoryDTO;
@Path("/story")
public class StoryService {    
   

	   
	
	
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1(@PathParam("id") int id) {
		List st = null;
		try {    
		st = (List) storyDetail(id);
		for(int i=0;i<st.size();i++){
		StoryDTO sd = (StoryDTO) st.get(i);
		//System.out.println(sd.getByline());                  
		}    
		}catch(Exception e){
			System.out.println("Exception E: " + e);
		}
		
		return st;   
	}                
	         
	@GET                 
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public List getXml(@PathParam("id") int id) {
		List st = null;
		try {
		st = (List) storyDetail(id);
		for(int i=0;i<st.size();i++){
		StoryDTO sd = (StoryDTO) st.get(i);
		//System.out.println(sd.getByline());                  
		}    
		}catch(Exception e){
			System.out.println("Exception E: " + e);
		}
		return st;
	}
	
	public void nextData(){
		
	}
	
	public void prevData(){
		   
	}
	
	ArrayList storyDetail(int storyId) throws Exception {
		Connection connection;
		PreparedStatement pstmt;
		ResultSet rs;
		PreparedStatement pstmt1;
		ResultSet rs1;
		ArrayList storyData = new ArrayList();
		int primaryCategoryLength;
		connection = null;
		pstmt = null;
		rs = null;
		pstmt1 = null;
		rs1 = null;
		String storyStatus = "";

		storyStatus = " and c.published=1 ";

		primaryCategoryLength = 0;
		String primaryCategory = "0";
		String primaryCategoryId[] = (String[]) null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
			String sql = "SELECT c.images as imagepath, c.blurbs, c.story_syndication, c.id,c.introtext, c.sef_url, c.primary_category, c.title_alias, c.byline, c.city, c.courtesy, c.fulltext, c.metadesc, c.issueid, "
					+ "c.metakey, c.quotes, date_format( c.created,'%W, %M %e, %Y') AS crt, date_format( c.modified,'%W, %M %e, %Y') AS modifieddate, date_format(c.created,'%H:%i') AS ctime, c.large_kicker_image, c.kicker_image_caption, c.large_kicker_image_alt_text "
					+ "FROM jos_content c, jos_article_section a WHERE c.id = ? and a.article_id=c.id and c.published=1 group by c.id";

			pstmt = connection.prepareStatement(sql);                      
			pstmt.setInt(1, storyId);   
			//StoryDTO sDTO = null;    
			rs = pstmt.executeQuery();   
			while (rs.next()) {
				com.service.rest.StoryDTO sDTO = new com.service.rest.StoryDTO();           
				sDTO.setId(rs.getInt("id"));
				sDTO.setSyndicate(rs.getInt("story_syndication"));
				sDTO.setStoryImage(StringUtil.isEmpty(rs.getString("imagepath")));
				sDTO.setFullDescription(StringUtil.isEmpty(rs.getString("fulltext")).replaceAll("\\{table\\}", "")
						.replaceAll("\\{mospagebreak\\}", ""));
				//sDTO.setTitleAlias(StringUtil.isEmpty(rs.getString("fulltext")));          
				sDTO.setByline(StringUtil.isEmpty(rs.getString("byline")));      
				sDTO.setCity(StringUtil.isEmpty(rs.getString("city")));
				sDTO.setSefTitle(StringUtil.isEmpty(rs.getString("sef_url")));
				sDTO.setCreatedDate(StringUtil.isEmpty(rs.getString("crt")));
				sDTO.setIntrotext(StringUtil.isEmpty(rs.getString("introtext")));
				sDTO.setCreatedTime(StringUtil.isEmpty(rs.getString("ctime")));  
				sDTO.setMetaKeyword(StringUtil.isEmpty(rs.getString("metakey")));
				sDTO.setMetaDescription(StringUtil.isEmpty(rs.getString("metadesc")));
				sDTO.setCourtesy(StringUtil.isEmpty(rs.getString("courtesy")));   
				sDTO.setLargeKickerImage(StringUtil.isEmpty(rs.getString("large_kicker_image")));
				sDTO.setLargeKickerImageCaption(StringUtil.isEmpty(rs.getString("kicker_image_caption")));
				sDTO.setLargeKickerImageAltText(StringUtil.isEmpty(rs.getString("large_kicker_image_alt_text")));
				sDTO.setPrimaryCategory(StringUtil.isEmpty(rs.getString("primary_category")));
				sDTO.setIssueId(rs.getInt("issueid"));
				sDTO.setStoryBlurb(StringUtil.isEmpty(rs.getString("blurbs")));
				sDTO.setModifiedDate(StringUtil.isEmpty(rs.getString("modifieddate")));
				sDTO.setStoryQuotes(StringUtil.isEmpty(rs.getString("quotes")));  
				primaryCategory = StringUtil.isEmpty(rs.getString("primary_category"));
				try {
					if (primaryCategory != null && primaryCategory.trim().length() > 0) {
						if (primaryCategory.indexOf("#") > 0
								&& primaryCategory.lastIndexOf("#") < primaryCategory.trim().length()) {
							primaryCategoryId = primaryCategory.split("#");
							primaryCategoryLength = primaryCategoryId.length;
						} else {
							primaryCategoryId = new String[1];
							primaryCategoryId[0] = primaryCategory;
						}
						primaryCategoryLength = primaryCategoryId.length;
						String sql1 = "select js.id as jsid, js.title as jstitle, js.sef_url as jssefurl ";
						switch (primaryCategoryLength) {
						case 1:
							sql1 += " from jos_sections js where js.id=" + primaryCategoryId[0];
							break;
						case 2:
							sql1 += ", jc.title as jctitle, jc.id as jcid, jc.sef_url as jcsefurl from jos_categories jc, jos_sections js where jc.id="
									+ primaryCategoryId[1] + " and jc.section=js.id";
							break;
						case 3:
							sql1 += ", jc.title as jctitle, jc.id as jcid, jc.sef_url as jcsefurl, jsc.title as jsctitle, jsc.id as jscid, jsc.sef_url as jscsefurl from jos_subcategories jsc, jos_sections js, "
									+ "jos_categories jc where jsc.id=" + primaryCategoryId[2]
									+ " and  jsc.category=jc.id and jsc.section=js.id";
							break;
						default:
							sql1 += ", jc.title as jctitle, jc.id as jcid, jc.sef_url as jcsefurl, jc.template_path as jcpath, jsc.title as jsctitle, jsc.id as jscid, jsc.sef_url as jscsefurl, jssc.title as "
									+ "jssctitle, jssc.id as jsscid, jssc.sef_url as jsscsefurl from jos_sub_subcategories jssc, jos_sections js, jos_categories jc, jos_subcategories jsc where jssc.id="
									+ primaryCategoryId[3]
									+ " and jssc.section=js.id and jssc.category=jc.id and jssc.sub_category=jsc.id";
							break;
						}
						pstmt1 = connection.prepareStatement(sql1);
						rs1 = pstmt1.executeQuery();
						while (rs1.next()) {
							sDTO.setSectionId(rs1.getInt("jsid"));
							sDTO.setSectionTitle(StringUtil.isEmpty(rs1.getString("jstitle")));
							//sDTO.setSectionSefTitle(StringUtil.isEmpty(rs1.getString("jssefurl")));
							sDTO.setSectionSefTitle(StringUtil.isEmpty(rs.getString("fulltext")).replaceAll("\\{table\\}", "")
							.replaceAll("\\{mospagebreak\\}", ""));  
							if (primaryCategoryLength >= 2) {
								sDTO.setCategoryId(rs1.getInt("jcid"));
								sDTO.setCategoryTitle(StringUtil.isEmpty(rs1.getString("jctitle")));
								//sDTO.setCategorySefTitle(StringUtil.isEmpty(rs1.getString("jcsefurl")));
								sDTO.setCategorySefTitle(StringUtil.isEmpty(rs.getString("fulltext")).replaceAll("\\{table\\}", "")
										.replaceAll("\\{mospagebreak\\}", ""));
							}
							if (primaryCategoryLength >= 3) {
								sDTO.setSubCategoryId(rs1.getInt("jscid"));
								sDTO.setSubCategoryTitle(StringUtil.isEmpty(rs1.getString("jsctitle")));
								//sDTO.setSubCategorySefTitle(StringUtil.isEmpty(rs1.getString("jscsefurl")));
								sDTO.setSubSubCategorySefTitle(StringUtil.isEmpty(rs.getString("fulltext")).replaceAll("\\{table\\}", "")
										.replaceAll("\\{mospagebreak\\}", ""));
							}
							if (primaryCategoryLength == 4) {
								sDTO.setSubSubCategoryId(rs1.getInt("jsscid"));
								sDTO.setSubSubCategoryTitle(StringUtil.isEmpty(rs1.getString("jssctitle")));
								//sDTO.setSubSubCategorySefTitle(StringUtil.isEmpty(rs1.getString("jsscsefurl")));
								sDTO.setSubSubCategorySefTitle(StringUtil.isEmpty(rs.getString("fulltext")).replaceAll("\\{table\\}", "")
								.replaceAll("\\{mospagebreak\\}", ""));
							}
						}

					}
					if (sDTO.getIssueId() > 0) {
						sql = "SELECT name as issuedate FROM jos_magazine_categories WHERE id = " + sDTO.getIssueId()
								+ "";
						pstmt1 = connection.prepareStatement(sql);
						rs1 = pstmt1.executeQuery();
						if (rs1.next()) {
							sDTO.setIssueDate(StringUtil.isEmpty(rs1.getString("issuedate")));
						}
					}
				} catch (Exception e) {
					System.out.println(
							"BTWAP StoryHelper articleDetail Primary Category Detail Exception is :" + e.toString());
				} finally {
					if (rs1 != null)
						rs1.close();
					if (pstmt1 != null)
						pstmt1.close();
				}
				sDTO.setPrimaryCategoryLength(primaryCategoryLength);
				
			
			storyData.add(sDTO);
		//	storyData.add(sDTO);
			
			
			}
		} catch (Exception e) {
			System.out.println("BTWAP StoryHelper articleDetail Exception is :" + e);
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
		try {      
			Thread.sleep(3000);                
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return storyData;
	}	
	
}
