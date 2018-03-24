<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>${msg}</h3>	
	<h3>Username : ${user}</h3>	
 
	<a href="<c:url value="/j_spring_security_logout" />" > Logoff</a>
 
</body>
</html>