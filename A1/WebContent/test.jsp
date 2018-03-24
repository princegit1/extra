<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tt</title>
</head>
<body>
<%!
private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
private static final String URL="jdbc:mysql://10.10.25.242:3306/ichowk";
private static final String USER="itgd";
private static final String PASSWORD="itgd@nd@123";	
%>
<%   
try {
	Class.forName(DRIVER_CLASS);
	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	Statement stmt = conn.createStatement();
	String sql ="select * from ichowk_content limit 10;";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
		out.println(" --> " + new String(rs.getString("title").getBytes("ISO-8859-1"), "UTF-8"));
	}
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block    
	e.printStackTrace();
}
%>
</body>
</html>