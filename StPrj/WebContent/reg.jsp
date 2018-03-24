<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sd"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ss</title>
<sb:head />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6 col-lg-6">

				<s:form theme="bootstrap" cssClass="well form-vertical"
					action="regs">
					<s:textfield name="id" label="ID: "></s:textfield>
					<s:textfield name="name" label="NAME: "></s:textfield>
					<s:textfield name="email" label="EMAIL: "></s:textfield>
					<s:submit cssClass="btn btn-success"></s:submit>
				</s:form>
			</div>

		</div>
	</div>
</body>
</html>