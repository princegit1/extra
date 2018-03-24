/**
 * 
 */
package com.service.rest;

public class ContentTemplateDTO {
	private int id;
	private String title;
	private String shortDescription;
	private String smallImage;
	private String sef_url;
	private String kickerImage;
	private String kickerImageAltText;
	private String largeImage;
	private String largeImageAltText;
	private String extraLargeImage;
	private String createdDate;
	private String contentURL;
	private String primaryCategory;
	private int primaryCategoryLength;
	private String contentDisplayColor;
	private int isExternalURL;

	private int sectionId;
	private String sectionTitle;
	private String sectionURL;
	private int categoryId;
	private String categoryTitle;
	private String categoryURL;
	private int subCategoryId;
	private String subCategoryTitle;
	private String subCategoryURL;
	private int subSubCategoryId;
	private String subSubCategoryTitle;
	private String subSubCategoryURL;
	private int currentCategoryId;
	private String currentCategoryTitle;
	private String currentCategoryURL;

	private String metaTitle;
	private String metaKeyword;
	private String metaDescription;
	private String topNavigationPath;	
	private String rightNavigationPath;
	private String bottomNavigationPath;
	private String leftNavigationPath;
	public int getId() {
		return id;
	}
	public String getSef_url() {
		return sef_url;
	}
	public void setSef_url(String sef_url) {
		this.sef_url = sef_url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getKickerImage() {
		return kickerImage;
	}
	public void setKickerImage(String kickerImage) {
		this.kickerImage = kickerImage;
	}
	public String getKickerImageAltText() {
		return kickerImageAltText;
	}
	public void setKickerImageAltText(String kickerImageAltText) {
		this.kickerImageAltText = kickerImageAltText;
	}
	public String getLargeImage() {
		return largeImage;
	}
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	public String getLargeImageAltText() {
		return largeImageAltText;
	}
	public void setLargeImageAltText(String largeImageAltText) {
		this.largeImageAltText = largeImageAltText;
	}
	public String getExtraLargeImage() {
		return extraLargeImage;
	}
	public void setExtraLargeImage(String extraLargeImage) {
		this.extraLargeImage = extraLargeImage;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getContentURL() {
		return contentURL;
	}
	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}
	public String getPrimaryCategory() {
		return primaryCategory;
	}
	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
	}
	public int getPrimaryCategoryLength() {
		return primaryCategoryLength;
	}
	public void setPrimaryCategoryLength(int primaryCategoryLength) {
		this.primaryCategoryLength = primaryCategoryLength;
	}
	public String getContentDisplayColor() {
		return contentDisplayColor;
	}
	public void setContentDisplayColor(String contentDisplayColor) {
		this.contentDisplayColor = contentDisplayColor;
	}
	public int getIsExternalURL() {
		return isExternalURL;
	}
	public void setIsExternalURL(int isExternalURL) {
		this.isExternalURL = isExternalURL;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionTitle() {
		return sectionTitle;
	}
	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}
	public String getSectionURL() {
		return sectionURL;
	}
	public void setSectionURL(String sectionURL) {
		this.sectionURL = sectionURL;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryURL() {
		return categoryURL;
	}
	public void setCategoryURL(String categoryURL) {
		this.categoryURL = categoryURL;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryTitle() {
		return subCategoryTitle;
	}
	public void setSubCategoryTitle(String subCategoryTitle) {
		this.subCategoryTitle = subCategoryTitle;
	}
	public String getSubCategoryURL() {
		return subCategoryURL;
	}
	public void setSubCategoryURL(String subCategoryURL) {
		this.subCategoryURL = subCategoryURL;
	}
	public int getSubSubCategoryId() {
		return subSubCategoryId;
	}
	public void setSubSubCategoryId(int subSubCategoryId) {
		this.subSubCategoryId = subSubCategoryId;
	}
	public String getSubSubCategoryTitle() {
		return subSubCategoryTitle;
	}
	public void setSubSubCategoryTitle(String subSubCategoryTitle) {
		this.subSubCategoryTitle = subSubCategoryTitle;
	}
	public String getSubSubCategoryURL() {
		return subSubCategoryURL;
	}
	public void setSubSubCategoryURL(String subSubCategoryURL) {
		this.subSubCategoryURL = subSubCategoryURL;
	}
	public int getCurrentCategoryId() {
		return currentCategoryId;
	}
	public void setCurrentCategoryId(int currentCategoryId) {
		this.currentCategoryId = currentCategoryId;
	}
	public String getCurrentCategoryTitle() {
		return currentCategoryTitle;
	}
	public void setCurrentCategoryTitle(String currentCategoryTitle) {
		this.currentCategoryTitle = currentCategoryTitle;
	}
	public String getCurrentCategoryURL() {
		return currentCategoryURL;
	}
	public void setCurrentCategoryURL(String currentCategoryURL) {
		this.currentCategoryURL = currentCategoryURL;
	}
	public String getMetaTitle() {
		return metaTitle;
	}
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	public String getMetaKeyword() {
		return metaKeyword;
	}
	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getTopNavigationPath() {
		return topNavigationPath;
	}
	public void setTopNavigationPath(String topNavigationPath) {
		this.topNavigationPath = topNavigationPath;
	}
	public String getRightNavigationPath() {
		return rightNavigationPath;
	}
	public void setRightNavigationPath(String rightNavigationPath) {
		this.rightNavigationPath = rightNavigationPath;
	}
	public String getBottomNavigationPath() {
		return bottomNavigationPath;
	}
	public void setBottomNavigationPath(String bottomNavigationPath) {
		this.bottomNavigationPath = bottomNavigationPath;
	}
	public String getLeftNavigationPath() {
		return leftNavigationPath;
	}
	public void setLeftNavigationPath(String leftNavigationPath) {
		this.leftNavigationPath = leftNavigationPath;
	}
} 