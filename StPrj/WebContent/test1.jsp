<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button class="hl">Hl</button>
<button class="sum">Sum</button>
<button class="find">find</button>
<button class="findall">findall</button>
<div class="rs"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$('.hl').click(function(){
	$.ajax({
		'type':'GET',
		'url':'${pageContext.request.contextPath}/jt/hl',
		 success:function(response){    
		  $('.rs').html("--> " + response);
		}
	})
	})
	
	
	$('.sum').click(function(){
	$.ajax({
		'type':'GET',
		'url':'${pageContext.request.contextPath}/jt/sum',
		'data':{a:3,b:6},
		 success:function(response){    
		  $('.rs').html("--> " + response);
		}
	})  
	})
	
		$('.find').click(function(){
	$.ajax({
		'type':'GET',
		'url':'${pageContext.request.contextPath}/jt/find', 
		 success:function(response){   
			 var rs = 'Id: ' + response.pd.id + ' Name:' + response.pd.name + ' Email:'+ response.pd.email + ' Password:'+ response.pd.password;
		  $('.rs').html("--> " + rs);
		}
	})  
	})

			$('.findall').click(function(){
	$.ajax({
		'type':'GET',
		'url':'${pageContext.request.contextPath}/jt/findall', 
		 success:function(response){   
			 var ln = response.pd.length;
			 var rs='';   
			 for(var i=0;i<ln;i++){
			 rs += 'Id: ' + response.pd[i].id + ' Name:' + response.pd[i].name + ' Email:'+ response.pd[i].email + ' Password:'+ response.pd[i].password+'<br>';
			 }
		  $('.rs').html("--> " + rs);
		}
	})  
	})         
})
</script>
</body>
</html>