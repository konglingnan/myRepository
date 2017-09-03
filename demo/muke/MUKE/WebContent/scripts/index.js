$(document).ready(function(){
	slider();
	toTop();
	changeList();
	// initial();
	addQuestion();
	comment();
});

// 轮播图start
function slider() {
	var now = 0;
	// 大图列表
	var ImgLis = $(".bigImgs").children("li");
	// 小点列表
	var pointLis = $(".point").children("li");
	// 初始化
	var now = 0;
	$(ImgLis[now]).css("display", "block");
	// 鼠标移入小点
	tab();
	// 上一个按钮
	$(".button1").click(function() {
		change("prev");
	});
	// 下一个按钮
	$(".button2").click(function() {
		change("next");
	});
	// 自动播放
	autoPlay($(".slider"), function() {
		change("next");
	});
	// 鼠标移入小点
	function tab() {
		for(var i=0; i<pointLis.length; i++) {
			pointLis[i].index = i;

			// 鼠标移入
			$(pointLis[i]).mouseenter(function() {
				// 还原小点和大图
				$(pointLis[now]).removeClass("current");
				$(ImgLis[now]).fadeOut();

				// 切换大图
				now = this.index;
				$(ImgLis[now]).fadeIn();
			
				// 小点添加current
				$(pointLis[now]).addClass("current");
			});
		}
	}
	// 左右按钮切换
	function change(which) {
		// 还原小点和被换大图
		$(pointLis[now]).removeClass("current");
		$(ImgLis[now]).fadeOut();

		// 切换大图
		if(which=="prev") now--;
		if(which=="next") now++;
		if(now==pointLis.length) now = 0;
		if(now==-1) now = pointLis.length-1;
		$(ImgLis[now]).fadeIn();
		// 小点添加current
		$(pointLis[now]).addClass("current");
	}
	// 自动播放
	function autoPlay(areaNode, func) {
		var autoTimer = setInterval(func, 2000);
		areaNode.mouseenter(function() {
			clearInterval(autoTimer);
		});
		areaNode.mouseleave(function() {
			autoTimer = setInterval(func, 2000);
		});
	}
}
// 轮播图end

// 到顶部start
function toTop() {
	$(".top").click(function(event) {
		$("html body").animate({scrollTop:0}, 400);
	});
	$(window).scroll(function(event) {
		if($(window).scrollTop()>500){
			$(".top").fadeIn("400");
		}else {
			$(".top").fadeOut("400");
		}
	});
}
// 到顶部end

// 点击改变start
function changeList() {

	$(".first li").click(function(){
		$(this).addClass("current").siblings().removeClass("current");
		$(".second li").hide();
		$("."+this.getAttribute("id")).show();
		$(".second .all").show().addClass("current").siblings().removeClass("current");
	});

	$(".second li, .third li, .dir li").click(function(){
		$(this).addClass("current").siblings().removeClass("current");
	});

	// 点击全部取消所有其他
	$(".dir .all").click(function(){
		$(this).siblings().removeClass("current");
		if($(this).parent().parent().hasClass("first")){
			$(".second").find("li").show();
		}
	});


	// // 点击li改变其样式
	// $(".dir li").click(function(){
	// 	$(this).toggleClass("current");
	// });
	// // 点击li
	// $(".dir .all").siblings().click(function(){
	// 	if($(this).siblings(".all").hasClass("current")){
	// 		// 取消全部
	// 		$(this).siblings(".all").removeClass("current");
	// 		if($(this).parent().parent().hasClass("first")){
	// 			// 隐藏所有分类
	// 			$(".second").find("li").hide();
	// 			$(".second .all").show();
	// 			// 隐藏所选分类
	// 			$("."+this.getAttribute("id")).hide();
	// 		}
	// 	}
	// });

	// 点击全部取消所有其他
	// $(".dir .all").click(function(){
	// 	$(this).siblings().removeClass("current");
	// 	if($(this).parent().parent().hasClass("first")){
	// 		$(".second").find("li").show();
	// 	}
	// });

	// $("#front").click(function(){
	// 	$(".front").toggle();
	// });
	// $("#back").click(function(){
	// 	$(".back").toggle();
	// });
	// $("#mobile").click(function(){
	// 	$(".mobile").toggle();
	// });
	// $("#data").click(function(){
	// 	$(".data").toggle();
	// });
	// $("#img").click(function(){
	// 	$(".img").toggle();
	// });
}
// 点击改变end

// 社区start
function addQuestion() {
	$("#find").click(function() {
		$(".myModal").fadeIn();
	})
	$("#submit").click(function(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		
		var question_user = sessionStorage.getItem("username");
		var question_title = $("#question_title").val();
		var question_time = year+"-"+month+"-"+day+"-"+hour+":"+minute+":"+second;

		if(question_user == null || question_user == "" || question_user == "null") {
			question_user = "游客";
		}

		$.post("addQuestion.action", {
			question_user : question_user,
			question_title : question_title,
			question_time : question_time
		}, function(data, status){
			var str = "";
			str += '<div class="liuyan-i clearfix">'+
						'<div class="lt">'+
							'<a href="#" class="a_img">'+
								'<img src="imgs/mukeee.png" alt="">'+
							'</a>'+
							'<a href="#" class="a_img_tip">'+question_user+'</a>'+
						'</div>'+
						'<div class="md ">'+
							'<div class="md-left">'+
								'<i class="i">88</i>'+
								'<span>顶</span>'+
								'<a href="#">'+ question_title+'</a>'+
							'</div>'+
							'<div class="md-left">'+
								'<i class="i2">88</i>'+
								'<span class="span2">[最新回答]</span>'+
								'<span class="span3 who"><a href="#"></a></span>'+
								'<span class="span2 what">无</span>'+
							'</div>'+

							'<div class="md-left1">'+
								'<span class="time-span">提问时间：'+question_time+'</span>'+
							'</div>'+
						'</div>'+
						'<div class="ri clearfix">'+
								'<div class="ri-l">'+
									'<div class="number"></div>'+
									'<div class="comment"><input type="text/area"><a href="#" class="btn btn-submit">评论</a></div>'+
								'</div>'+
								'<div class="ri-r">'+
									'<div class="liulan">0浏览</div>'+
								'</div>'+
							'</div>'+
					'</div>';

					$(".liuyan-list").prepend(str);
		});
		$(".myModal").fadeOut();
	});
}

function comment() {
	$(".comment").click(function() {
		var who = sessionStorage.getItem("username");
		var what = $(this).parent().find("input").val();
		if(who=="null" || who==null || who=="") {
			who = "游客";
		}
		if(what=="") {
			return;
		}
		$(this).parent().parent().parent().find(".who").find("a").text(who);
		$(this).parent().parent().parent().find(".what").text(what);
		$(this).parent().find("input").val("");
	});
}
// 社区end