//config
$float_speed = 1500; //milliseconds
$float_easing = "easeOutQuint";
$menu_fade_speed = 500; //milliseconds
$closed_menu_opacity = 0.75;

//cache vars
$fl_menu = $("#fl_menu");
$fl_menu_menu = $("#fl_menu .menu");
$fl_menu_label = $("#fl_menu .label");
var menuPosition;
$(window).load(function() {
	menuPosition = $('#fl_menu').position().top;
	FloatMenu();
	$fl_menu.hover(

	function() { //mouse over
		$fl_menu_label.fadeTo($menu_fade_speed, 1);
		$fl_menu_menu.fadeIn($menu_fade_speed);
	},

	function() { //mouse out
		$fl_menu_label.fadeTo($menu_fade_speed, $closed_menu_opacity);
		$fl_menu_menu.fadeOut($menu_fade_speed);
	});
});

$(window).scroll(function() {
	FloatMenu();
});

function FloatMenu() {
	var scrollAmount = $(document).scrollTop();
	var newPosition = menuPosition + scrollAmount;
	if ($(window).height() < $fl_menu.height() + $fl_menu_menu.height()) {
		$fl_menu.css("top", menuPosition);
	} else {
		$fl_menu.stop().animate({
			top: newPosition
		}, $float_speed, $float_easing);
	}
}

//隐藏，显示
$(document).ready(function(){
	var movemenu = $(".menulabel");
	var submovemenu = $(".menu_item");
	$(window).scroll(function(){
		if ($(window).scrollTop()>450){//如果滚动条顶部的距离大于xxx就cuxian
/* 				movemenu.css({
				"display":"block"
			}); */
			movemenu.fadeIn();
			submovemenu.fadeIn();
		}else{
			movemenu.fadeOut();
			submovemenu.fadeOut();
		}
	});
});