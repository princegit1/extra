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

@Path("/latest")
public class LatestStoryTemplateService {

	@GET
	@Path("/section/json/{id}/{offset}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1(@PathParam("id") int id, @PathParam("offset") int offset) {
		List st = null;
		try {
			st = (List) latestStoriesTemplate(id, 10, offset, "0", 2);
	
			for (int i = 0; i < st.size(); i++) {
				StoryListDTO sd = (StoryListDTO) st.get(i);
				// System.out.println(sd.getByline());
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		return st;
	}
	
	@GET
	@Path("/section1/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson11(@PathParam("id") int id) {
		List st = null;                      
		try {
			st = (List) latestStoriesTemplate(id, 10, 1, "0", 2);
	
			for (int i = 0; i < st.size(); i++) {
				StoryListDTO sd = (StoryListDTO) st.get(i);
				// System.out.println(sd.getByline());
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		return st;
	}
	@GET
	@Path("/category/json/{id}/{offset}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson2(@PathParam("id") int id, @PathParam("offset") int offset) {
		List st = null;
		try {
			// st = (List) latestStoriesTemplate(id, 10, offset, "0", 2);
			for (int i = 0; i < st.size(); i++) {
				StoryDTO sd = (StoryDTO) st.get(i);
				// System.out.println(sd.getByline());
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		return st;
	}

	public static ArrayList latestStoriesTemplate(int catId, int contentCount, int offset, String contentIdToAvoid,
			int catLevel) throws Exception {
		ArrayList<StoryListDTO> cAL;
		Connection connection;
		PreparedStatement pstmt;
		ResultSet rs;
		String contentIdsToCheck;
		int ctr;
		connection = null;
		pstmt = null;
		rs = null;
        if(offset>1){
        	offset = offset*10;              
        }
		StoryListDTO cDTO = null;
		cAL = new ArrayList<StoryListDTO>();
		contentIdsToCheck = "";
		if (catLevel != 1 && catLevel != 2 && catLevel != 3 && catLevel != 4) {
			catLevel = 1;
			catId = 120;
		}
		if (!contentIdToAvoid.equals("0")) {
			contentIdsToCheck = contentIdToAvoid.equals("0") || contentIdToAvoid.indexOf(",") >= 0
					? (new StringBuilder(" and c.id not in (")).append(contentIdToAvoid).append(") ").toString()
					: (new StringBuilder(" and c.id != ")).append(contentIdToAvoid).append(" ").toString();
		}
		ctr = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");
			String sql = "select c.id, c.title,c.sef_url,c.byline, c.mobile_image as kicker_image, c.kicke"
					+ "r_image_alt_text, ";
			if (catLevel == 1) {
				sql = (new StringBuilder(String.valueOf(String.valueOf(sql))))
						.append("js.title as stitle, js.id as sid, js.sef_url as sseftitle, js.metatitle, js.meta"
								+ "key, js.metadesc ")
						.append("from jos_content c, jos_article_section jas, jos_sections js where jas.section_i"
								+ "d=")
						.append(catId)
						.append(" and c.id=jas.article_id and c.published=1 and jas.section_id=js.id and js.publi"
								+ "shed=1 ")
						.toString();
			} else if (catLevel == 2) {
				sql = (new StringBuilder(String.valueOf(String.valueOf(sql))))
						.append("js.title as stitle, js.id as sid, js.sef_url as sseftitle, jc.title as ctitle, j"
								+ "c.id as cid, jc.sef_url as cseftitle, jc.metatitle, jc.metakey, jc.metadesc ")
						.append("from jos_categories jc, jos_content c, jos_article_section jas, jos_sections js "
								+ "where jas.cat_id=")
						.append(catId)
						.append(" and c.id=jas.article_id and c.published=1 and jc.id=jas.cat_id  and jc.section="
								+ "js.id and jc.published=1 and js.published=1 ")
						.toString();
			} else if (catLevel == 3) {
				sql = (new StringBuilder(String.valueOf(String.valueOf(sql))))
						.append("js.title as stitle, js.id as sid, js.sef_url as sseftitle, jc.title as ctitle, j"
								+ "c.id as cid, jc.sef_url as cseftitle, ")
						.append("jsc.title as sctitle, jsc.id as scid, jsc.sef_url as scseftitle, jsc.metatitle, "
								+ "jsc.metakey, jsc.metadesc ")
						.append("from jos_subcategories jsc, jos_content c, jos_article_section jas, jos_sections"
								+ " js, jos_categories jc where jas.subcat_id=")
						.append(catId)
						.append(" and c.published=1 and c.id=jas.article_id and jsc.id=jas.subcat_id and jsc.cate"
								+ "gory=jc.id and jsc.section=js.id and jsc.published=1 and jc.published=1 and js.p"
								+ "ublished=1 ")
						.toString();
			} else if (catLevel == 4) {
				sql = (new StringBuilder(String.valueOf(String.valueOf(sql))))
						.append("js.title as stitle, js.id as sid, js.sef_url as sseftitle, jc.title as ctitle, j"
								+ "c.id as cid, jc.sef_url as cseftitle, ")
						.append("jsc.title as sctitle, jsc.id as scid, jsc.sef_url as scseftitle, jssc.title as s"
								+ "sctitle, jssc.id as sscid, jssc.sef_url as sscseftitle, ")
						.append("jssc.metatitle, jssc.metakey, jssc.metadesc ")
						.append("from jos_sub_subcategories jssc, jos_content c, jos_article_section jas, jos_sec"
								+ "tions js, jos_categories jc, jos_subcategories jsc ")
						.append("where jas.sub_subcat_id=").append(catId)
						.append(" and c.published=1 and c.id=jas.article_id and jssc.id=jas.sub_subcat_id and jsc"
								+ ".id=jas.subcat_id and jc.id=jas.cat_id and js.id=jas.section_id and jssc.publish"
								+ "ed=1 and js.published=1 and jsc.published=1 and jc.published=1 ")
						.toString();
			}
			sql = (new StringBuilder(String.valueOf(String.valueOf(sql)))).append(" ").append(contentIdsToCheck)
					.append(" and c.title not like '%href=%' group by c.id order by jas.ordering desc limit ")
					.append(contentCount).append(" offset ").append(offset).toString();
			System.out.println(sql);   
			pstmt = connection.prepareStatement(sql);
			for (rs = pstmt.executeQuery(); rs.next();) {
				cDTO = new StoryListDTO();
				cDTO.setId(rs.getInt("id"));
				cDTO.setTitle(rs.getString("title") != null ? rs.getString("title") : "");
				cDTO.setByLine(rs.getString("byline") != null ? rs.getString("byline") : "");
				cDTO.setSef_url(rs.getString("sef_url") != null ? rs.getString("sef_url") : "");
				cDTO.setSefTitle(rs.getString("sef_url") != null ? rs.getString("sef_url") : "");
				cDTO.setImage(rs.getString("c.kicker_image") != null ? rs.getString("c.kicker_image") : "");
				cDTO.setImageAltText(
						rs.getString("kicker_image_alt_text") != null ? rs.getString("kicker_image_alt_text") : "");
				cDTO.setMetaTitle(rs.getString("metatitle") != null ? rs.getString("metatitle") : "");
				cDTO.setMetaKeyword(rs.getString("metakey") != null ? rs.getString("metakey") : "");
				cDTO.setMetaDescription(rs.getString("metadesc") != null ? rs.getString("metadesc") : "");
				cDTO.setSectionId(rs.getInt("sid"));
				cDTO.setSectionTitle(rs.getString("stitle") != null ? rs.getString("stitle") : "");
				cDTO.setSectionSefTitle(rs.getString("sseftitle") != null ? rs.getString("sseftitle") : "");
				if (catLevel >= 2) {
					cDTO.setCategoryId(rs.getInt("cid"));
					cDTO.setCategoryTitle(rs.getString("ctitle") != null ? rs.getString("ctitle") : "");
					cDTO.setCategorySefTitle(rs.getString("cseftitle") != null ? rs.getString("cseftitle") : "");
				}
				if (catLevel >= 3) {
					cDTO.setSubCategoryId(rs.getInt("scid"));
					cDTO.setSubCategoryTitle(rs.getString("sctitle") != null ? rs.getString("sctitle") : "");
					cDTO.setSubCategorySefTitle(rs.getString("scseftitle") != null ? rs.getString("scseftitle") : "");
				}
				if (catLevel >= 4) {
					cDTO.setSubSubCategoryId(rs.getInt("sscid"));
					cDTO.setSubSubCategoryTitle(rs.getString("ssctitle") != null ? rs.getString("ssctitle") : "");
					cDTO.setSubSubCategorySefTitle(
							rs.getString("sscseftitle") != null ? rs.getString("sscseftitle") : "");
				}
				cAL.add(cDTO);
				ctr++;
			}

		} catch (Exception e) {
			System.out.println("IT WAP CommonFunctions (latestContent for Exception is :" + e);
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

}