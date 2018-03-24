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

@Path("/photo")       
public class GalleryService {

	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getjson1(@PathParam("id") int id) {
		List st = null;
		try {
			st = (List) photoDetail(id);
			for (int i = 0; i < st.size(); i++) {
				GalleryDTO sd = (GalleryDTO) st.get(i);
				// System.out.println(sd.getByline());
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);    
		}
		return st;
	}


	                 
	/*
	 * public static void main(String ss[]) throws Exception {
	 * System.out.println(photoDetail(1142)); }
	 */

	public static ArrayList photoDetail(int galleryId) throws Exception {
		ArrayList photoList = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;

		GalleryDTO photoDetails = null;
		int galleryPhotoCount = 0;
		int primaryCategoryLength = 0;
		String primaryCategoryId[] = null;
		String primaryCategory = "1#3";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://10.10.25.243/btmt", "itgd", "itgd@nd@123");

			String sql = "";
			String sql1 = "";

			sql = "select g.id,g.Gallery_name,g.metakey,g.metadesc,p.photo_name,p.image_metakey,"
					+ "p.photo_title,s.name as sectionname,s.sef_url,g.section_id"
					+ ",DATE_FORMAT(g.created,'%M %e, %Y') as created,g.sef_url as gallery_sefurl,g.Gallery_caption,g.metakey as gallerykeywords,g.metadesc as gallerydesc, "
					+ " p.photo_caption,p.image_alt_text,p.photo_name_width, p.photo_name_height  "
					+ " from jos_gallerynames g,jos_photogallery p,jos_sections as s "
					+ " where g.id=? and g.published=1 and g.section_id=s.id and s.published=1 "
					+ " and g.id=p.gallery_id and p.enable=1 " + " and s.section_type='photo' and s.magazineid='1'"
					+ " order by p.ordering desc ";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, galleryId);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			rs.last();
			galleryPhotoCount = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				photoDetails = new GalleryDTO();

			photoDetails.setPhotoTitle(rs.getString("photo_name"));
				photoDetails
						.setPhotoAltText(rs.getString("image_alt_text") == null ? "" : rs.getString("image_alt_text"));
				photoDetails.setPhotoCaption(rs.getString("photo_title") == null ? "" : rs.getString("photo_title"));
				photoDetails.setPhotoMetaKeyword(
						rs.getString("image_metakey") == null ? "" : rs.getString("image_metakey"));
				photoDetails.setPhotoSource(rs.getString("photo_caption") == null ? "" : rs.getString("photo_caption"));

				photoDetails.setGalleryId(rs.getInt("id"));
				photoDetails.setGalleryTitle(rs.getString("Gallery_name"));    
				photoDetails.setGallerySefTitle(rs.getString("gallery_sefurl"));
				photoDetails
						.setMetaKeyword(rs.getString("gallerykeywords") == null ? "" : rs.getString("gallerykeywords"));
				photoDetails.setMetaDescription(rs.getString("gallerydesc") == null ? "" : rs.getString("gallerydesc"));

				photoDetails.setPhotoCount(galleryPhotoCount);

				photoDetails.setCategoryId(rs.getInt("section_id"));
				photoDetails.setCategoryTitle(rs.getString("sectionname"));
				photoDetails.setCategorySefTitle(rs.getString("sef_url"));
    
				photoList.add(photoDetails);
			}

		} catch (Exception e) {
			System.out.println("GalleryHelper - photoDetails Exception is -->" + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)   
				pstmt.close();
			if (connection != null)
				connection.close();
		}
		 try {                    
				Thread.sleep(500);    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return photoList;
	}

}
