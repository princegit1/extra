<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<h5>${adminmsg }</h5>  


<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Welcome : ${pageContext.request.userPrincipal.name} 
           | <a href="<c:url value="/logout" />" > Logout</a></h2>             
	</c:if> 