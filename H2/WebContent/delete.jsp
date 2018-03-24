<%@ page import="com.test.*,java.util.*"%>
<%
	int id = 0;
	id = Integer.parseInt(request.getParameter("id"));
	Test1 t = new Test1();
	try {
	t.delete(id);
	response.sendRedirect("index.jsp");  
	}catch(Exception e){
		out.println("Error Occured! ");
	}
%>