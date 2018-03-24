<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<%@ page import="com.dao.CartBean,com.dto.Product,java.util.*" %>
	 <jsp:useBean id="cart" scope="session" class="com.dao.CartBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AAAA</title>
<style>
tabel{border-collapse: collapse;}
th,td{border:1px solid #eee;padding:5px 10px;}
</style>
</head>
<body>

    ${cart}
    
    <c:forEach var="c1" items="${cart.cartItems }" varStatus="counter">1</c:forEach>    
  <%--   <%
    CartBean ct = new CartBean();
    HashMap<Integer,Product> hm = ct.getCartItems();
    out.println("----> " + ct + " --- " + hm);                                  
    
    %> --%>
	<table>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quan</th>           
				<th>total price</th>
			</tr>
			
	<%-- 	<c:forEach var="cartItem" items="${cart}" varStatus="counter"> --%>
			<form name="" method="post" action="S1">
				<tr>  
				1                
				<%-- <th><c:out value="${cartItem.id}"/></th>
				<th><c:out value="${cartItem.name}"/></th>
				<th><c:out value="${cartItem.unitCost}"/></th>
				<th><c:out value="${cartItem.quantity}"/></th>
				<th><c:out value="${cartItem.totalCost}"/></th> --%>
			</tr>
			</form>   
			<%-- </c:forEach>  --%>
		</table>
</body>
</html>