<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertAttribute name="meta_details"></tiles:insertAttribute>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<title>yyy</title>
<meta name="description" content="" />
<meta name="keywords" content=" " />
<tiles:insertAttribute name="css_include"></tiles:insertAttribute>
<tiles:insertAttribute name="ga_comscore"></tiles:insertAttribute>
</head>
<body>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<tiles:insertAttribute name="navigation"></tiles:insertAttribute>
	<h1
		style="font-size: 0px; visibility: hidden; margin: 0px; padding: 0px;"></h1>
	<div class="container ">
		<div class="row ">
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
			<!--end left area -->
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<tiles:insertAttribute name="right"></tiles:insertAttribute>
			</div>
			<!--end right side -->
		</div>
	</div>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<tiles:insertAttribute name="js_include"></tiles:insertAttribute>
</body>
</html>




