<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
	</tr>


	<c:forEach var="p" items="${list}">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
		</tr>

	</c:forEach>

</table>