// 关闭广告开始
function adClose() {
	var body = document.getElementsByTagName("body")[0];
	var banner = getByClass(body, "banner")[0];
	var closeBtn = getByClass(banner, "banner-ad-close")[0];
	closeBtn.onclick = function() {
		move(banner, {opacity:0}, function() {
			banner.style.display = "none";
		});
	}
}
// 关闭广告结束

// 送达城市开始
function sendCity() {
	var citys = ["北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南", "辽宁", "吉林", "黑龙江", "内蒙古", "江苏", "山东", "北京", "上海", "天津", "重庆", "河北", "河南"];
	var body = document.getElementsByTagName("body")[0];
	var cityBtn = getByClass(body, "side-nav-l")[0];
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
	for(var i=0; i<cityLis.length; i++) {
		cityLis[i].onclick = function() {
			for(var i=0; i<cityLis.length; i++) {
				cityLis[i].className = "";
			}
			this.className = "active";
			window.open("");
		}
		cityLis[i].getElementsByTagName("a")[0].onmouseover = function() {
			this.className = "hover";
		}
		cityLis[i].getElementsByTagName("a")[0].onmouseout = function() {
			this.className = "";
		}
	}

	var banner = getByClass(body, "banner")[0];
	var nav = getByClass(body, "side-nav")[0];
	var height = banner.offsetHeight+nav.offsetHeight;
	
	cityArea.style.top = height+"px";

	addClass(cityUl.childNodes[0], "active");

	// 移入移出效果
	// cityBtn.onmouseover = function() {
	// 	cityArea.style.display = "block";
	// }
	// cityBtn.parentNode.onmouseout = function() {
	// 	cityArea.style.display = "none";
	// }

}
// 送达城市结束

// 轮播图开始
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
	}

	// 下一个按钮
	nextBtn.onclick = function() {
		change("next");
	}

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
			}
		}
	}
	
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
}

// 自动播放
function autoPlay(areaNode, func) {
	var autoTimer = setInterval(func, 2000);
	areaNode.onmouseover=function() {
		clearInterval(autoTimer);
	}
	areaNode.onmouseout=function() {
		autoTimer = setInterval(func, 2000);
	}	
}
// 轮播图结束

addLoadEvent(slider);
addLoadEvent(adClose);
addLoadEvent(sendCity);