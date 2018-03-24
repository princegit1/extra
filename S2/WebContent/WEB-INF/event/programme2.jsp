<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!public static final String MEDIA_PATH = "http://media2.intoday.in/indiatoday/goal/2017/img/speakers/";%>
<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="prog_lallantop">
			<div class="hdn_lt">Programme</div>
			<div class="cont_lt">
				<p>Goal 2017 is an event designed especially for the youth. The
					daylong conference is a forum that bright young minds to interact
					in an open two-way conversation with their icons. A space where
					inspirational leaders from different spheres of life share their
					success stories. A festival that celebrates throungh ideas, music
					and art by recognizing the best in the field and also giving youth
					a stage to create, perform and engage.</p>
				<br>

			</div>
		</div>
		<div class="clearfix"></div>
		<div class="like_follow_us">
			<span class="txt_lf"></span> <span class="socials_ltab"></span>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<div class="progamme_panel">
	<c:forEach var="p" items="${list}" varStatus="i">
		<div class="row box_rtprogramme">
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<div class="timing_l">${p.time }</div>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<div class="prog_container">
					<div class="prog_rt_heading">${p.heading }</div>
					<div class="session_ltop_cov">
						<div class="session_inner_cont">
							<div class="row">
                  
								<c:forEach var="e" items="${listsp}" varStatus="status1">

									<c:if test="${p.pid == e.pid}">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="speaker_profile">
												<div class="speaker_txt">Speaker:</div>
												<div class="speaker_details">
													<span class="speaker_image"><img
														src="<%=MEDIA_PATH %>${e.image}"
														alt="" class="speaker_img" /></span> <span class="speaker_dt">
														<span class="hdn">${e.name }</span> <span
														class="desc_l">${e.designation }</span>
													</span>
												</div>
											</div>
										</div>
									</c:if>


								</c:forEach>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

</div>


