
// 获取元素的属性
function getStyle(obj, name) {
	if(obj.currentStyle){
		return obj.currentStyle[name];
	}else{
		return getComputedStyle(obj, false)[name];
	}
}

// 节点多个属性的缓冲运动（节点，json，回调函数）
function move2(node, json, func) {
	clearInterval(node.timer);
	node.timer = setInterval(function() {
		var stop = true;
		for(var attr in json){
			var cur;
			if(attr=="opacity"){
				cur = Math.round(parseFloat(getStyle(node, attr))*100);
			}else {
				cur = parseInt(getStyle(node, attr));
			}

			var speed = (json[attr]-cur)/10;
			if(speed>0){
				speed = Math.ceil(speed);
			} else {
				speed = Math.floor(speed);
			}

			cur += speed;
			if(attr=="opacity"){
				node.style.opacity = cur/100;
				node.style.filter = "alpha(opacity:"+cur+")";
			}else{
				node.style[attr] = cur+"px";
			}

			if(cur != json[attr]) {
				stop = false;
			}
		}
		if(stop) {
			clearInterval(node.timer);
			if(func) func();
		}
	}, 30);
}
