
// 轮播图部分
function slider() {
	var now = 0;
	var body = document.getElementsByTagName("body")[0];
	var slider = getByClass(body, "slider")[0];
	var point = getByClass(slider, "point")[0];
	// 大图节点
	var bigImgs = getByClass(slider, "bigImgs")[0];
	// 小点
	var pointLis = point.getElementsByTagName("li");

	// 左右按钮
	var prevBtn = getByClass(slider, "button1")[0];
	var nextBtn = getByClass(slider, "button2")[0];

	// 初始化
	var now = 0;
	pointLis[0].className = "current";

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
				// 还原小点
				pointLis[now].className = "";

				// 切换大图
				now = this.index;
				var json = {left:-now*730};
				move(bigImgs, json);
			
				// 小点添加current
				pointLis[now].className = "current";
			}
		}
	}
	
	function change(which) {
		// 还原小点
		pointLis[now].className="";

		// 切换大图
		if(which=="prev") now--;
		if(which=="next") now++;
		if(now==pointLis.length) now = 0;
		if(now==-1) now = pointLis.length-1;
		var json = {left:-now*730};
		move(bigImgs, json);
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


addLoadEvent(slider);