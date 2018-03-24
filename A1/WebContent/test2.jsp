<%@page import="com.itgd.dto.HomeDto"%>
<%@page import="com.itgd.helper.HomeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,com.itgd.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
       
	<%
		HomeHelper hhlp = new HomeHelper();
		List<HomeDto> list = hhlp.listCat();
		for (HomeDto h1 : list) {
			
			
			List<HomeDto> list1 = hhlp.listStory();
			for (HomeDto h : list1) {
	%>

  
	<div class="box">
		<div class="imgcontainer">  
		<%=h1.getId() %>  
		<%=h1.getCattitle() %>
			<div class="img_cont">
				<a href="story.jsp?id=<%=h.getId()%>" title=""><img
					src="https://smedia2.intoday.in/ichowk/story/small/<%=h.getSmall_image()%>"
					alt=""></a>
			</div>
			<div class="profile_cont">
				<span class="prof_img"></span> <span class="prof_name"><%=h.getAuthor_name()%><br>@Ichwoktwitter</span>

			</div>
			<div class="clr"></div>
		</div>
		<div class="content_cont">
			<h3>
				<a href="story.jsp?id=<%=h.getId()%>" title=""><%=h.getTitle()%></a>
			</h3>

			<p><%=h.getShort_desc()%></p>
		</div>   
	</div>


	<% }  
		}
	%>
</body>
</html>