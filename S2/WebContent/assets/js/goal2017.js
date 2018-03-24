$(document).ready(function(){
 var swiper = new Swiper('.nav_ltop_container .swiper-container', {
        pagination: '.nav_ltop_container .swiper-pagination',
        slidesPerView: 'auto',
        spaceBetween: 40
    });	
 
  var swiper = new Swiper('.ltop_slider_container .swiper-container', {
 nextButton: '.swiper-button-next_lt',
        prevButton: '.swiper-button-prev_lt'
    });		
  

   var moretext = "More[+]";
    var lesstext = "Less[-]";
  $(".more_less").click(function(){
        if($(this).hasClass("more")) {
			
            $(this).removeClass("more");
            $(this).html(lesstext);
			$('.about_the_lallantop .cont_lt p,.speaker_box_cont p').css('display','block');
			
			
        } else {
			   $(this).addClass("more");
            $(this).html(moretext);
			$('.about_the_lallantop .cont_lt p,.speaker_box_cont p').css('display','none');	
			$('.about_the_lallantop .cont_lt p,.speaker_box_cont p').first().css('display','inline');

         
        }
    });
  
  
  
					   
})
