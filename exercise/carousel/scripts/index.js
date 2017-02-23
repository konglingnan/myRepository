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
	prevBtn.opacity = 0;
	var next = getByClass(big, "nextArea")[0];
	var nextBtn = getByClass(big, "nextBtn")[0];
	nextBtn.opacity = 0;
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

	var bigImg = big.getElementsByTagName("img")[0];
	var oUl = getByClass(carousel, "imgs")[0].getElementsByTagName("ul")[0];

	var lii =0;
	var lis = oUl.getElementsByTagName("li");
	
	// 点击prev按钮切换图片
	prevBtn.onclick = function() {
		// 改变当前图片位置
		lii = (--lii)%5;
		if(lii==-1) lii=4;
		var newSrc = lis[lii].getElementsByTagName("img")[0].getAttribute("src");
		var bigSrc = bigImg.setAttribute("src", newSrc);

		// 移动下方图片
		var len = -120*(lii-1);
		if(len<=-360) {
			move(oUl, "left", -240);
		}
		if(len>-360 && len<=0) {
			move(oUl, "left", len);
		}
	};

	// 点击next按钮切换图片
	nextBtn.onclick = function() {

		// 改变当前图片位置
		lii = (++lii)%5;
		var newSrc = lis[lii].getElementsByTagName("img")[0].getAttribute("src");
		var bigSrc = bigImg.setAttribute("src", lis[lii].getElementsByTagName("img")[0].getAttribute("src"));

		// 移动下方图片
		var len = -120*(lii-1);
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
			if(this.getAttribute("index") != lii) {
				move(this, "opacity", 50);
			}
		};
		// 点击切换大图和小图
		lis[i].getElementsByTagName("img")[0].onclick = function() {
			var len = -120*(this.parentNode.getAttribute("index")-1);
			if(len>-360 && len<0) {
				move(oUl, "left", len);
			}
			var imgSrc = this.getAttribute("src");
			bigImg.setAttribute("src", imgSrc);

			bigImg.style.height="0";
			move(bigImg, "height", 360);

			big.setAttribute("background", "url(../"+imgSrc+") no-repeat");
			lii = this.parentNode.getAttribute("index");
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
