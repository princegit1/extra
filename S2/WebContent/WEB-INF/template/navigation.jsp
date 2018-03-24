<%
String navUrl = request.getRequestURI();
String activeClass = "class='active'";
//out.println(navUrl);  
%>

<div class="nav_ltop_container">
  <div class="container">
    <div class="row">
    <!--col-lg-8 col-md-8 col-sm-8 col-xs-7 -->
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="nav_ltop">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide"><a    <%
              if(navUrl.matches("/goal/2017/") || navUrl.matches("/goal/2017/index.jsp")){
                out.println(activeClass);
              }  
              %> href="index" title="">Home</a></div>
              <div class="swiper-slide"><a href="programme" title="">Programme</a></div>
              <div class="swiper-slide"><a href="speakers" title="">Speakers</a></div>
            <!--   <div class="swiper-slide"><a href="speakers.html" title="">Videos</a></div> -->
            
            </div>
          </div>
                           
        </div>
      </div>
      <!--<div class="col-lg-4 col-md-4 col-sm-4 col-xs-5">
        <div class="register_lt"><a href="registration.jsp" title="" class="registext">Register  now</a></div>
      </div> -->
    </div>
  </div>
</div>
<!--end navigation -->
<div class="clearfix"></div>


<div class="container">
  <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12 hidden-xs text-center marginbottom20">
    
    <div class="topAddCode"><!-- Ad Slot 1 tag: --> 
        <!-- begin ZEDO for channel: IT_Other_YouthSummit, Publisher: India Today, Ad Dimension: Super Banner-728x90 -->
<!--         <div id="zt_209516_1" style="display:show""> 
          <script id="zt_209516_1" language="javascript"> 

if(typeof zmt_mtag !='undefined' && typeof zmt_mtag.zmt_render_placement !='undefined')
{
     zmt_mtag.zmt_render_placement(p209516_1);
}
 </script>
          <div class="clear"></div>
        </div> -->
        <!-- end ZEDO for channel:  IT_Other_YouthSummit, Publisher: India Today, Ad Dimension: Super Banner-728x90 --> 
        
      </div>
      
      
      <!--<div class=""> <img src="http://media2.intoday.in/indiatoday/goal/2017/img/ad_img.jpg" alt="" /> </div> -->
    </div>
  </div>
</div>
<div class="clearfix"></div>