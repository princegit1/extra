<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<sb:head />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<s:form action="test" theme="bootstrap" cssClass="form-horizontal"
					label="A sample horizontal Form">
					<s:textfield name="id" label="Pid"></s:textfield>
					<s:textfield name="name" label="Name"></s:textfield>
					<s:submit cssClass="btn btn-success"></s:submit>
				</s:form>

			</div>
		</div>
	</div>

</body>
</html>
