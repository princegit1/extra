<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Login</h3>
	</div>
	<div class="panel-body">
		
	<div id="login-box">

   
		<c:if test="${not empty error}">
			<div class="error alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg  alert alert-success">${msg}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>

		  <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' class="form-control" value=''></td>
			</tr>   
			<tr>
			<td colspan="2">&nbsp;</td>
			</tr>   
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' class="form-control" /></td>
			</tr> 
			<tr>
			<td colspan="2">&nbsp;</td>
			</tr>   
			<tr>
				<td colspan='2'><input name="submit" class="btn btn-success" type="submit"
					value="submit" /></td>
			</tr>
		  </table>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />      
		</form>
	</div>

	</div>
</div>                            


   