// 通用函数开始
// 获取元素属性
function getStyle(obj, name) {
	if(obj.currentStyle){
		return obj.currentStyle[name];
	}else{
		return getComputedStyle(obj, false)[name];
	}
}

// 节点任意属性的缓冲运动（节点，属性，目标值）
function move(node, attribute, target) {
	clearInterval(node.timer);
	node.timer = setInterval(function() {
		var cur;
		if(attribute=="opacity"){
			cur = Math.round(parseFloat(getStyle(node, attribute))*100);
		}else {
			cur = parseInt(getStyle(node, attribute));
		}
		var speed = (target-cur)/10;
		if(speed>0){
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(cur == target){
			clearInterval(node.timer);
		}else{
			cur += speed;
			if(attribute=="opacity"){
				node.style.opacity = cur/100;
				node.style.filter = "alpha(opacity:"+cur+")";
			}else{
				node.style[attribute] = cur+"px";
			}
		}
	}, 30);
}

// 查找一个元素下的所有此类元素
function getByClass(parentNode, className) {
	var childs = parentNode.getElementsByTagName("*");
	var classArr = [];
	for(var i=0; i<childs.length; i++){
		if(childs[i].className.indexOf(className) != -1){
			classArr.push(childs[i]);
		}
	}
	return classArr;
}
// 通用函数结束

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

// 开始播放主函数
function play() {
		
	var carousel = document.getElementById("carousel");
	var big = getByClass(carousel, "big")[0];
	var prev = getByClass(big, "prevArea")[0];
	var prevBtn = getByClass(big, "prevBtn")[0];
	var next = getByClass(big, "nextArea")[0];
	var nextBtn = getByClass(big, "nextBtn")[0];
	var bigLis = big.getElementsByTagName("li");
	var oUl = getByClass(carousel, "imgs")[0].getElementsByTagName("ul")[0];
	var lis = oUl.getElementsByTagName("li");

	// 图片高度
	var imgHeight = parseInt(getStyle(big.getElementsByTagName("img")[0], "height"));
	// ul移动的最大值
	var moveMax = parseInt(getStyle(oUl.parentNode, "width"))-parseInt(getStyle(oUl, "width"));
	// 移动一个小图的距离
	var moveOne = parseInt(getStyle(lis[0], "width"))+2*parseInt(getStyle(lis[0], "margin"));

	// 初始化
	var now = 0;
	move(lis[now], "opacity", 100);
	prevBtn.opacity = 0;
	nextBtn.opacity = 0;
	var zIndex = 1;
	bigLis[0].style.zIndex = zIndex;
	prev.style.zIndex = "999";
	next.style.zIndex = "999";
	prevBtn.style.zIndex = "999";
	nextBtn.style.zIndex = "999";
	for(var i=0; i<bigLis.length; i++) {
		bigLis[i].style.overflow = "hidden";
		lis[i].setAttribute("index", i);
	}
	
	// 左右按钮淡入淡出
	prev.onmouseover = function() {
		move(prevBtn, "opacity", 70);
	};
	prev.onmouseout = function() {
		move(prevBtn, "opacity", 0);
	};
	next.onmouseover = function() {
		move(nextBtn, "opacity", 70);
	};
	next.onmouseout = function() {
		move(nextBtn, "opacity", 0);
	};
	prevBtn.onmouseover = function() {
		move(this, "opacity", 100)
	};
	nextBtn.onmouseover = function() {
		move(this, "opacity", 100)
	};

	// 小图效果
	tab();

	// 点击prev按钮切换图片
	prevBtn.onclick = function() {
		now = moveByBtn("prev");
	};
	// 点击next按钮切换图片
	nextBtn.onclick = function() {
		now = moveByBtn("next");
	};

	// 自动播放
	autoPlay(carousel, nextBtn.onclick);


	// 小图效果
	function tab() {
		for(var i=0; i<lis.length; i++){
			// 下方图片淡入淡出
			lis[i].onmouseover = function() {
				move(this, "opacity", 100);
			};
			lis[i].onmouseout = function() {
				if(this.getAttribute("index") != now) {
					move(this, "opacity", 50);
				}
			};
			// 点击小图切换大图
			lis[i].onclick = function() {
				var thisIndex = this.getAttribute("index");
				now = moveBySmall(thisIndex);
			};
		}	
	}

	// 移动小图位置
	function moveSmall(len) {
		if(len>0) {
			move(oUl, "left", 0);
		}
		if(len<moveMax) {
			move(oUl, "left", moveMax);
		}
		if(len>=moveMax && len<=0) {
			move(oUl, "left", len);
		}
	}

	// 修改大图
	function changeBig() {
		// 改变大图
		bigLis[now].style.zIndex = zIndex++;

		// 下拉效果
		bigLis[now].style.height="0";
		move(bigLis[now], "height", imgHeight);
	}

	// 通过小图切换图片
	function moveBySmall(thisIndex) {
		// 还原被换小图
		move(lis[now], "opacity", 50);

		// 修改now
		now = thisIndex;

		// 修改大图
		changeBig();

		// 移动小图
		var len = -moveOne*(thisIndex-1);
		moveSmall(len);

		return now;
	}

	// 通过左右按钮移动图片
	function moveByBtn(whichBtn) {
		// 还原被换小图
		move(lis[now], "opacity", 50);

		// 改变当前图片位置
		if(whichBtn=="prev"){
			now--;
		}else{
			now++;
		}
		if(now==-1) now=lis.length-1;
		if(now==lis.length) now=0;

		// 修改大图
		changeBig();
		
		// 移动小图
		var len = -moveOne*(now-1);
		moveSmall(len);

		// 改变小图淡入淡出
		move(lis[now], "opacity", 100);

		return now;
	}

}

window.onload = function() {
	play();
};