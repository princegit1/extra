
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-responsive">
	<c:forEach var="p" items="${list}">
		<tr>
			<td>${p.pid }</td>
			<td>${p.time }</td>
			<td>${p.heading }</td>
			<td>${p.sid }</td>
			<td>${p.name }</td>
			<td>${p.designation }</td>                    
			<td>${p.images }</td>
		</tr>
	</c:forEach>
</table>
