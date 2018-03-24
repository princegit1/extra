<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <c:import url="st.xml" var="st"></c:import>


	<x:parse xml="${st }" var="out"></x:parse>

  
	Name: <x:out select="$out/students/student[3]/name" />
	
	
	<x:set var="fr" select="$out/students"/>
	<x:out select="$fr"/>
	
	<c:forEach var="t" items="$fr">
	<c:out value="${t }" />
	</c:forEach>         --%>


	<%-- 	<c:import var="xsl" url="st.xsl"></c:import>
	<c:import var="xml" url="sl.xml"></c:import> --%>

	<c:import var="xml" url="st.xml" />    
	<c:import var="xsl" url="st.xsl" />    
	<x:transform xml="${xml}" xslt="${xsl}">     

		<x:param name="bgColor1" value="#f1f1f1"></x:param>
		<x:param name="bgColor2" value="#6661f1"></x:param>
	</x:transform>


</body>
</html>