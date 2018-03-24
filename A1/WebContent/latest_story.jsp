<%@page import="com.itgd.dto.HomeDto"%>
<%@page import="com.itgd.helper.HomeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,com.itgd.*,java.util.*"%>

       
	<%
	int catid= Integer.parseInt(request.getParameter("catid"));
		HomeHelper hhlp = new HomeHelper();
	
			
			List<HomeDto> list1 = hhlp.listStoryBycatid(catid);
			for (HomeDto h : list1) {    
				if(list1.size()==0){   
	%>
No Element

<%} else { %>
  
	<div class="box">
		<div class="imgcontainer">
		
			<div class="img_cont">
				<a href="story.jsp?id=<%=h.getId()%>" title=""><img
					src="https://smedia2.intoday.in/ichowk/story/small/<%=h.getSmall_image()%>"
					alt=""></a>
			</div>
			<div class="profile_cont">
				<span class="prof_img" style="background:url(<%=h.getAuth_img()%>);background-size:100% 100%;"></span> <span class="prof_name"><%=h.getAuthor_name()%><br>@<%=h.getAuth_scren_name() %></span>

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


	<%} }  
		   
	%>
