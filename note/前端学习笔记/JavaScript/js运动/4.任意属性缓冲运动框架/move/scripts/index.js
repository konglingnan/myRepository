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

window.onload = function() {
	var div1 = document.getElementById("div1");
	div1.onmouseover = function() {
		move(this, "width", 300);
	}
	div1.onmouseout = function() {
		move(this, "width", 100);
	}

	var div2 = document.getElementById("div2");
	div2.onmouseover = function() {
		move(this, "height", 300);
	}
	div2.onmouseout = function() {
		move(this, "height", 100);
	}

	var div3 = document.getElementById("div3");
	div3.opacity = 100;
	div3.onmouseover = function() {
		move(this, "opacity", 30);
	}
	div3.onmouseout = function() {
		move(this, "opacity", 100);
	}

};
