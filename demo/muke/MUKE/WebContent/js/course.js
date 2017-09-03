$(document).ready(function(){
	 $('.top').click(function(event) {
	 	$('html,body').animate({scrollTop:0}, 400);
	 });

	 $(window).scroll(function(event) {
	 	if($(window).scrollTop() > 500){
	 		$('.top').fadeIn('400');
	 	}
	 	else{
	 		$('.top').fadeOut('400');
	 	}
	 });
});