function move(node ,target) {
	clearInterval(node.timer);
	node.timer = setInterval(function() {
		var speed = (target-node.alpha)/6;
		if(speed>0){
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(node.alpha == target){
			clearInterval(node.timer);
		}else{
			node.alpha += speed;
			node.style.opacity = node.alpha/100;
			node.style.filter = "alpha(opacity:"+node.alpha+")";
		}
	}, 30);
}

window.onload = function() {
	var divs = document.getElementsByTagName("div");
	for(var i=0; i<divs.length; i++){
		divs[i].alpha = 100;
		divs[i].onmouseover = function() {
			move(this, 30);
		}
		divs[i].onmouseout = function() {
			move(this, 100);
		}
	}
};
