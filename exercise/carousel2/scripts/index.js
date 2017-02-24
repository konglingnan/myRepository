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

// 获取图片数字
function getSrcNum(imgNode) {
	var imgSrc = imgNode.getAttribute("src");
	var charArr = imgSrc.split("/");
	return parseInt(charArr[charArr.length-1].split(".")[0]);
}

window.onload = function() {

	var carousel = document.getElementById("carousel");
	var big = getByClass(carousel, "big")[0];
	var prev = getByClass(big, "prevArea")[0];
	var prevBtn = getByClass(big, "prevBtn")[0];
	var next = getByClass(big, "nextArea")[0];
	var nextBtn = getByClass(big, "nextBtn")[0];
	var bigLis = big.getElementsByTagName("li");
	var oUl = getByClass(carousel, "imgs")[0].getElementsByTagName("ul")[0];
	var lis = oUl.getElementsByTagName("li");
	
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
	}
	
	// 左右按钮淡入淡出
	prev.onmouseover = function() {
		move(prevBtn, "opacity", 100);
	};
	prev.onmouseout = function() {
		move(prevBtn, "opacity", 0);
	};
	next.onmouseover = function() {
		move(nextBtn, "opacity", 100);
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

	// 点击prev按钮切换图片
	prevBtn.onclick = function() {
		// 还原被换小图
		move(lis[now], "opacity", 50);

		// 改变当前图片位置
		now--;
		if(now==-1) now=4;

		// 改变大图
		bigLis[now].style.zIndex = zIndex++;

		// 下拉效果
		bigLis[now].style.height="0";
		move(bigLis[now], "height", 360);

		// 改变小图淡入淡出
		move(lis[now], "opacity", 100);

		// 移动下方图片
		var len = -120*(now-1);
		if(len<=-360) {
			move(oUl, "left", -240);
		}
		if(len>-360 && len<=0) {
			move(oUl, "left", len);
		}
	};

	// 点击next按钮切换图片
	nextBtn.onclick = function() {
		// 还原被换小图
		move(lis[now], "opacity", 50);

		// 改变当前图片位置
		now++;
		if(now==5) now=0;

		// 改变大图
		bigLis[now].style.zIndex = zIndex++;

		// 下拉效果
		bigLis[now].style.height="0";
		move(bigLis[now], "height", 360);

		// 改变小图淡入淡出
		move(lis[now], "opacity", 100);

		// 移动下方图片
		var len = -120*(now-1);
		if(len>=0) {
			move(oUl, "left", 0);
		}
		if(len>-360 && len<0) {
			move(oUl, "left", len);
		}
	};

	for(var i=0; i<lis.length; i++){
		// 下方图片淡入淡出
		lis[i].setAttribute("index", i);
		lis[i].onmouseover = function() {
			move(this, "opacity", 100);
		};
		lis[i].onmouseout = function() {
			if(this.getAttribute("index") != now) {
				move(this, "opacity", 50);
			}
		};
		// 点击小图切换
		lis[i].getElementsByTagName("img")[0].onclick = function() {
			var len = -120*(this.parentNode.getAttribute("index")-1);
			// 移动小图
			if(len>-360 && len<=0) {
				move(oUl, "left", len);
			}
			// 改变原小图淡出
			move(lis[now], "opacity", 50);

			// 修改now
			now = this.parentNode.getAttribute("index");

			// 改变大图
			bigLis[now].style.zIndex = zIndex++;

			// 下拉效果
			bigLis[now].style.height="0";
			move(bigLis[now], "height", 360);
		};
	}

	// 自动播放
	var autoTimer = setInterval(nextBtn.onclick, 2000);
	carousel.onmouseover=function() {
		clearInterval(autoTimer);
	}
	carousel.onmouseout=function() {
		autoTimer = setInterval(nextBtn.onclick, 2000);
	}

};