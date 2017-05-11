$(document).ready(function(){
	navImg();
	slider();
    news();
    mmm();
});
// 导航栏
function navImg(){
	$("nav li").each(function(){
		$(this).mouseenter(function(){
			$(this).children("img").show();
		}).mouseleave(function(){
			$(this).children("img").hide();
		});
	});
}
// 轮播图
function slider(){
    var zIndex = 0;
	var a=0, x=0;
    // 自动播放
    var auto = setInterval(autoPlay, 2000);
    $(".wrap > ol > li").mouseenter(function () {
        zIndex++;
        $(this).addClass("active").siblings().removeClass("active");
        $(".wrap > ul > li")
            .eq($(this).index())
            .css({
                "z-index": zIndex,
                "left": 650
            })
            .animate({
                "left": 0
            }, 1000);
        clearInterval(auto);
    }).mouseleave(function(){
        auto = setInterval(autoPlay, 2000);
    });
    function autoPlay(){
        x = a++%5;
        $(".wrap > ol > li").eq(x).addClass("active").siblings().removeClass("active");
        $(".wrap > ul > li")
            .eq(x)
            .css({
                "z-index": ++zIndex,
                "left": 650
            })
            .animate({
                "left": 0
            }, 1000);
    }
}
// 新闻
function news(){
    $(".news li").mouseenter(function(){
        $(this).css("color", "#000").siblings().css("color", "#ccc");
        $(this).children("img").show()
        $(this).siblings().children("img").hide();
    });
}
// 购买区域
function mmm(){
    $(".mmm li").mouseenter(function(){
        $(this).css("background", "#e50").siblings().css("background", "");
        // 注：这个路径以html位置为基准，因为这个样式是加在html行内的
        $(".mmm").css("background", "url(images/bg"+$(this).index()+".jpg)");
    });
}