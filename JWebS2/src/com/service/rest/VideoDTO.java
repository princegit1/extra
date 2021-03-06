/**
 * 
 */
package com.service.rest;

public class VideoDTO {
	private int videoId;
	private String videoTitle;
	private String videoTitleAlias;
	private String videoSefTitle;
	private String videoByline;
	private String videoCity;
	private String sef_url;
	private String videoCourtesy;
	private String videoDescription;
	private String videoKickerImage;
	private int videoKickerImageWidth;
	private int videoKickerImageHeight;
	private String videoLargeKickerImage;
	private int videoLargeKickerImageWidth;
	private int videoLargeKickerImageHeight;
	private String videoKickerImageAltText;
	private String videoKickerImageCaption;
	private String videoCreatedDate;
	private String videoUpdatedDate;
	private String videoCreatedTime;
	private String videoUpdatedTime;

	private String videoStrapHeadline;
	private String videoComment;
	private String videoExpertComment;
	private String primaryCategory;
	private int primaryCategoryLength;

	private String metaTitle;
	private String metaKeywords;
	private String metaDescription;
	private int videoSectionId;
	private String videoSectionTitle;
	private String videoSectionSefTitle;
	private String videoSectionPageURL;
	private int videoCategoryId;
	private String videoCategoryTitle;
	private String videoCategorySefTitle;
	private String videoCategoryPageURL;
	private int currentCategoryId;
	private String currentCategoryTitle;
	private String currentCategorySefTitle;
	private String currentCategoryPageURL;
	
	private String videoFolder;
	private String videoFile;
	private int videoCount;
	private String externalVideoUrl;	

	private int videoCommentCount;
	private String videoIds;	
	private String currentPage;
	private String topNavigationPath;
	private String rightNavigationPath;
	private String bottomNavigationPath;
	private String leftNavigationPath;
	
	private String headerImage;
	private int mp4VideoFlag;
	private String extraLargeKickerImage;
	private String smallImage;

	public String getSef_url() {
		return sef_url;
	}
	public void setSef_url(String sef_url) {
		this.sef_url = sef_url;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoTitleAlias() {
		return videoTitleAlias;
	}
	public void setVideoTitleAlias(String videoTitleAlias) {
		this.videoTitleAlias = videoTitleAlias;
	}
	public String getVideoSefTitle() {
		return videoSefTitle;
	}
	public void setVideoSefTitle(String videoSefTitle) {
		this.videoSefTitle = videoSefTitle;
	}
	public String getVideoByline() {
		return videoByline;
	}
	public void setVideoByline(String videoByline) {
		this.videoByline = videoByline;
	}
	public String getVideoCity() {
		return videoCity;
	}
	public void setVideoCity(String videoCity) {
		this.videoCity = videoCity;
	}
	public String getVideoCourtesy() {
		return videoCourtesy;
	}
	public void setVideoCourtesy(String videoCourtesy) {
		this.videoCourtesy = videoCourtesy;
	}
	public String getVideoKickerImage() {
		return videoKickerImage;
	}
	public void setVideoKickerImage(String videoKickerImage) {
		this.videoKickerImage = videoKickerImage;
	}
	public int getVideoKickerImageWidth() {
		return videoKickerImageWidth;
	}
	public void setVideoKickerImageWidth(int videoKickerImageWidth) {
		this.videoKickerImageWidth = videoKickerImageWidth;
	}
	public int getVideoKickerImageHeight() {
		return videoKickerImageHeight;
	}
	public void setVideoKickerImageHeight(int videoKickerImageHeight) {
		this.videoKickerImageHeight = videoKickerImageHeight;
	}
	public String getVideoLargeKickerImage() {
		return videoLargeKickerImage;
	}
	public void setVideoLargeKickerImage(String videoLargeKickerImage) {
		this.videoLargeKickerImage = videoLargeKickerImage;
	}
	public int getVideoLargeKickerImageWidth() {
		return videoLargeKickerImageWidth;
	}
	public void setVideoLargeKickerImageWidth(int videoLargeKickerImageWidth) {
		this.videoLargeKickerImageWidth = videoLargeKickerImageWidth;
	}
	public int getVideoLargeKickerImageHeight() {
		return videoLargeKickerImageHeight;
	}
	public void setVideoLargeKickerImageHeight(int videoLargeKickerImageHeight) {
		this.videoLargeKickerImageHeight = videoLargeKickerImageHeight;
	}
	public String getVideoKickerImageAltText() {
		return videoKickerImageAltText;
	}
	public void setVideoKickerImageAltText(String videoKickerImageAltText) {
		this.videoKickerImageAltText = videoKickerImageAltText;
	}
	public String getVideoKickerImageCaption() {
		return videoKickerImageCaption;
	}
	public void setVideoKickerImageCaption(String videoKickerImageCaption) {
		this.videoKickerImageCaption = videoKickerImageCaption;
	}
	public String getVideoCreatedDate() {
		return videoCreatedDate;
	}
	public void setVideoCreatedDate(String videoCreatedDate) {
		this.videoCreatedDate = videoCreatedDate;
	}
	public String getVideoUpdatedDate() {
		return videoUpdatedDate;
	}
	public void setVideoUpdatedDate(String videoUpdatedDate) {
		this.videoUpdatedDate = videoUpdatedDate;
	}
	public String getVideoCreatedTime() {
		return videoCreatedTime;
	}
	public void setVideoCreatedTime(String videoCreatedTime) {
		this.videoCreatedTime = videoCreatedTime;
	}
	public String getVideoUpdatedTime() {
		return videoUpdatedTime;
	}
	public void setVideoUpdatedTime(String videoUpdatedTime) {
		this.videoUpdatedTime = videoUpdatedTime;
	}
	public String getVideoStrapHeadline() {
		return videoStrapHeadline;
	}
	public void setVideoStrapHeadline(String videoStrapHeadline) {
		this.videoStrapHeadline = videoStrapHeadline;
	}
	public String getVideoComment() {
		return videoComment;
	}
	public void setVideoComment(String videoComment) {
		this.videoComment = videoComment;
	}
	public String getVideoExpertComment() {
		return videoExpertComment;
	}
	public void setVideoExpertComment(String videoExpertComment) {
		this.videoExpertComment = videoExpertComment;
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
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public int getVideoSectionId() {
		return videoSectionId;
	}
	public void setVideoSectionId(int videoSectionId) {
		this.videoSectionId = videoSectionId;
	}
	public String getVideoSectionTitle() {
		return videoSectionTitle;
	}
	public void setVideoSectionTitle(String videoSectionTitle) {
		this.videoSectionTitle = videoSectionTitle;
	}
	public String getVideoSectionSefTitle() {
		return videoSectionSefTitle;
	}
	public void setVideoSectionSefTitle(String videoSectionSefTitle) {
		this.videoSectionSefTitle = videoSectionSefTitle;
	}
	public String getVideoSectionPageURL() {
		return videoSectionPageURL;
	}
	public void setVideoSectionPageURL(String videoSectionPageURL) {
		this.videoSectionPageURL = videoSectionPageURL;
	}
	public int getVideoCategoryId() {
		return videoCategoryId;
	}
	public void setVideoCategoryId(int videoCategoryId) {
		this.videoCategoryId = videoCategoryId;
	}
	public String getVideoCategoryTitle() {
		return videoCategoryTitle;
	}
	public void setVideoCategoryTitle(String videoCategoryTitle) {
		this.videoCategoryTitle = videoCategoryTitle;
	}
	public String getVideoCategorySefTitle() {
		return videoCategorySefTitle;
	}
	public void setVideoCategorySefTitle(String videoCategorySefTitle) {
		this.videoCategorySefTitle = videoCategorySefTitle;
	}
	public String getVideoCategoryPageURL() {
		return videoCategoryPageURL;
	}
	public void setVideoCategoryPageURL(String videoCategoryPageURL) {
		this.videoCategoryPageURL = videoCategoryPageURL;
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
	public String getCurrentCategorySefTitle() {
		return currentCategorySefTitle;
	}
	public void setCurrentCategorySefTitle(String currentCategorySefTitle) {
		this.currentCategorySefTitle = currentCategorySefTitle;
	}
	public String getCurrentCategoryPageURL() {
		return currentCategoryPageURL;
	}
	public void setCurrentCategoryPageURL(String currentCategoryPageURL) {
		this.currentCategoryPageURL = currentCategoryPageURL;
	}
	public String getVideoFolder() {
		return videoFolder;
	}
	public void setVideoFolder(String videoFolder) {
		this.videoFolder = videoFolder;
	}
	public String getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}
	public int getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}
	public String getExternalVideoUrl() {
		return externalVideoUrl;
	}
	public void setExternalVideoUrl(String externalVideoUrl) {
		this.externalVideoUrl = externalVideoUrl;
	}
	public int getVideoCommentCount() {
		return videoCommentCount;
	}
	public void setVideoCommentCount(int videoCommentCount) {
		this.videoCommentCount = videoCommentCount;
	}
	public String getVideoIds() {
		return videoIds;
	}
	public void setVideoIds(String videoIds) {
		this.videoIds = videoIds;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
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
	public String getVideoDescription() {
		return videoDescription;
	}
	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}
	public String getMetaTitle() {
		return metaTitle;
	}
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	public String getHeaderImage() {
		return headerImage;
	}
	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}
	public int getMp4VideoFlag() {
		return mp4VideoFlag;
	}
	public void setMp4VideoFlag(int mp4VideoFlag) {
		this.mp4VideoFlag = mp4VideoFlag;
	}
	public String getExtraLargeKickerImage() {
		return extraLargeKickerImage;
	}
	public void setExtraLargeKickerImage(String extraLargeKickerImage) {
		this.extraLargeKickerImage = extraLargeKickerImage;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
}