
<div class="speakers_container">
	<div class="hdn_ltop_sp">Speakers</div>
	<div class="hdn_ltop_cont">
		<div class="row speakerImgSec"></div>
	</div>
</div>

<script>
	$(document)
			.ready(
					function() {
						var t2, t1;
						t1 = performance.now();
						var IMGPATH = 'http://media2.intoday.in/indiatoday/goal/2017/img/speakers/';

						var imgArr = [
								{
									"imagename" : "nita-ambani.png",
									"speakerName" : "Nita Ambani",
									"designation" : "Chairperson , ISL"
								},
								{
									"imagename" : "abhishek.png",
									"speakerName" : "Abhishek Bachchan",
									"designation" : "Owner, Chennaiyin FC"
								},
								{
									"imagename" : "Ranbir-Kapoor.png",
									"speakerName" : "Ranbir Kapoor",
									"designation" : "Owner, Mumbai City FC"
								},
								{
									"imagename" : "john.png",
									"speakerName" : "John Abraham",
									"designation" : "Owner, North East United FC"
								},
								{
									"imagename" : "Sourav-Ganguly.png",
									"speakerName" : "Sourav Ganguly",
									"designation" : "Owner, Athletico de Kolkata FC "
								},
								{
									"imagename" : "Baichung-Bhutia.png",
									"speakerName" : "Baichiung Bhutia",
									"designation" : "Ex Indian Football Captain"
								},
								{
									"imagename" : "Pawan-Munjal.png",
									"speakerName" : "Pawan Munjal",
									"designation" : "Managing Director Hero Motors"
								},
								{
									"imagename" : "Sajjan-Jindal.png",
									"speakerName" : "Sajjan Jindal",
									"designation" : "Chairman & Managing Director , JSW Group "
								},
								{
									"imagename" : "Sanjeev-Goenka.png",
									"speakerName" : "Sanjeev Goenka",
									"designation" : "Chairman , Sanjeev Goenka Group"
								},
								{
									"imagename" : "Vijay-Goel.png",
									"speakerName" : "Vijay Goel",
									"designation" : "Minister of Youth Affairs & Sports"
								}

						];
						var imgOut = '';
						$(imgArr)
								.each(
										function(i) {
											imgOut += '<div class="col-lg-3 col-md-3 col-sm-4 col-xs-6 marginbottom20"><div class="speaker_box"><div class="speaker_img"><img src="'+IMGPATH+imgArr[i].imagename+'" alt="img" class="speaker_img"></div><div class="speaker_name"><h5>'
													+ imgArr[i].speakerName
													+ '</h5><p>'
													+ imgArr[i].designation
													+ '</p></div></div></div>';

										})
						$('.speakerImgSec').html(imgOut);

						t2 = performance.now();

					})
</script>
