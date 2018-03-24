<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AAAA</title>
<style>
form {
	width: 300px;
	float: left;
	margin: 20px;
	display: table;
}

input {
	display: table-cell
}
</style>
</head>
<body>

	<%
		for (int j = 1; j < 5; j++) {
	%>
	<form name="" method="post" action="S1">      
		<table>                                            
			<tr>
				<td>ID:</td>
				<td><input name="id" value="<%=j%>"></td>                
			</tr>
			<tr>
				<td>NAME:</td>
				<td><input name="name" value="Pname<%=j%>"></td>
			</tr>
			<tr>
				<td>Quan:</td>
				<td><select name="quantity">
						<%
							for (int i = 1; i < 11; i++) {          
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
						%>
				</select></td>                
			</tr>
			<tr>
				<td>PRICE:</td>                             
				<td><input name="price" value="10<%=j%>"></td> 
			</tr>
			
			<tr>
				<td><input type="hidden" name="action" value="add"></td>
				
				<td><input name="addtocart" type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>


</body>
</html>