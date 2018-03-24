<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <form name="" method="post" action="test">
	<input type="text" name="user1" /><br> <input type="submit"
		value="Submit" />
</form>
        
 -->
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>           

<form name='loginForm'
	action="<c:url value='j_spring_security_check' />" method='POST'>

	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit"
				value="submit" /></td>
		</tr>
	</table>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>