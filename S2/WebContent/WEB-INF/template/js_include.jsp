
<script src="http://media2.intoday.in/indiatoday/goal/2017/js/vendor/bootstrap.min.js"></script> 
<script src="http://media2.intoday.in/indiatoday/goal/2017/js/goal2017.js"></script>


<script>

$(document).ready(function(){
	try{
		var loc = window.location.href;
		
		var fileName = loc.split('/2017/')[1];
	//console.log(loc + "-- " + fileName);


	    $('.nav_ltop .swiper-wrapper .swiper-slide a').each(function(){
	    	var act = $(this).attr('href');
	    	//console.log("-- " + act);
	    	if(fileName==act){
	    		$(this).addClass('active');
	    	}
	    /* 	  if(fileName==''){
	 	    	 $('.nav_ltop .swiper-wrapper .swiper-slide a').addClass('active');
	 	    } */
   
	    })
	  
	}
	catch(e){
		console.log("Exception in active class in navigation: " + e);
	}




})
</script>