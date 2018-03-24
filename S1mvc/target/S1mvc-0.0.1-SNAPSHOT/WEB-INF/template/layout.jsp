<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/main.css">
         
</head>
<body>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	 <div class="container"><tiles:insertAttribute name="body"></tiles:insertAttribute></div>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<script src="${pageContext.servletContext.contextPath}/assets/js/vendor/jquery-1.11.2.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/assets/js/vendor/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/assets/js/main.js"></script>
</body>
</html>
