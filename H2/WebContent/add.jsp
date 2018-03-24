<%@ page import="com.test.*,java.util.*"%>
<%
	String name = "";
	name = request.getParameter("name");
	out.println("Name: " + name);  
	Test1 t = new Test1();   
	if(name!=null){
   //System.out.println("Success!!" + name);
	Integer pr = t.addData(name);
	}   
	else
	{   
		System.out.println("Error!!" + name);
		out.println("Error Occured!!!");    
	}
%>                                       