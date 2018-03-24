<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
  
<%@page import="com.itgd.dto.StoryDto"%>
<%@page import="com.itgd.helper.StoryHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
StoryHelper h11 = new StoryHelper();
List<StoryDto> list = h11.listStoryById(id);

for(StoryDto h: list) {
	
%>
<div class="story_container">
<div class="header_img"><img src="http://media2.intoday.in/ichowk/story/<%=h.getHeader_image() %>" alt="">
<h1 class="title"><%=h.getTitle() %></h1>
</div>
<div class="content">
<div class="cont_desc">    
<%-- Cat Name: <%=StringEscapeUtils.unescapeHtml(h.getCatname()) %>  --%>     
<%=StringEscapeUtils.unescapeHtml(h.getFull_description().replaceAll("\r", "").replaceAll("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n", "")) %>    

</div>  
</div>
</div>
<% } %>   
</body>
</html>