$(document).scroll(function(){
	searchTop();
});

$(document).ready(function(){
	adClose();
	tabBar();
	sendCity();
	searcher();
	classifyImg();
	slider();
});

// 上方固定搜索栏
function searchTop() {
	var search = $(".search-top");
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	if(scrollTop >= 400) {
		search.slideDown();
	}
	if(scrollTop < 400) {
		search.slideUp();
	}
}

// 关闭广告
function adClose() {
	$(".banner-ad-close").click(function(){
		$(".banner").fadeOut("2000");
	});
}

// 右侧边栏
function tabBar() {
	$(".rightBar").find("li").each(function(){
		// 移入显示
		$(this).mouseenter(function(){
			var em = $(this).find("em");
			if(em) {
				var len = parseInt(getStyle(em.get(0), "width"))-5;
				$(em).animate({left: -len});
			}
		}).mouseleave(function(){
			var em = $(this).find("em");
			if(em) {
				$(em).animate({left: 35});
			}
		});
	});
}

// 送达城市
function sendCity() {
	var citys = ["北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南"];
	var cityUl = $(".side-nav-l-city").children("ul");
	// 创建<li><a href="javascript:void(0)">"城市"</a></li>
	for(var i=0; i<citys.length; i++){
		cityUl.append('<li><a href="javascript:void(0)">'+citys[i]+'</a></li>');
	}
	// 初始化
	$(cityUl.children()[0]).addClass("active");
	// 点击城市切换样式
	cityUl.children("li").each(function(){
		$(this).click(function() {
			$(this).siblings().each(function(){
				$(this).removeClass("active");
			});
		$(this).addClass("active");
		window.open("");
		});
	});
}

// 搜索栏
function searcher() {
	$(".search-input-search").children("input").focus(function() {
		$(this).removeAttr("placeholder");
	}).blur(function() {
		$(this).attr("placeholder", "洗衣机");
	});
}

// 商品分类
function classifyImg() {
	$(".classify-l").find("li").each(function(){
		$(this).mouseenter(function(){
			$(this).siblings().children("img").hide();
			$(this).children("img").show();
		});
		$(this).mouseleave(function(){
			$(this).children("img").hide();
		});
	});
}

// 轮播图
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

// 获取元素属性值
function getStyle(obj, name) {
	if(obj.currentStyle){
		return obj.currentStyle[name];
	}else{
		return getComputedStyle(obj, false)[name];
	}
}
