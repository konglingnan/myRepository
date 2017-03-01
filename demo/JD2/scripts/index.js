
// 右侧边栏start
function tabBar() {
	var body = document.getElementsByTagName("body")[0];
	var rightBar = getByClass(body, "rightBar")[0];
	var lis = rightBar.getElementsByTagName("li");

	// 移入显示，移出缩回
	for(var i=0; i<lis.length; i++) {
		lis[i].index = i;
		lis[i].onmouseover = function () {
			var em = this.getElementsByTagName("em")[0];
			if(em) {
				var len = parseInt(getStyle(em, "width"))-5;
				move2(em, {left: -len});
			}
		};
		lis[i].onmouseout = function () {
			var em = this.getElementsByTagName("em")[0];
			if(em) {
				move2(em, {left: 35});
			}
		};
	}
}
// 右侧边栏end

// 关闭广告start
function adClose() {
	var body = document.getElementsByTagName("body")[0];
	var banner = getByClass(body, "banner")[0];
	var closeBtn = getByClass(banner, "banner-ad-close")[0];
	closeBtn.onclick = function() {
		move(banner, {opacity:0}, function() {
			banner.style.display = "none";
		});
	};
}
// 关闭广告end

// 送达城市start
function sendCity() {
	var citys = ["北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南"];
	var body = document.getElementsByTagName("body")[0];
	var cityArea = getByClass(body, "side-nav-l-city")[0];
	var cityUl = cityArea.getElementsByTagName("ul")[0];
	// 创建<li><a href="javascript:void(0)">"城市"</a></li>
	for(var i=0; i<citys.length; i++){
		var cityLi = document.createElement("li");
		var cityA = document.createElement("a");
		cityA.setAttribute("href", "javascript:void(0)");
		cityA.innerHTML = citys[i];
		cityLi.appendChild(cityA);
		cityUl.appendChild(cityLi);

	}

	var cityLis = cityUl.getElementsByTagName("li");
	// 初始化
	addClass(cityUl.childNodes[0], "active");
	// 点击城市切换样式
	for(var i=0; i<cityLis.length; i++) {
		cityLis[i].onclick = function() {
			for(var i=0; i<cityLis.length; i++) {
				cityLis[i].className = "";
			}
			this.className = "active";
			window.open("");
		};
	}
}
// 送达城市end

// 搜索栏start
function search() {
	var body = document.getElementsByTagName("body")[0];
	var searchInputs = getByClass(body, "search-input-search")[0].getElementsByTagName("input");
	for(var i=0; i<searchInputs.length; i++) {
		searchInputs[i].onfocus = function() {
			this.setAttribute("placeholder", "");
		};
		searchInputs[i].onblur = function() {
			this.setAttribute("placeholder", "洗衣机");
		};
	}
}
// 搜索栏end

// 上方固定搜索栏start'
function searchTop() {
	var body = document.getElementsByTagName("body")[0];
	var search = getByClass(body, "search-top")[0];
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	if(scrollTop < 600) {
		// search.style.top = "-53px";
		move(search, {top:-53});
	}
	if(scrollTop >= 600) {
		move(search, {top:0});
	}
}
// 上方固定搜索栏end

// 轮播图start
function slider() {
	var now = 0;
	var body = document.getElementsByTagName("body")[0];
	var slider = getByClass(body, "slider")[0];
	var point = getByClass(slider, "point")[0];
	var bigImgs = getByClass(slider, "bigImgs")[0];
	// 大图列表
	var ImgLis = bigImgs.getElementsByTagName("li");
	// 小点列表
	var pointLis = point.getElementsByTagName("li");

	// 左右按钮
	var prevBtn = getByClass(slider, "button1")[0];
	var nextBtn = getByClass(slider, "button2")[0];

	// 初始化
	var now = 0;
	move(ImgLis[now], {opacity:100});

	// 鼠标移入小点
	tab();

	// 上一个按钮
	prevBtn.onclick = function() {
		change("prev");
	};

	// 下一个按钮
	nextBtn.onclick = function() {
		change("next");
	};

	// 自动播放
	autoPlay(slider, nextBtn.onclick);

	// 鼠标移入小点
	function tab() {
		for(var i=0; i<pointLis.length; i++) {
			pointLis[i].index = i;

			// 鼠标移入
			pointLis[i].onmouseover = function() {
				// 还原小点和大图
				pointLis[now].className = "";
				move(ImgLis[now], {opacity:0});

				// 切换大图
				now = this.index;
				move(ImgLis[now], {opacity:100});
			
				// 小点添加current
				pointLis[now].className = "current";
			};
		}
	}
	
	// 左右按钮切换
	function change(which) {
		// 还原小点和被换大图
		pointLis[now].className="";
		move(ImgLis[now], {opacity:0});

		// 切换大图
		if(which=="prev") now--;
		if(which=="next") now++;
		if(now==pointLis.length) now = 0;
		if(now==-1) now = pointLis.length-1;
		move(ImgLis[now], {opacity:100});
		// 小点添加current
		pointLis[now].className = "current";
	}
	
	// 自动播放
	function autoPlay(areaNode, func) {
		var autoTimer = setInterval(func, 2000);
		areaNode.onmouseover=function() {
			clearInterval(autoTimer);
		};
		areaNode.onmouseout=function() {
			autoTimer = setInterval(func, 2000);
		};	
	}
}
// 轮播图end

addLoadEvent(adClose);
addLoadEvent(tabBar);
addLoadEvent(sendCity);
addLoadEvent(search);
addLoadEvent(slider);
window.onscroll = function() {
	searchTop();
};