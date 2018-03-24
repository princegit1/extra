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
				<s:property value="id" />
				<br>
				<s:property value="name" />
				<br>
				<s:property value="email" />
				<br>
			</div>

		</div>
	</div>
</body>
</html>