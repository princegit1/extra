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
<div class="container_wrapper">

	<%
		HomeHelper hhlp = new HomeHelper();
		List<HomeDto> list = hhlp.listCat();
		for (HomeDto h : list) {
	%>

	<div class="container">
		<div class="heading"><%=h.getCattitle() %></div>
		<div class="content">
		<jsp:include page="latest_story.jsp">
		<jsp:param value="<%=h.getId() %>" name="catid" />   
		</jsp:include>
		
		</div>
	</div>



	<%
		}
	%>
</div>
</body>
</html>