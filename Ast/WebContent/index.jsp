<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CCCC</title>
</head>
<body>

<form action="a.jsp" method="post">  
<input type="text" id="name" name="name">                    
<input type="text" id="ed" name="ed1">
<input type="hidden" id="trackingDiv" name="ed">   
<input type="submit" value="Submit">  
               

</form>


<script src="ckeditor/ckeditor.js"></script>
<script>CKEDITOR.replace( 'ed' );</script>                    


<script>
timer = setInterval(updateDiv,100);
function updateDiv(){
    var editorText = CKEDITOR.instances.ed.getData();
   // $('#trackingDiv').val(editorText);
   document.getElementById('trackingDiv').value = editorText;        
   
}

     
</script>
</body>
</html>