<%@ include file="meta-details.jsp"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>

<title><%=META_PROGRAM_TITLE%></title>
<meta name="description" content="<%=META_PROGRAM_KEYWORD%>" />
<meta name="keywords" content="<%=META_PROGRAM_DESCRIPTION%>" />

<%@ include file="css_include.jsp"%>
<%@ include file="ga_comscore.jsp"%>

</head>
<body>

	<%@ include file="header.jsp"%>
	<%@ include file="navigation.jsp"%>
	<h1
		style="font-size: 0px; visibility: hidden; margin: 0px; padding: 0px;"><%=PROGRAM_H1%></h1>

	<div class="container ">
		<div class="row ">
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
      <div class="row" id="registraiton_ltop_container">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
          <div class="heading_lt">Registration</div>
          <div class="cont_lt">
            <div class="cont_txt">Fill out the form to register to our event</div>
            <div class="form_cont">
              <form name="form_ltop" method="post" action="">
                <div class="row">
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 marginbottom20">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" id="name" />
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 marginbottom20">
                    <label>Email</label>
                    <input type="text" class="form-control"  name="email" id="email"  />
                  </div>
                </div>
                <div class="row">
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 marginbottom20">
                    <label>Phone</label>
                    <input type="text" class="form-control" name="phone" id="phone" />
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 marginbottom20">
                    <label>Captcha</label>
                    <div class="row">
                      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <input type="text" class="form-control" name="phone" id="phone" />
                        <img src="" class="captcha_lt" /> </div>
                      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <input type="button" class="btn btn-pink" value="Register" data-toggle="modal" data-target="#myModal" />
                      </div>
                    </div>
                  </div>
                </div>
                <div id="myModal" class="modal fade" role="dialog">
                  <div class="modal-dialog"> 
                    
                    <!-- Modal content-->
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Please enter otp</h4>
                      </div>
                      <div class="modal-body">
                        <p>One Time Password</p>
                        <div class="row">
                          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control" />
                          </div>
                          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 paddingtop5">Otp is sent to your password</div>
                        </div>
                        <div class="row marginbottom20 margintop20">
                          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <input type="submit" class="btn btn-pink" />
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
			<!--end left area -->

			<%@ include file="registration-right-sidebar.jsp"%>
			<!--end right side -->
		</div>
	</div>


	<%@ include file="footer.jsp"%>
	<%@ include file="js_include.jsp"%>
	</body>
			</html>