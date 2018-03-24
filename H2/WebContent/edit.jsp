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
		<div class="card-panel hoverable grey lighten-5">       
			<div class="row">

				<form class="col s12" id="form11" name="f" method="post"
					action="update.jsp">
					<%
						while (itr.hasNext()) {
							Person p = (Person) itr.next();
					%>                        
					<div class="row">        
						<div class="input-field col s6">
							<input id="id" name="id" type="text" class="validate" value="<%=id%>"> <label
								for="id">ID</label>
						</div>
  
						<div class="input-field col s6">
							<input id="name" name="name" type="text" class="validate" value="<%=p.getName()%>"> <label
								for="name">NAME</label>
						</div>
					</div>

					<input type="submit" value="Update"   
						class="waves-effect waves-light btn purple lighten-1" />   
					<%
						}
					%>
				</form>
			</div>

   
		</div>
	</div>
	</div>
	
</body>
</html>