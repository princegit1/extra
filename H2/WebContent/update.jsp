<%@ page import="com.test.*,java.util.*"%>
<%
	int id = 0;
	id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	Test1 t = new Test1();
	try {
		t.update(name, id);
		out.println("Updated Successfully!!");
		response.sendRedirect("index.jsp");
	} catch (Exception e) {
		out.println("Exception Occurs: " + e);
	}
%>
