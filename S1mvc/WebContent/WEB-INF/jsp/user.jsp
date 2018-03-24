
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">User</h3>
	</div>
	<div class="panel-body">
   
		<h2>Title : ${title}</h2>
		<h2>Message : ${message}</h2>

		<c:url value="/j_spring_security_logout" var="logoutUrl" />

		<!-- csrt for log out-->
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>   

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h3>
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h3>
		</c:if>

	</div>
</div>


