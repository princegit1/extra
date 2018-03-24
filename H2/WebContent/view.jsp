<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="assets/css/materialize.min.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="assets/js/materialize.min.js"></script>

<meta name="viewport" content="initial-scale=1, maximum-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));  
		Test1 t = new Test1();
		List<Person> list = t.listDataById(id);
		Iterator itr = list.iterator();

		/* out.println("List: " + list); */
	%>
	<div class="container">
		<div class="card-panel hoverable">
		

			<div class="col s12">
				<table class="bordered striped highlight ">
					<thead>
						<tr>
							<td>ID</td>
							<td>NAME</td>
							<td>VIEW</td>
							<td>EDIT</td>
							<td>DELETE</td>
						</tr>
					</thead>
					<tbody>

						<%
							while (itr.hasNext()) {
								Person p = (Person) itr.next();
						%>
						<tr>
							<td><%=p.getId()%></td>
							<td><%=p.getName()%></td>
							<td><a href="view.jsp?id=<%=p.getId()%>">VIEW</a></td>
							<td><a href="edit.jsp?id=<%=p.getId()%>">EDIT</a></td>   
							<td><a href="delete.jsp?id=<%=p.getId()%>">Delete</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	
</body>
</html>