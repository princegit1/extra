<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jstl</title>
</head>
<body>
<%-- <c:set var="aa">
<persons>
	<person>
		<name>P1</name>
		<id>1</id>
	</person>
	<person>
		<name>P2</name>
		<id>2</id>
	</person>
	<person>
		<name>P3</name>
		<id>3</id>
	</person>
</persons>
</c:set>

<x:parse xml="${aa}" var="out"></x:parse>
   
   
<x:out select="$out/persons/person[1]/name" />   --%>

<%-- <c:import var="data1" url="default.xml"></c:import>  
<x:parse xml="${data1}" var="output"></x:parse>

<x:out select="$output/default/stryroot[1]/stry/ctr"/> --%>

<%-- <c:import url="default.xml" var="xml"></c:import>
<c:import url="transfer.xsl" var="xsl"></c:import>    
             
<x:transform xml="${xml}" xsl="${xsl}"></x:transform> --%>


<c:import var="xml" url="http://timesofindia.indiatimes.com/xml/default.cms" />          
<c:import var="xsl" url="transfer.xsl" />  
<x:transform xml="${xml}" xslt="${xsl}" />                 



</body>
</html>